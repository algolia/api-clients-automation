import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:chopper/chopper.dart';

/// [AgentSegment]s for unsupported platforms.
Iterable<AgentSegment> platformAgentSegments() => const [];

/// [AlgoliaAgent] for unsupported platforms.
Request platformAlgoliaAgent<T>(Chain<T> chain, String agent) {
  // NO-OP.
  return chain.request;
}
