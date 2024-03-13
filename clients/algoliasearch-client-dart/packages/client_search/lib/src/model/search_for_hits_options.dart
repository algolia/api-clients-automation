// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algolia_client_search/src/model/search_type_default.dart';

import 'package:json_annotation/json_annotation.dart';

part 'search_for_hits_options.g.dart';

@JsonSerializable()
final class SearchForHitsOptions {
  /// Returns a new [SearchForHitsOptions] instance.
  const SearchForHitsOptions({
    required this.indexName,
    this.type,
  });

  /// Index name.
  @JsonKey(name: r'indexName')
  final String indexName;

  @JsonKey(name: r'type')
  final SearchTypeDefault? type;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is SearchForHitsOptions &&
          other.indexName == indexName &&
          other.type == type;

  @override
  int get hashCode => indexName.hashCode + type.hashCode;

  factory SearchForHitsOptions.fromJson(Map<String, dynamic> json) =>
      _$SearchForHitsOptionsFromJson(json);

  Map<String, dynamic> toJson() => _$SearchForHitsOptionsToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
