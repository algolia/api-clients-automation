// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algolia_client_query_suggestions/src/model/log_level.dart';

import 'package:json_annotation/json_annotation.dart';

part 'get_log_file200_response.g.dart';

@JsonSerializable()
final class GetLogFile200Response {
  /// Returns a new [GetLogFile200Response] instance.
  const GetLogFile200Response({
    this.timestamp,
    this.level,
    this.message,
    this.contextLevel,
  });

  /// Timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format.
  @JsonKey(name: r'timestamp')
  final String? timestamp;

  @JsonKey(name: r'level')
  final LogLevel? level;

  /// Details about this log entry.
  @JsonKey(name: r'message')
  final String? message;

  /// Level indicating the position of a suggestion in a hierarchy of records.   For example, a `contextLevel` of 1 indicates that this suggestion belongs to a previous suggestion with `contextLevel` 0.
  @JsonKey(name: r'contextLevel')
  final int? contextLevel;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is GetLogFile200Response &&
          other.timestamp == timestamp &&
          other.level == level &&
          other.message == message &&
          other.contextLevel == contextLevel;

  @override
  int get hashCode =>
      timestamp.hashCode +
      level.hashCode +
      message.hashCode +
      contextLevel.hashCode;

  factory GetLogFile200Response.fromJson(Map<String, dynamic> json) =>
      _$GetLogFile200ResponseFromJson(json);

  Map<String, dynamic> toJson() => _$GetLogFile200ResponseToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
