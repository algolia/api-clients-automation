// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algolia_client_search/src/model/anchoring.dart';

import 'package:json_annotation/json_annotation.dart';

part 'condition.g.dart';

@JsonSerializable()
final class Condition {
  /// Returns a new [Condition] instance.
  const Condition({
    this.pattern,
    this.anchoring,
    this.alternatives,
    this.context,
    this.filters,
  });

  /// Query pattern that triggers the rule.  You can use either a literal string, or a special pattern `{facet:ATTRIBUTE}`, where `ATTRIBUTE` is a facet name. The rule is triggered if the query matches the literal string or a value of the specified facet. For example, with `pattern: {facet:genre}`, the rule is triggered when users search for a genre, such as \"comedy\".
  @JsonKey(name: r'pattern')
  final String? pattern;

  @JsonKey(name: r'anchoring')
  final Anchoring? anchoring;

  /// Whether the pattern should match plurals, synonyms, and typos.
  @JsonKey(name: r'alternatives')
  final bool? alternatives;

  /// An additional restriction that only triggers the rule, when the search has the same value as `ruleContexts` parameter. For example, if `context: mobile`, the rule is only triggered when the search request has a matching `ruleContexts: mobile`. A rule context must only contain alphanumeric characters.
  @JsonKey(name: r'context')
  final String? context;

  /// Filters that trigger the rule.  You can add add filters using the syntax `facet:value` so that the rule is triggered, when the specific filter is selected. You can use `filters` on its own or combine it with the `pattern` parameter.
  @JsonKey(name: r'filters')
  final String? filters;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is Condition &&
          other.pattern == pattern &&
          other.anchoring == anchoring &&
          other.alternatives == alternatives &&
          other.context == context &&
          other.filters == filters;

  @override
  int get hashCode =>
      pattern.hashCode +
      anchoring.hashCode +
      alternatives.hashCode +
      context.hashCode +
      filters.hashCode;

  factory Condition.fromJson(Map<String, dynamic> json) =>
      _$ConditionFromJson(json);

  Map<String, dynamic> toJson() => _$ConditionToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
