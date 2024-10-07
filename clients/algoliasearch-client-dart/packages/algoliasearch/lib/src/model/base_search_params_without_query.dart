// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algoliasearch/src/model/supported_language.dart';

import 'package:json_annotation/json_annotation.dart';

part 'base_search_params_without_query.g.dart';

@JsonSerializable()
final class BaseSearchParamsWithoutQuery {
  /// Returns a new [BaseSearchParamsWithoutQuery] instance.
  const BaseSearchParamsWithoutQuery({
    this.similarQuery,
    this.filters,
    this.facetFilters,
    this.optionalFilters,
    this.numericFilters,
    this.tagFilters,
    this.sumOrFiltersScores,
    this.restrictSearchableAttributes,
    this.facets,
    this.facetingAfterDistinct,
    this.page,
    this.offset,
    this.length,
    this.aroundLatLng,
    this.aroundLatLngViaIP,
    this.aroundRadius,
    this.aroundPrecision,
    this.minimumAroundRadius,
    this.insideBoundingBox,
    this.insidePolygon,
    this.naturalLanguages,
    this.ruleContexts,
    this.personalizationImpact,
    this.userToken,
    this.getRankingInfo,
    this.synonyms,
    this.clickAnalytics,
    this.analytics,
    this.analyticsTags,
    this.percentileComputation,
    this.enableABTest,
  });

  /// Keywords to be used instead of the search query to conduct a more broader search.  Using the `similarQuery` parameter changes other settings:  - `queryType` is set to `prefixNone`. - `removeStopWords` is set to true. - `words` is set as the first ranking criterion. - All remaining words are treated as `optionalWords`.  Since the `similarQuery` is supposed to do a broad search, they usually return many results. Combine it with `filters` to narrow down the list of results.
  @JsonKey(name: r'similarQuery')
  final String? similarQuery;

  /// Filter expression to only include items that match the filter criteria in the response.  You can use these filter expressions:  - **Numeric filters.** `<facet> <op> <number>`, where `<op>` is one of `<`, `<=`, `=`, `!=`, `>`, `>=`. - **Ranges.** `<facet>:<lower> TO <upper>` where `<lower>` and `<upper>` are the lower and upper limits of the range (inclusive). - **Facet filters.** `<facet>:<value>` where `<facet>` is a facet attribute (case-sensitive) and `<value>` a facet value. - **Tag filters.** `_tags:<value>` or just `<value>` (case-sensitive). - **Boolean filters.** `<facet>: true | false`.  You can combine filters with `AND`, `OR`, and `NOT` operators with the following restrictions:  - You can only combine filters of the same type with `OR`.   **Not supported:** `facet:value OR num > 3`. - You can't use `NOT` with combinations of filters.   **Not supported:** `NOT(facet:value OR facet:value)` - You can't combine conjunctions (`AND`) with `OR`.   **Not supported:** `facet:value OR (facet:value AND facet:value)`  Use quotes around your filters, if the facet attribute name or facet value has spaces, keywords (`OR`, `AND`, `NOT`), or quotes. If a facet attribute is an array, the filter matches if it matches at least one element of the array.  For more information, see [Filters](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/).
  @JsonKey(name: r'filters')
  final String? filters;

  /// One of types:
  /// - [List<List<FacetFilters>>]
  /// - [String]
  /// - [List<String>]
  @JsonKey(name: r'facetFilters')
  final dynamic facetFilters;

  /// One of types:
  /// - [String]
  /// - [List<List<OptionalFilters>>]
  /// - [List<String>]
  @JsonKey(name: r'optionalFilters')
  final dynamic optionalFilters;

  /// One of types:
  /// - [List<List<NumericFilters>>]
  /// - [String]
  /// - [List<String>]
  @JsonKey(name: r'numericFilters')
  final dynamic numericFilters;

  /// One of types:
  /// - [List<List<TagFilters>>]
  /// - [String]
  /// - [List<String>]
  @JsonKey(name: r'tagFilters')
  final dynamic tagFilters;

  /// Whether to sum all filter scores.  If true, all filter scores are summed. Otherwise, the maximum filter score is kept. For more information, see [filter scores](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/in-depth/filter-scoring/#accumulating-scores-with-sumorfiltersscores).
  @JsonKey(name: r'sumOrFiltersScores')
  final bool? sumOrFiltersScores;

