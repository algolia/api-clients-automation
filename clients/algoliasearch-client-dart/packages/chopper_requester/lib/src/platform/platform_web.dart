import 'dart:html' as web;

import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:chopper/chopper.dart';

/// [AgentSegment]s for web platforms.
Iterable<AgentSegment> platformAgentSegments() => [
      AgentSegment(
        value: 'Platform',
        version: 'Web ${web.window.navigator.platform}',
      ),
    ];

Request platformAlgoliaAgent<T>(Chain<T> chain, String agent) =>
    chain.request.copyWith(
      parameters: {
        ...chain.request.parameters,
        'X-Algolia-Agent': agent,
      },
    );
