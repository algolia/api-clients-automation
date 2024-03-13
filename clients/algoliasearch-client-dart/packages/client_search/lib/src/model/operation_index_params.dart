// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algolia_client_search/src/model/scope_type.dart';
import 'package:algolia_client_search/src/model/operation_type.dart';

import 'package:json_annotation/json_annotation.dart';

part 'operation_index_params.g.dart';

@JsonSerializable()
final class OperationIndexParams {
  /// Returns a new [OperationIndexParams] instance.
  const OperationIndexParams({
    required this.operation,
    required this.destination,
    this.scope,
  });

  @JsonKey(name: r'operation')
  final OperationType operation;

  /// Index name.
  @JsonKey(name: r'destination')
  final String destination;

  /// **Only for copying.**  If you specify a scope, only the selected scopes are copied. Records and the other scopes are left unchanged. If you omit the `scope` parameter, everything is copied: records, settings, synonyms, and rules.
  @JsonKey(name: r'scope')
  final List<ScopeType>? scope;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is OperationIndexParams &&
          other.operation == operation &&
          other.destination == destination &&
          other.scope == scope;

  @override
  int get hashCode =>
      operation.hashCode + destination.hashCode + scope.hashCode;

  factory OperationIndexParams.fromJson(Map<String, dynamic> json) =>
      _$OperationIndexParamsFromJson(json);

  Map<String, dynamic> toJson() => _$OperationIndexParamsToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
