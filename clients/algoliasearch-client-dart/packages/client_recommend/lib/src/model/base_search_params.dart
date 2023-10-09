// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element

import 'package:json_annotation/json_annotation.dart';

part 'base_search_params.g.dart';

@JsonSerializable()
final class BaseSearchParams {
  /// Returns a new [BaseSearchParams] instance.
  const BaseSearchParams({
    this.query,
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
    this.explain,
    this.synonyms,
    this.clickAnalytics,
    this.analytics,
    this.analyticsTags,
    this.percentileComputation,
    this.enableABTest,
  });

  /// Text to search for in an index.
  @JsonKey(name: r'query')
  final String? query;

  /// Overrides the query parameter and performs a more generic search.
  @JsonKey(name: r'similarQuery')
  final String? similarQuery;

  /// [Filter](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/) the query with numeric, facet, or tag filters.
  @JsonKey(name: r'filters')
  final String? filters;

  /// One of types:
  /// - [List<List<String>>]
  /// - [String]
  /// - [List<String>]
  @JsonKey(name: r'facetFilters')
  final dynamic facetFilters;

  /// One of types:
  /// - [List<List<String>>]
  /// - [String]
  /// - [List<String>]
  @JsonKey(name: r'optionalFilters')
  final dynamic optionalFilters;

  /// One of types:
  /// - [List<List<String>>]
  /// - [String]
  /// - [List<String>]
  @JsonKey(name: r'numericFilters')
  final dynamic numericFilters;

  /// One of types:
  /// - [List<List<String>>]
  /// - [String]
  /// - [List<String>]
  @JsonKey(name: r'tagFilters')
  final dynamic tagFilters;

  /// Determines how to calculate [filter scores](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/in-depth/filter-scoring/#accumulating-scores-with-sumorfiltersscores). If `false`, maximum score is kept. If `true`, score is summed.
  @JsonKey(name: r'sumOrFiltersScores')
  final bool? sumOrFiltersScores;

  /// Restricts a query to only look at a subset of your [searchable attributes](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/).
  @JsonKey(name: r'restrictSearchableAttributes')
  final List<String>? restrictSearchableAttributes;

  /// Returns [facets](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#contextual-facet-values-and-counts), their facet values, and the number of matching facet values.
  @JsonKey(name: r'facets')
  final List<String>? facets;

  /// Forces faceting to be applied after [de-duplication](https://www.algolia.com/doc/guides/managing-results/refine-results/grouping/) (with the distinct feature). Alternatively, the `afterDistinct` [modifier](https://www.algolia.com/doc/api-reference/api-parameters/attributesForFaceting/#modifiers) of `attributesForFaceting` allows for more granular control.
  @JsonKey(name: r'facetingAfterDistinct')
  final bool? facetingAfterDistinct;

  /// Page to retrieve (the first page is `0`, not `1`).
  @JsonKey(name: r'page')
  final int? page;

  /// Specifies the offset of the first hit to return. > **Note**: Using `page` and `hitsPerPage` is the recommended method for [paging results](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/). However, you can use `offset` and `length` to implement [an alternative approach to paging](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/#retrieving-a-subset-of-records-with-offset-and-length).
  @JsonKey(name: r'offset')
  final int? offset;

  /// Sets the number of hits to retrieve (for use with `offset`). > **Note**: Using `page` and `hitsPerPage` is the recommended method for [paging results](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/). However, you can use `offset` and `length` to implement [an alternative approach to paging](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/#retrieving-a-subset-of-records-with-offset-and-length).
  // minimum: 1
  // maximum: 1000
  @JsonKey(name: r'length')
  final int? length;

  /// Search for entries [around a central location](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filter-around-a-central-point), enabling a geographical search within a circular area.
  @JsonKey(name: r'aroundLatLng')
  final String? aroundLatLng;

  /// Search for entries around a location. The location is automatically computed from the requester's IP address.
  @JsonKey(name: r'aroundLatLngViaIP')
  final bool? aroundLatLngViaIP;

