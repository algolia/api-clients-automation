// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algolia_insights/src/model/insight_event.dart';

import 'package:json_annotation/json_annotation.dart';

part 'insight_events.g.dart';

@JsonSerializable()
final class InsightEvents {
  /// Returns a new [InsightEvents] instance.
  const InsightEvents({
    required this.events,
  });

  /// Array of events sent.
  @JsonKey(name: r'events')
  final List<InsightEvent> events;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is InsightEvents && other.events == events;

  @override
  int get hashCode => events.hashCode;

  factory InsightEvents.fromJson(Map<String, dynamic> json) =>
      _$InsightEventsFromJson(json);

  Map<String, dynamic> toJson() => _$InsightEventsToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
