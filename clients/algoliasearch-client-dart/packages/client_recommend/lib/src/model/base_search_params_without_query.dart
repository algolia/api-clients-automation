// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element

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
    this.facets,
    this.maxValuesPerFacet,
    this.facetingAfterDistinct,
    this.sortFacetValuesBy,
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
    this.clickAnalytics,
    this.analytics,
    this.analyticsTags,
    this.percentileComputation,
    this.enableABTest,
    this.enableReRanking,
    this.reRankingApplyFilter,
  });

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

  /// Returns [facets](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#contextual-facet-values-and-counts), their facet values, and the number of matching facet values.
  @JsonKey(name: r'facets')
  final List<String>? facets;

  /// Maximum number of facet values to return for each facet.
  @JsonKey(name: r'maxValuesPerFacet')
  final int? maxValuesPerFacet;

  /// Forces faceting to be applied after [de-duplication](https://www.algolia.com/doc/guides/managing-results/refine-results/grouping/) (with the distinct feature). Alternatively, the `afterDistinct` [modifier](https://www.algolia.com/doc/api-reference/api-parameters/attributesForFaceting/#modifiers) of `attributesForFaceting` allows for more granular control.
  @JsonKey(name: r'facetingAfterDistinct')
  final bool? facetingAfterDistinct;

  /// Controls how facet values are fetched.
  @JsonKey(name: r'sortFacetValuesBy')
  final String? sortFacetValuesBy;

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

  /// Precision of a geographical search (in meters), to [group results that are more or less the same distance from a central point](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/in-depth/geo-ranking-precision/).
  @JsonKey(name: r'aroundPrecision')
  final int? aroundPrecision;

  /// Minimum radius (in meters) used for a geographical search when `aroundRadius` isn't set.
  // minimum: 1
  @JsonKey(name: r'minimumAroundRadius')
  final int? minimumAroundRadius;

  /// Search inside a [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates).
  @JsonKey(name: r'insideBoundingBox')
  final List<double>? insideBoundingBox;

  /// Search inside a [polygon](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates).
  @JsonKey(name: r'insidePolygon')
  final List<double>? insidePolygon;

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

  /// Indicates whether this search will use [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/).
  @JsonKey(name: r'enableReRanking')
  final bool? enableReRanking;

  /// One of types:
  /// - [List<List<String>>]
  /// - [String]
  /// - [List<String>]
  @JsonKey(name: r'reRankingApplyFilter')
  final dynamic reRankingApplyFilter;

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
          other.facets == facets &&
          other.maxValuesPerFacet == maxValuesPerFacet &&
          other.facetingAfterDistinct == facetingAfterDistinct &&
          other.sortFacetValuesBy == sortFacetValuesBy &&
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
          other.clickAnalytics == clickAnalytics &&
          other.analytics == analytics &&
          other.analyticsTags == analyticsTags &&
          other.percentileComputation == percentileComputation &&
          other.enableABTest == enableABTest &&
          other.enableReRanking == enableReRanking &&
          other.reRankingApplyFilter == reRankingApplyFilter;

  @override
  int get hashCode =>
      similarQuery.hashCode +
      filters.hashCode +
      facetFilters.hashCode +
      optionalFilters.hashCode +
      numericFilters.hashCode +
      tagFilters.hashCode +
      sumOrFiltersScores.hashCode +
      facets.hashCode +
      maxValuesPerFacet.hashCode +
      facetingAfterDistinct.hashCode +
      sortFacetValuesBy.hashCode +
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
      clickAnalytics.hashCode +
      analytics.hashCode +
      analyticsTags.hashCode +
      percentileComputation.hashCode +
      enableABTest.hashCode +
      enableReRanking.hashCode +
      (reRankingApplyFilter == null ? 0 : reRankingApplyFilter.hashCode);

  factory BaseSearchParamsWithoutQuery.fromJson(Map<String, dynamic> json) =>
      _$BaseSearchParamsWithoutQueryFromJson(json);

  Map<String, dynamic> toJson() => _$BaseSearchParamsWithoutQueryToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
