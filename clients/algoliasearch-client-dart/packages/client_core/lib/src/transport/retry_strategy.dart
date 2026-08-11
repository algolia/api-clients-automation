import 'dart:async';

import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:algolia_client_core/src/transport/dio/dio_requester.dart';
import 'package:algolia_client_core/src/transport/retryable_host.dart';

/// Component to run http requests with retry logic.
final class RetryStrategy {
  final Requester requester;
  final Duration readTimeout;
  final Duration writeTimeout;
  final List<RetryableHost> _hosts;

  /// Whether every execution mints a Request-ID header, reused across its
  /// retry attempts, so that Algolia support can tie the attempts of one
  /// request together. Only the generated clients of the APIs that support it
  /// (search, recommend, composition) opt in; a caller-supplied Request-ID is
  /// never overwritten.
  final bool requestIdSupport;

  /// Whether the client default headers already carry a Request-ID, in which
  /// case minting is suppressed. Computed at construction: the default
  /// requester snapshots its headers then, so later mutation of the caller's
  /// map never reaches the wire anyway.
  final bool hasDefaultRequestId;

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
  }) : _hosts = hosts.map((host) => RetryableHost(host)).toList();

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
      requestIdSupport: requestIdSupport,
      // With a custom requester the options headers are not applied above, so
      // they must not suppress minting either.
      hasDefaultRequestId:
          options.requester == null && hasRequestIdHeader(options.headers),
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

    // The Request-ID is minted once per execution, before the host loop, so
    // that every retry attempt shares the same value and each subsequent call
    // gets a fresh one. A caller-supplied ID always wins, whether it comes
    // through the request options, the operation headers, the client default
    // headers, or the x-algolia-request-id query parameter (which the server
    // consults only when the header is absent, so a minted header would shadow
    // it), and only one casing may ever be present: the header merge below is
    // case-sensitive while HTTP treats names case-insensitively.
    final requestId = requestIdSupport &&
            !hasDefaultRequestId &&
            !hasRequestIdHeader(options?.headers) &&
            !hasRequestIdHeader(request.headers) &&
            !hasRequestIdQueryParameter(options?.urlParameters) &&
            !hasRequestIdQueryParameter(request.queryParams)
        ? generateRequestId()
        : null;

    for (final host in hosts) {
      final httpRequest =
          _buildRequest(host, request, callType, options, requestId);
      final requesterConnectTimeout =
          requester.connectTimeout ?? Duration(seconds: 2);
      if (options?.connectTimeout != null) {
        requester.setConnectTimeout(options!.connectTimeout!);
      }
      try {
        final response = await requester.perform(httpRequest);
        host.reset();
        requester.setConnectTimeout(requesterConnectTimeout);
        return response.statusCode == 204 ? null : response.body;
      } on AlgoliaTimeoutException catch (e) {
        host.timedOut();
        errors.add(e);
      } on AlgoliaIOException catch (e) {
        host.failed();
        errors.add(e);
      } on AlgoliaApiException catch (e) {
        if (e.statusCode ~/ 100 == 4) rethrow;
        host.failed();
        errors.add(e);
      }
    }
    throw UnreachableHostsException(errors);
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

  /// Constructs an HTTP request for a given [host], [request] and [options].
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
          if (requestId != null) requestIdHeader: requestId,
        },
        body: options?.body ?? request.body != null
            ? request.body
            : _requiresBody(request)
                ? const <String, dynamic>{}
                : null,
        queryParameters: {...?request.queryParams, ...?options?.urlParameters}
            .map((key, value) => MapEntry(
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

  /// Checks if a given [request] requires a body
  bool _requiresBody(ApiRequest request) =>
      request.method == RequestMethod.post ||
      request.method == RequestMethod.put;

  /// Release underlying resources.
  void dispose() => requester.close();
}
