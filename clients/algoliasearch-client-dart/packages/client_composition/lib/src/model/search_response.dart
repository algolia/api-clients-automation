// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algolia_client_composition/src/model/compositions_search_response.dart';
import 'package:algolia_client_composition/src/model/search_results_item.dart';

import 'package:json_annotation/json_annotation.dart';

part 'search_response.g.dart';

@JsonSerializable()
final class SearchResponse {
  /// Returns a new [SearchResponse] instance.
  const SearchResponse({
    this.compositions,
    required this.results,
  });

  @JsonKey(name: r'compositions')
  final CompositionsSearchResponse? compositions;

  /// Search results.
  @JsonKey(name: r'results')
  final List<SearchResultsItem> results;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is SearchResponse &&
          other.compositions == compositions &&
          other.results == results;

  @override
  int get hashCode => compositions.hashCode + results.hashCode;

  factory SearchResponse.fromJson(Map<String, dynamic> json) =>
      _$SearchResponseFromJson(json);

  Map<String, dynamic> toJson() => _$SearchResponseToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
