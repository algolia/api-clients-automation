// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element

import 'package:json_annotation/json_annotation.dart';

part 'search_params_query.g.dart';

@JsonSerializable()
final class SearchParamsQuery {
  /// Returns a new [SearchParamsQuery] instance.
  const SearchParamsQuery({
    this.query,
  });

  /// Search query.
  @JsonKey(name: r'query')
  final String? query;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is SearchParamsQuery && other.query == query;

  @override
  int get hashCode => query.hashCode;

  factory SearchParamsQuery.fromJson(Map<String, dynamic> json) =>
      _$SearchParamsQueryFromJson(json);

  Map<String, dynamic> toJson() => _$SearchParamsQueryToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
