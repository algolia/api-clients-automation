// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element

import 'package:json_annotation/json_annotation.dart';

part 'search_params_string.g.dart';

@JsonSerializable()
final class SearchParamsString {
  /// Returns a new [SearchParamsString] instance.
  const SearchParamsString({
    this.params,
  });

  /// Search parameters as URL-encoded query string.
  @JsonKey(name: r'params')
  final String? params;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is SearchParamsString && other.params == params;

  @override
  int get hashCode => params.hashCode;

  factory SearchParamsString.fromJson(Map<String, dynamic> json) =>
      _$SearchParamsStringFromJson(json);

  Map<String, dynamic> toJson() => _$SearchParamsStringToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
