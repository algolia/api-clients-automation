// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algolia_client_search/src/model/rule.dart';

import 'package:json_annotation/json_annotation.dart';

part 'search_rules_response.g.dart';

@JsonSerializable()
final class SearchRulesResponse {
  /// Returns a new [SearchRulesResponse] instance.
  const SearchRulesResponse({
    required this.hits,
    required this.nbHits,
    required this.page,
    required this.nbPages,
  });

  /// Rules that matched the search criteria.
  @JsonKey(name: r'hits')
  final List<Rule> hits;

  /// Number of rules that matched the search criteria.
  @JsonKey(name: r'nbHits')
  final int nbHits;

  /// Current page.
  @JsonKey(name: r'page')
  final int page;

  /// Number of pages.
  @JsonKey(name: r'nbPages')
  final int nbPages;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is SearchRulesResponse &&
          other.hits == hits &&
          other.nbHits == nbHits &&
          other.page == page &&
          other.nbPages == nbPages;

  @override
  int get hashCode =>
      hits.hashCode + nbHits.hashCode + page.hashCode + nbPages.hashCode;

  factory SearchRulesResponse.fromJson(Map<String, dynamic> json) =>
      _$SearchRulesResponseFromJson(json);

  Map<String, dynamic> toJson() => _$SearchRulesResponseToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
