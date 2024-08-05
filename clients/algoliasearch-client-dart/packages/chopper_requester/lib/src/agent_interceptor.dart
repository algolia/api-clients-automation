import 'dart:async' show FutureOr;

import 'package:algolia_client_core/algolia_client_core.dart' show AlgoliaAgent;
import 'package:chopper/chopper.dart';
import 'package:algolia_chopper_requester/src/platform/platform.dart';

/// Interceptor that attaches the Algolia agent to outgoing requests.
///
/// This interceptor modifies the query parameters of each request to include the
/// formatted representation of the Algolia agent.
class AgentInterceptor implements Interceptor {
  /// The Algolia agent to be attached to outgoing requests.
  final AlgoliaAgent agent;

  /// Constructs an [AgentInterceptor] with the provided Algolia agent.
  const AgentInterceptor({required this.agent});

  @override
  FutureOr<Response<BodyType>> intercept<BodyType>(Chain<BodyType> chain) =>
      chain.proceed(Platform.algoliaAgent<BodyType>(chain, agent.formatted()));
}
