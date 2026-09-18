import 'dart:async';

import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:algolia_client_core/src/transport/dio/dio_requester.dart';
import 'package:algolia_client_core/src/transport/rate_limit.dart';
import 'package:algolia_client_core/src/transport/retryable_host.dart';
import 'package:meta/meta.dart';

/// Component to run http requests with retry logic.
final class RetryStrategy {
  final Requester requester;
  final Duration readTimeout;
  final Duration writeTimeout;
  final List<RetryableHost> _hosts;

  /// Whether every execution mints a Request-ID, reused across its retry
  /// attempts. [ClientOptions.requestIdEnabled] overrides the generated
  /// client's setting; a caller-supplied Request-ID is never overwritten.
  final bool requestIdSupport;

  /// Whether the client default headers already carry a Request-ID, in which
  /// case minting is suppressed; computed at construction because the default
  /// requester snapshots its headers then.
  final bool hasDefaultRequestId;

  /// Whether a minted Request-ID is sent as the `x-algolia-request-id` query
  /// parameter instead of the header, as browsers require.
  final bool requestIdAsQueryParameter;

  /// How many times a 429 is waited out on the same host per execution; see
  /// [ClientOptions.maxRateLimitRetries].
  final int maxRateLimitRetries;

  /// Waits between same-host 429 retries. Not part of the supported API:
  /// tests inject a recorder here so they do not wait wall-clock.
  @visibleForTesting
  final Future<void> Function(Duration) sleep;

  /// Provides access to hosts for testing purposes.
  List<RetryableHost> get hosts => _hosts;

  /// Constructs a [RetryStrategy].
  RetryStrategy({
    required this.requester,
    required this.readTimeout,
    required this.writeTimeout,
    required Iterable<Host> hosts,
    this.requestIdSupport = false,
    this.hasDefaultRequestId = false,
    this.requestIdAsQueryParameter = platformRequestIdAsQueryParameter,
    int? maxRateLimitRetries,
    Future<void> Function(Duration)? sleep,
  })  : _hosts = hosts.map((host) => RetryableHost(host)).toList(),
        maxRateLimitRetries = resolveMaxRateLimitRetries(maxRateLimitRetries),
        sleep = sleep ?? _defaultSleep;

  static Future<void> _defaultSleep(Duration duration) =>
      Future<void>.delayed(duration);

  /// Creates [RetryStrategy], defaults to [DioRequester].
  ///
  /// [defaultConnectTimeout]/[defaultReadTimeout]/[defaultWriteTimeout] are the
  /// per-client timeouts coming from the spec. They are applied whenever the
  /// caller left the corresponding [ClientOptions] timeout unset
  /// ([ClientOptions.unsetTimeout]), so a partially-specified [ClientOptions]
  /// (e.g. only `hosts` or a custom `requester`) still honours the per-client
  /// defaults instead of silently falling back to the generic values.
  factory RetryStrategy.create({
    required AgentSegment segment,
    required String appId,
    required String apiKey,
    required Iterable<Host> Function() defaultHosts,
    ClientOptions options = const ClientOptions(),
    Duration defaultConnectTimeout = const Duration(seconds: 2),
    Duration defaultReadTimeout = const Duration(seconds: 5),
    Duration defaultWriteTimeout = const Duration(seconds: 30),
    bool requestIdSupport = false,
  }) {
    final connectTimeout = options.connectTimeout == ClientOptions.unsetTimeout
        ? defaultConnectTimeout
        : options.connectTimeout;
    final readTimeout = options.readTimeout == ClientOptions.unsetTimeout
        ? defaultReadTimeout
        : options.readTimeout;
    final writeTimeout = options.writeTimeout == ClientOptions.unsetTimeout
        ? defaultWriteTimeout
        : options.writeTimeout;

    final requester = options.requester != null
        ? (options.requester!..setConnectTimeout(connectTimeout))
        : DioRequester(
            appId: appId,
            apiKey: apiKey,
            headers: options.headers,
            connectTimeout: connectTimeout,
            clientSegments: [segment, ...?options.agentSegments],
            logger: options.logger,
            interceptors: options.interceptors,
            httpClientAdapter: options.httpClientAdapter,
            compression: options.compression,
          );

    return RetryStrategy(
      readTimeout: readTimeout,
      writeTimeout: writeTimeout,
      hosts: options.hosts ?? defaultHosts.call(),
      requester: requester,
      requestIdSupport: options.requestIdEnabled ?? requestIdSupport,
      // With a custom requester the options headers are not applied above, so
      // they must not suppress minting either.
      hasDefaultRequestId:
          options.requester == null && hasRequestIdHeader(options.headers),
      maxRateLimitRetries: options.maxRateLimitRetries,
    );
  }

