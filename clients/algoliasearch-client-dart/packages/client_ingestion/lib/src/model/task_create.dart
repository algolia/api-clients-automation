// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algolia_client_ingestion/src/model/action_type.dart';

import 'package:json_annotation/json_annotation.dart';

part 'task_create.g.dart';

@JsonSerializable()
final class TaskCreate {
  /// Returns a new [TaskCreate] instance.
  const TaskCreate({
    required this.sourceID,
    required this.destinationID,
    required this.trigger,
    required this.action,
    this.enabled,
    this.input,
  });

  /// The source UUID.
  @JsonKey(name: r'sourceID')
  final String sourceID;

  /// The destination UUID.
  @JsonKey(name: r'destinationID')
  final String destinationID;

  /// One of types:
  /// - [OnDemandTriggerInput]
  /// - [ScheduleTriggerInput]
  /// - [SubscriptionTrigger]
  @JsonKey(name: r'trigger')
  final dynamic trigger;

  @JsonKey(name: r'action')
  final ActionType action;

  /// Whether the task is enabled or not.
  @JsonKey(name: r'enabled')
  final bool? enabled;

  /// One of types:
  /// - [OnDemandDateUtilsInput]
  /// - [ScheduleDateUtilsInput]
  @JsonKey(name: r'input')
  final dynamic input;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is TaskCreate &&
          other.sourceID == sourceID &&
          other.destinationID == destinationID &&
          other.trigger == trigger &&
          other.action == action &&
          other.enabled == enabled &&
          other.input == input;

  @override
  int get hashCode =>
      sourceID.hashCode +
      destinationID.hashCode +
      trigger.hashCode +
      action.hashCode +
      enabled.hashCode +
      input.hashCode;

  factory TaskCreate.fromJson(Map<String, dynamic> json) =>
      _$TaskCreateFromJson(json);

  Map<String, dynamic> toJson() => _$TaskCreateToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
