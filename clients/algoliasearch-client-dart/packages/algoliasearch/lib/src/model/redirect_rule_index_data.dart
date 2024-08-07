// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element

import 'package:json_annotation/json_annotation.dart';

part 'redirect_rule_index_data.g.dart';

@JsonSerializable()
final class RedirectRuleIndexData {
  /// Returns a new [RedirectRuleIndexData] instance.
  const RedirectRuleIndexData({
    required this.ruleObjectID,
  });

  @JsonKey(name: r'ruleObjectID')
  final String ruleObjectID;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is RedirectRuleIndexData && other.ruleObjectID == ruleObjectID;

  @override
  int get hashCode => ruleObjectID.hashCode;

  factory RedirectRuleIndexData.fromJson(Map<String, dynamic> json) =>
      _$RedirectRuleIndexDataFromJson(json);

  Map<String, dynamic> toJson() => _$RedirectRuleIndexDataToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
