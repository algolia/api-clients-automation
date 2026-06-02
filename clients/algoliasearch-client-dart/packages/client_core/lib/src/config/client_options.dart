import 'dart:core';

import 'package:algolia_client_core/src/config/agent_segment.dart';
import 'package:algolia_client_core/src/config/host.dart';
import 'package:algolia_client_core/src/transport/requester.dart';
import 'package:dio/dio.dart';

final class ClientOptions {
  /// Sentinel used as the default for the timeout options below.
  ///
  /// It signals that the caller did not provide an explicit timeout, so the
  /// transport falls back to the per-client default coming from the spec (the
  /// retry strategy resolves it). Kept as a non-nullable [Duration] so the
  /// public `connectTimeout`/`readTimeout`/`writeTimeout` fields stay
  /// non-nullable and backward compatible.
  ///
  /// Note: only this exact value means "unset". Passing `Duration.zero` is
  /// treated as an explicit 0 ms timeout, not as "use the default".
  static const Duration unsetTimeout = Duration(microseconds: -1);

  /// The list of hosts that the client can connect to.
  final Iterable<Host>? hosts;

  /// The maximum duration to wait for a connection to establish before timing out.
  ///
  /// Defaults to [unsetTimeout], meaning the per-client default from the spec is
  /// applied by the transport; set it explicitly to override.
  final Duration connectTimeout;

  /// The maximum duration to wait for a write operation to complete before timing out.
  ///
  /// Defaults to [unsetTimeout], meaning the per-client default from the spec is
  /// applied by the transport; set it explicitly to override.
  final Duration writeTimeout;

  /// The maximum duration to wait for a read operation to complete before timing out.
  ///
  /// Defaults to [unsetTimeout], meaning the per-client default from the spec is
  /// applied by the transport; set it explicitly to override.
  final Duration readTimeout;

  /// Default headers to include in each HTTP request.
  final Map<String, dynamic>? headers;

  /// List of agent segments for the Algolia service.
  final Iterable<AgentSegment>? agentSegments;

  /// Custom logger for http operations.
  final Function(Object?)? logger;

  /// Custom requester used to send HTTP requests.
  final Requester? requester;

  /// List of Dio interceptors.
  /// Used only in case of using the default (dio) requester.
  final Iterable<Interceptor>? interceptors;

  /// Custom [HttpClientAdapter] used to send HTTP requests.
  /// Used only in case of using the default (dio) requester.
  final HttpClientAdapter? httpClientAdapter;

  /// Compression type to use for request bodies.
  /// Set to 'gzip' to enable gzip compression for POST/PUT requests.
  final String? compression;

  /// Constructs a [ClientOptions] instance with the provided parameters.
  const ClientOptions({
    this.connectTimeout = unsetTimeout,
    this.writeTimeout = unsetTimeout,
    this.readTimeout = unsetTimeout,
    this.hosts,
    this.headers,
    this.agentSegments,
    this.requester,
    this.logger,
    this.interceptors,
    this.httpClientAdapter,
    this.compression,
  });

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is ClientOptions &&
          runtimeType == other.runtimeType &&
          hosts == other.hosts &&
          connectTimeout == other.connectTimeout &&
          writeTimeout == other.writeTimeout &&
          readTimeout == other.readTimeout &&
          headers == other.headers &&
          agentSegments == other.agentSegments &&
          logger == other.logger &&
          requester == other.requester &&
          interceptors == other.interceptors &&
          httpClientAdapter == other.httpClientAdapter &&
          compression == other.compression;

  @override
  int get hashCode =>
      hosts.hashCode ^
      connectTimeout.hashCode ^
      writeTimeout.hashCode ^
      readTimeout.hashCode ^
      headers.hashCode ^
      agentSegments.hashCode ^
      logger.hashCode ^
      requester.hashCode ^
      interceptors.hashCode ^
      httpClientAdapter.hashCode ^
      compression.hashCode;

  @override
  String toString() {
    return 'ClientOptions{hosts: $hosts, connectTimeout: $connectTimeout, writeTimeout: $writeTimeout, readTimeout: $readTimeout, headers: $headers, agentSegments: $agentSegments, logger: $logger, requester: $requester, interceptors: $interceptors, httpClientAdapter: $httpClientAdapter, compression: $compression}';
  }
}
