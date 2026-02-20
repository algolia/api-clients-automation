import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:chopper/chopper.dart';

import 'platform_stub.dart'
    if (dart.library.html) 'platform_web.dart'
    if (dart.library.io) 'platform_io.dart';

final class Platform {
  /// Get [AgentSegment]s for the current platform.
  static Iterable<AgentSegment> agentSegments() => platformAgentSegments();

  /// Set Algolia Agent as User-Agent or as query param depending on the platform.
  static Request algoliaAgent<T>(Chain<T> chain, String agent) =>
      platformAlgoliaAgent(chain, agent);

  Platform._();
}