  /// Restricts a search to a subset of your searchable attributes. Attribute names are case-sensitive.
  @JsonKey(name: r'restrictSearchableAttributes')
  final List<String>? restrictSearchableAttributes;

  /// Facets for which to retrieve facet values that match the search criteria and the number of matching facet values.  To retrieve all facets, use the wildcard character `*`. For more information, see [facets](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#contextual-facet-values-and-counts).
  @JsonKey(name: r'facets')
  final List<String>? facets;

  /// Whether faceting should be applied after deduplication with `distinct`.  This leads to accurate facet counts when using faceting in combination with `distinct`. It's usually better to use `afterDistinct` modifiers in the `attributesForFaceting` setting, as `facetingAfterDistinct` only computes correct facet counts if all records have the same facet values for the `attributeForDistinct`.
  @JsonKey(name: r'facetingAfterDistinct')
  final bool? facetingAfterDistinct;

  /// Page of search results to retrieve.
  // minimum: 0
  @JsonKey(name: r'page')
  final int? page;

  /// Position of the first hit to retrieve.
  @JsonKey(name: r'offset')
  final int? offset;

  /// Number of hits to retrieve (used in combination with `offset`).
  // minimum: 0
  // maximum: 1000
  @JsonKey(name: r'length')
  final int? length;

  /// Coordinates for the center of a circle, expressed as a comma-separated string of latitude and longitude.  Only records included within a circle around this central location are included in the results. The radius of the circle is determined by the `aroundRadius` and `minimumAroundRadius` settings. This parameter is ignored if you also specify `insidePolygon` or `insideBoundingBox`.
  @JsonKey(name: r'aroundLatLng')
  final String? aroundLatLng;

  /// Whether to obtain the coordinates from the request's IP address.
  @JsonKey(name: r'aroundLatLngViaIP')
  final bool? aroundLatLngViaIP;

  /// One of types:
  /// - [AroundRadiusAll]
  /// - [int]
  @JsonKey(name: r'aroundRadius')
  final dynamic aroundRadius;

  /// One of types:
  /// - [List<Range>]
  /// - [int]
  @JsonKey(name: r'aroundPrecision')
  final dynamic aroundPrecision;

  /// Minimum radius (in meters) for a search around a location when `aroundRadius` isn't set.
  // minimum: 1
  @JsonKey(name: r'minimumAroundRadius')
  final int? minimumAroundRadius;

  /// Coordinates for a rectangular area in which to search.  Each bounding box is defined by the two opposite points of its diagonal, and expressed as latitude and longitude pair: `[p1 lat, p1 long, p2 lat, p2 long]`. Provide multiple bounding boxes as nested arrays. For more information, see [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas).
  @JsonKey(name: r'insideBoundingBox')
  final List<List<double>>? insideBoundingBox;

  /// Coordinates of a polygon in which to search.  Polygons are defined by 3 to 10,000 points. Each point is represented by its latitude and longitude. Provide multiple polygons as nested arrays. For more information, see [filtering inside polygons](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas). This parameter is ignored if you also specify `insideBoundingBox`.
  @JsonKey(name: r'insidePolygon')
  final List<List<double>>? insidePolygon;

  /// ISO language codes that adjust settings that are useful for processing natural language queries (as opposed to keyword searches):  - Sets `removeStopWords` and `ignorePlurals` to the list of provided languages. - Sets `removeWordsIfNoResults` to `allOptional`. - Adds a `natural_language` attribute to `ruleContexts` and `analyticsTags`.
  @JsonKey(name: r'naturalLanguages')
  final List<SupportedLanguage>? naturalLanguages;

  /// Assigns a rule context to the search query.  [Rule contexts](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#whats-a-context) are strings that you can use to trigger matching rules.
  @JsonKey(name: r'ruleContexts')
  final List<String>? ruleContexts;

  /// Impact that Personalization should have on this search.  The higher this value is, the more Personalization determines the ranking compared to other factors. For more information, see [Understanding Personalization impact](https://www.algolia.com/doc/guides/personalization/personalizing-results/in-depth/configuring-personalization/#understanding-personalization-impact).
  // minimum: 0
  // maximum: 100
  @JsonKey(name: r'personalizationImpact')
  final int? personalizationImpact;

