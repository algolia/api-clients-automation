// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algolia_client_search/src/model/action.dart';

import 'package:json_annotation/json_annotation.dart';

part 'batch_request.g.dart';

@JsonSerializable()
final class BatchRequest {
  /// Returns a new [BatchRequest] instance.
  const BatchRequest({
    required this.action,
    required this.body,
  });

  @JsonKey(name: r'action')
  final Action action;

  /// arguments to the operation (depends on the type of the operation).
  @JsonKey(name: r'body')
  final Object body;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is BatchRequest && other.action == action && other.body == body;

  @override
  int get hashCode => action.hashCode + body.hashCode;

  factory BatchRequest.fromJson(Map<String, dynamic> json) =>
      _$BatchRequestFromJson(json);

  Map<String, dynamic> toJson() => _$BatchRequestToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