  /// Run an request and get a response.
  Future<Map<String, dynamic>?> execute({
    required ApiRequest request,
    RequestOptions? options,
  }) async {
    final callType = _callTypeOf(request);
    final hosts = _callableHosts(callType);
    final List<AlgoliaException> errors = [];

    // Minted once per execution so every retry attempt shares one value; a
    // caller-supplied ID wins on any channel, including the query parameter,
    // which the server consults only when the header is absent.
    final requestId = requestIdSupport &&
            !hasDefaultRequestId &&
            !hasRequestIdHeader(options?.headers) &&
            !hasRequestIdHeader(request.headers) &&
            !hasRequestIdQueryParameter(options?.urlParameters) &&
            !hasRequestIdQueryParameter(request.queryParams)
        ? generateRequestId()
        : null;

    // One budget per execution, shared across hosts.
    var rateLimitRetriesLeft = maxRateLimitRetries;

    for (final host in hosts) {
      // A 429 is retried on this same host after Retry-After, so the loop runs
      // until the host answers, fails over or the rate-limit budget is spent.
      while (true) {
        final httpRequest =
            _buildRequest(host, request, callType, options, requestId);
        final requesterConnectTimeout =
            requester.connectTimeout ?? Duration(seconds: 2);
        if (options?.connectTimeout != null) {
          requester.setConnectTimeout(options!.connectTimeout!);
        }
        // Set by the 429 branch; the wait happens after the finally below has
        // restored the requester's connect timeout, so a concurrent request on
        // the same client does not pick up this call's override meanwhile.
        Duration? rateLimitWait;
        try {
          final response = await requester.perform(httpRequest);
          final statusCode = response.statusCode;
          if (statusCode != null && statusCode ~/ 100 != 2) {
            // A requester that returns an error response instead of throwing
            // still surfaces the Correlation-ID and Retry-After; the handler
            // below classifies it.
            throw AlgoliaApiException(
              statusCode,
              response.body,
              correlationId: _correlationIdOf(response.headers),
              headers: response.headers,
            );
          }
          host.reset();
          return statusCode == 204 ? null : response.body;
        } on AlgoliaTimeoutException catch (e) {
          host.timedOut();
          errors.add(e);
          break;
        } on AlgoliaIOException catch (e) {
          host.failed();
          errors.add(e);
          break;
        } on AlgoliaApiException catch (e) {
          if (isRateLimited(e.statusCode) && rateLimitRetriesLeft > 0) {
            rateLimitRetriesLeft--;
            // Keep the waited-out 429 (and its Correlation-ID) visible if the
            // request later dies on the other hosts. The host is not marked
            // down and its connect-timeout multiplier does not move.
            errors.add(e);
            rateLimitWait = parseRetryAfter(e.headers);
          } else {
            if (e.statusCode ~/ 100 == 4) rethrow;
            host.failed();
            errors.add(e);
            break;
          }
        } finally {
          requester.setConnectTimeout(requesterConnectTimeout);
        }
        // Only a waited-out 429 reaches this point; every other outcome has
        // returned, rethrown or broken out to the next host above.
        await sleep(rateLimitWait);
      }
    }
    throw UnreachableHostsException(errors);
  }

  /// The Correlation-ID header of a response, whatever its casing; never the
  /// unrelated X-Algolia-RequestID edge header.
  static String? _correlationIdOf(Map<String, String>? headers) {
    if (headers == null) return null;
    for (final entry in headers.entries) {
      if (entry.key.toLowerCase() == 'correlation-id') return entry.value;
    }
    return null;
  }

  /// Returns a list of callable hosts.
  /// If there are hosts that are up, it returns these hosts.
  /// Otherwise, it resets all hosts and returns them.
  Iterable<RetryableHost> _callableHosts(CallType callType) {
    _expireHosts();
    final hostsCallType = _hosts
        .where((e) => e.host.callType == callType || e.host.callType == null);
    final upHosts = hostsCallType.where((host) => host.isUp);
    if (upHosts.isNotEmpty) return upHosts;
    return hostsCallType..forEach((host) => host.reset());
  }

  /// Checks if any hosts have been inactive for more than 5 minutes and resets
  /// them if they have.
  void _expireHosts() {
    for (final host in _hosts) {
      final delay = DateTime.now().difference(host.lastUpdated);
      if (delay > const Duration(minutes: 5)) host.reset();
    }
  }

  /// Constructs an HTTP request for a given [host], [request] and [options],
  /// carrying the minted [requestId] on the platform channel.
  HttpRequest _buildRequest(
    RetryableHost host,
    ApiRequest request,
    CallType callType,
    RequestOptions? options, [
    String? requestId,
  ]) {
    final baseTimeout = _timeoutOf(callType, options);
    final baseConnectTimeout = options?.connectTimeout ??
        requester.connectTimeout ??
        Duration(seconds: 2);
    final connectTimeout = baseConnectTimeout * (host.retryCount + 1);
    return HttpRequest(
        method: request.method.name,
        host: host.host,
        path: request.path,
        timeout: baseTimeout,
        connectTimeout: connectTimeout,
        headers: {
          ...?options?.headers,
          ...?request.headers,
          if (requestId != null && !requestIdAsQueryParameter)
            requestIdHeader: requestId,
        },
        body: options?.body ?? request.body,
        queryParameters: {
          ...?request.queryParams,
          ...?options?.urlParameters,
          if (requestId != null && requestIdAsQueryParameter)
            requestIdQueryParameter: requestId,
        }.map((key, value) => MapEntry(
            _encodeQueryParameter(key), _encodeQueryParameter(value))));
  }

  /// Determines the call type of a given [config].
  CallType _callTypeOf(ApiRequest config) =>
      config.isRead || config.method == RequestMethod.get
          ? CallType.read
          : CallType.write;

  /// Determines the timeout for a given [callType].
  Duration _timeoutOf(CallType callType, RequestOptions? requestOptions) {
    switch (callType) {
      case CallType.read:
        return requestOptions?.readTimeout ?? readTimeout;
      case CallType.write:
        return requestOptions?.writeTimeout ?? writeTimeout;
    }
  }

  String _encodeQueryParameter(dynamic value) {
    if (value is Iterable) {
      return value.map(_encodeQueryParameter).join('%2C');
    }
    return Uri.encodeComponent(value.toString());
  }

  /// Release underlying resources.
  void dispose() => requester.close();
}