  /// Unique pseudonymous or anonymous user identifier.  This helps with analytics and click and conversion events. For more information, see [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
  @JsonKey(name: r'userToken')
  final String? userToken;

  /// Whether the search response should include detailed ranking information.
  @JsonKey(name: r'getRankingInfo')
  final bool? getRankingInfo;

  /// Whether to take into account an index's synonyms for this search.
  @JsonKey(name: r'synonyms')
  final bool? synonyms;

  /// Whether to include a `queryID` attribute in the response.  The query ID is a unique identifier for a search query and is required for tracking [click and conversion events](https://www.algolia.com/guides/sending-events/getting-started/).
  @JsonKey(name: r'clickAnalytics')
  final bool? clickAnalytics;

  /// Whether this search will be included in Analytics.
  @JsonKey(name: r'analytics')
  final bool? analytics;

  /// Tags to apply to the query for [segmenting analytics data](https://www.algolia.com/doc/guides/search-analytics/guides/segments/).
  @JsonKey(name: r'analyticsTags')
  final List<String>? analyticsTags;

  /// Whether to include this search when calculating processing-time percentiles.
  @JsonKey(name: r'percentileComputation')
  final bool? percentileComputation;

  /// Whether to enable A/B testing for this search.
  @JsonKey(name: r'enableABTest')
  final bool? enableABTest;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is BaseSearchParamsWithoutQuery &&
          other.similarQuery == similarQuery &&
          other.filters == filters &&
          other.facetFilters == facetFilters &&
          other.optionalFilters == optionalFilters &&
          other.numericFilters == numericFilters &&
          other.tagFilters == tagFilters &&
          other.sumOrFiltersScores == sumOrFiltersScores &&
          other.restrictSearchableAttributes == restrictSearchableAttributes &&
          other.facets == facets &&
          other.facetingAfterDistinct == facetingAfterDistinct &&
          other.page == page &&
          other.offset == offset &&
          other.length == length &&
          other.aroundLatLng == aroundLatLng &&
          other.aroundLatLngViaIP == aroundLatLngViaIP &&
          other.aroundRadius == aroundRadius &&
          other.aroundPrecision == aroundPrecision &&
          other.minimumAroundRadius == minimumAroundRadius &&
          other.insideBoundingBox == insideBoundingBox &&
          other.insidePolygon == insidePolygon &&
          other.naturalLanguages == naturalLanguages &&
          other.ruleContexts == ruleContexts &&
          other.personalizationImpact == personalizationImpact &&
          other.userToken == userToken &&
          other.getRankingInfo == getRankingInfo &&
          other.synonyms == synonyms &&
          other.clickAnalytics == clickAnalytics &&
          other.analytics == analytics &&
          other.analyticsTags == analyticsTags &&
          other.percentileComputation == percentileComputation &&
          other.enableABTest == enableABTest;

  @override
  int get hashCode =>
      similarQuery.hashCode +
      filters.hashCode +
      facetFilters.hashCode +
      optionalFilters.hashCode +
      numericFilters.hashCode +
      tagFilters.hashCode +
      sumOrFiltersScores.hashCode +
      restrictSearchableAttributes.hashCode +
      facets.hashCode +
      facetingAfterDistinct.hashCode +
      page.hashCode +
      offset.hashCode +
      length.hashCode +
      aroundLatLng.hashCode +
      aroundLatLngViaIP.hashCode +
      aroundRadius.hashCode +
      aroundPrecision.hashCode +
      minimumAroundRadius.hashCode +
      insideBoundingBox.hashCode +
      insidePolygon.hashCode +
      naturalLanguages.hashCode +
      ruleContexts.hashCode +
      personalizationImpact.hashCode +
      userToken.hashCode +
      getRankingInfo.hashCode +
      synonyms.hashCode +
      clickAnalytics.hashCode +
      analytics.hashCode +
      analyticsTags.hashCode +
      percentileComputation.hashCode +
      enableABTest.hashCode;

  factory BaseSearchParamsWithoutQuery.fromJson(Map<String, dynamic> json) =>
      _$BaseSearchParamsWithoutQueryFromJson(json);

  Map<String, dynamic> toJson() => _$BaseSearchParamsWithoutQueryToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