  /// One of types:
  /// - [AroundRadiusAll]
  /// - [int]
  @JsonKey(name: r'aroundRadius')
  final dynamic aroundRadius;

  /// One of types:
  /// - [List<AroundPrecisionFromValueInner>]
  /// - [int]
  @JsonKey(name: r'aroundPrecision')
  final dynamic aroundPrecision;

  /// Minimum radius (in meters) used for a geographical search when `aroundRadius` isn't set.
  // minimum: 1
  @JsonKey(name: r'minimumAroundRadius')
  final int? minimumAroundRadius;

  /// Search inside a [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates).
  @JsonKey(name: r'insideBoundingBox')
  final List<List<double>>? insideBoundingBox;

  /// Search inside a [polygon](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates).
  @JsonKey(name: r'insidePolygon')
  final List<List<double>>? insidePolygon;

  /// Changes the default values of parameters that work best for a natural language query, such as `ignorePlurals`, `removeStopWords`, `removeWordsIfNoResults`, `analyticsTags`, and `ruleContexts`. These parameters work well together when the query consists of fuller natural language strings instead of keywords, for example when processing voice search queries.
  @JsonKey(name: r'naturalLanguages')
  final List<String>? naturalLanguages;

  /// Assigns [rule contexts](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#whats-a-context) to search queries.
  @JsonKey(name: r'ruleContexts')
  final List<String>? ruleContexts;

  /// Defines how much [Personalization affects results](https://www.algolia.com/doc/guides/personalization/personalizing-results/in-depth/configuring-personalization/#understanding-personalization-impact).
  @JsonKey(name: r'personalizationImpact')
  final int? personalizationImpact;

  /// Associates a [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/) with the current search.
  @JsonKey(name: r'userToken')
  final String? userToken;

  /// Incidates whether the search response includes [detailed ranking information](https://www.algolia.com/doc/guides/building-search-ui/going-further/backend-search/in-depth/understanding-the-api-response/#ranking-information).
  @JsonKey(name: r'getRankingInfo')
  final bool? getRankingInfo;

  /// Enriches the API's response with information about how the query was processed.
  @JsonKey(name: r'explain')
  final List<String>? explain;

  /// Whether to take into account an index's synonyms for a particular search.
  @JsonKey(name: r'synonyms')
  final bool? synonyms;

  /// Indicates whether a query ID parameter is included in the search response. This is required for [tracking click and conversion events](https://www.algolia.com/doc/guides/sending-events/concepts/event-types/#events-related-to-algolia-requests).
  @JsonKey(name: r'clickAnalytics')
  final bool? clickAnalytics;

  /// Indicates whether this query will be included in [analytics](https://www.algolia.com/doc/guides/search-analytics/guides/exclude-queries/).
  @JsonKey(name: r'analytics')
  final bool? analytics;

  /// Tags to apply to the query for [segmenting analytics data](https://www.algolia.com/doc/guides/search-analytics/guides/segments/).
  @JsonKey(name: r'analyticsTags')
  final List<String>? analyticsTags;

  /// Whether to include or exclude a query from the processing-time percentile computation.
  @JsonKey(name: r'percentileComputation')
  final bool? percentileComputation;

  /// Incidates whether this search will be considered in A/B testing.
  @JsonKey(name: r'enableABTest')
  final bool? enableABTest;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is BaseSearchParams &&
          other.query == query &&
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
          other.explain == explain &&
          other.synonyms == synonyms &&
          other.clickAnalytics == clickAnalytics &&
          other.analytics == analytics &&
          other.analyticsTags == analyticsTags &&
          other.percentileComputation == percentileComputation &&
          other.enableABTest == enableABTest;

  @override
  int get hashCode =>
      query.hashCode +
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
      explain.hashCode +
      synonyms.hashCode +
      clickAnalytics.hashCode +
      analytics.hashCode +
      analyticsTags.hashCode +
      percentileComputation.hashCode +
      enableABTest.hashCode;

  factory BaseSearchParams.fromJson(Map<String, dynamic> json) =>
      _$BaseSearchParamsFromJson(json);

  Map<String, dynamic> toJson() => _$BaseSearchParamsToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
