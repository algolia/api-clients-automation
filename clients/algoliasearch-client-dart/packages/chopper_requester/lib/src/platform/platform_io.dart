import 'dart:io' as io;

import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:chopper/chopper.dart';

/// [AgentSegment]s for native platforms.
Iterable<AgentSegment> platformAgentSegments() => [
      AgentSegment(
        value: 'Dart',
        version: io.Platform.version,
      ),
      AgentSegment(
        value: io.Platform.operatingSystem,
        version: io.Platform.operatingSystemVersion,
      ),
    ];

/// [AlgoliaAgent] for native platforms as user-agent.
Request platformAlgoliaAgent<T>(Chain<T> chain, String agent) =>
    applyHeader(chain.request, "user-agent", agent);
