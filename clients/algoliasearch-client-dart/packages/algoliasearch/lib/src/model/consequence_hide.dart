// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element

import 'package:json_annotation/json_annotation.dart';

part 'consequence_hide.g.dart';

@JsonSerializable()
final class ConsequenceHide {
  /// Returns a new [ConsequenceHide] instance.
  const ConsequenceHide({
    required this.objectID,
  });

  /// Unique record identifier.
  @JsonKey(name: r'objectID')
  final String objectID;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is ConsequenceHide && other.objectID == objectID;

  @override
  int get hashCode => objectID.hashCode;

  factory ConsequenceHide.fromJson(Map<String, dynamic> json) =>
      _$ConsequenceHideFromJson(json);

  Map<String, dynamic> toJson() => _$ConsequenceHideToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
