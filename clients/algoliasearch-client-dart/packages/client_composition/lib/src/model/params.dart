// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algolia_client_composition/src/model/supported_language.dart';

import 'package:json_annotation/json_annotation.dart';

part 'params.g.dart';

@JsonSerializable()
final class Params {
  /// Returns a new [Params] instance.
  const Params({
    this.query,
    this.filters,
    this.page,
    this.getRankingInfo,
    this.relevancyStrictness,
    this.facetFilters,
    this.optionalFilters,
    this.numericFilters,
    this.hitsPerPage,
    this.aroundLatLng,
    this.aroundLatLngViaIP,
    this.aroundRadius,
    this.aroundPrecision,
    this.minimumAroundRadius,
    this.insideBoundingBox,
    this.insidePolygon,
    this.queryLanguages,
    this.naturalLanguages,
    this.enableRules,
    this.ruleContexts,
    this.userToken,
    this.clickAnalytics,
    this.analytics,
    this.analyticsTags,
    this.enableABTest,
    this.enableReRanking,
  });

  /// Search query.
  @JsonKey(name: r'query')
  final String? query;

  /// Filter expression to only include items that match the filter criteria in the response.  You can use these filter expressions:  - **Numeric filters.** `<facet> <op> <number>`, where `<op>` is one of `<`, `<=`, `=`, `!=`, `>`, `>=`. - **Ranges.** `<facet>:<lower> TO <upper>` where `<lower>` and `<upper>` are the lower and upper limits of the range (inclusive). - **Facet filters.** `<facet>:<value>` where `<facet>` is a facet attribute (case-sensitive) and `<value>` a facet value. - **Tag filters.** `_tags:<value>` or just `<value>` (case-sensitive). - **Boolean filters.** `<facet>: true | false`.  You can combine filters with `AND`, `OR`, and `NOT` operators with the following restrictions:  - You can only combine filters of the same type with `OR`.   **Not supported:** `facet:value OR num > 3`. - You can't use `NOT` with combinations of filters.   **Not supported:** `NOT(facet:value OR facet:value)` - You can't combine conjunctions (`AND`) with `OR`.   **Not supported:** `facet:value OR (facet:value AND facet:value)`  Use quotes around your filters, if the facet attribute name or facet value has spaces, keywords (`OR`, `AND`, `NOT`), or quotes. If a facet attribute is an array, the filter matches if it matches at least one element of the array.  For more information, see [Filters](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/).
  @JsonKey(name: r'filters')
  final String? filters;

  /// Page of search results to retrieve.
  // minimum: 0
  @JsonKey(name: r'page')
  final int? page;

  /// Whether the run response should include detailed ranking information.
  @JsonKey(name: r'getRankingInfo')
  final bool? getRankingInfo;

  @JsonKey(name: r'relevancyStrictness')
  final int? relevancyStrictness;

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

  /// Number of hits per page.
  // minimum: 1
  // maximum: 1000
  @JsonKey(name: r'hitsPerPage')
  final int? hitsPerPage;

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

  /// One of types:
  /// - [List<List<double>>]
  /// - [String]
  @JsonKey(name: r'insideBoundingBox')
  final dynamic insideBoundingBox;

  /// Coordinates of a polygon in which to search.  Polygons are defined by 3 to 10,000 points. Each point is represented by its latitude and longitude. Provide multiple polygons as nested arrays. For more information, see [filtering inside polygons](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas). This parameter is ignored if you also specify `insideBoundingBox`.
  @JsonKey(name: r'insidePolygon')
  final List<List<double>>? insidePolygon;

  /// Languages for language-specific query processing steps such as plurals, stop-word removal, and word-detection dictionaries This setting sets a default list of languages used by the `removeStopWords` and `ignorePlurals` settings. This setting also sets a dictionary for word detection in the logogram-based [CJK](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/#normalization-for-logogram-based-languages-cjk) languages. To support this, you must place the CJK language **first** **You should always specify a query language.** If you don't specify an indexing language, the search engine uses all [supported languages](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/), or the languages you specified with the `ignorePlurals` or `removeStopWords` parameters. This can lead to unexpected search results. For more information, see [Language-specific configuration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/).
  @JsonKey(name: r'queryLanguages')
  final List<SupportedLanguage>? queryLanguages;

  /// ISO language codes that adjust settings that are useful for processing natural language queries (as opposed to keyword searches) - Sets `removeStopWords` and `ignorePlurals` to the list of provided languages. - Sets `removeWordsIfNoResults` to `allOptional`. - Adds a `natural_language` attribute to `ruleContexts` and `analyticsTags`.
  @JsonKey(name: r'naturalLanguages')
  final List<SupportedLanguage>? naturalLanguages;

  /// Whether to enable composition rules.
  @JsonKey(name: r'enableRules')
  final bool? enableRules;

  /// Assigns a rule context to the run query [Rule contexts](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#whats-a-context) are strings that you can use to trigger matching rules.
  @JsonKey(name: r'ruleContexts')
  final List<String>? ruleContexts;

  /// Unique pseudonymous or anonymous user identifier.  This helps with analytics and click and conversion events. For more information, see [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
  @JsonKey(name: r'userToken')
  final String? userToken;

  /// Whether to include a `queryID` attribute in the response The query ID is a unique identifier for a search query and is required for tracking [click and conversion events](https://www.algolia.com/guides/sending-events/getting-started/).
  @JsonKey(name: r'clickAnalytics')
  final bool? clickAnalytics;

  /// Whether this search will be included in Analytics.
  @JsonKey(name: r'analytics')
  final bool? analytics;

  /// Tags to apply to the query for [segmenting analytics data](https://www.algolia.com/doc/guides/search-analytics/guides/segments/).
  @JsonKey(name: r'analyticsTags')
  final List<String>? analyticsTags;

  /// Whether to enable index level A/B testing for this run request. If the composition mixes multiple indices, the A/B test is ignored.
  @JsonKey(name: r'enableABTest')
  final bool? enableABTest;

  /// Whether this search will use [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/) This setting only has an effect if you activated Dynamic Re-Ranking for this index in the Algolia dashboard.
  @JsonKey(name: r'enableReRanking')
  final bool? enableReRanking;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is Params &&
          other.query == query &&
          other.filters == filters &&
          other.page == page &&
          other.getRankingInfo == getRankingInfo &&
          other.relevancyStrictness == relevancyStrictness &&
          other.facetFilters == facetFilters &&
          other.optionalFilters == optionalFilters &&
          other.numericFilters == numericFilters &&
          other.hitsPerPage == hitsPerPage &&
          other.aroundLatLng == aroundLatLng &&
          other.aroundLatLngViaIP == aroundLatLngViaIP &&
          other.aroundRadius == aroundRadius &&
          other.aroundPrecision == aroundPrecision &&
          other.minimumAroundRadius == minimumAroundRadius &&
          other.insideBoundingBox == insideBoundingBox &&
          other.insidePolygon == insidePolygon &&
          other.queryLanguages == queryLanguages &&
          other.naturalLanguages == naturalLanguages &&
          other.enableRules == enableRules &&
          other.ruleContexts == ruleContexts &&
          other.userToken == userToken &&
          other.clickAnalytics == clickAnalytics &&
          other.analytics == analytics &&
          other.analyticsTags == analyticsTags &&
          other.enableABTest == enableABTest &&
          other.enableReRanking == enableReRanking;

  @override
  int get hashCode =>
      query.hashCode +
      filters.hashCode +
      page.hashCode +
      getRankingInfo.hashCode +
      relevancyStrictness.hashCode +
      facetFilters.hashCode +
      optionalFilters.hashCode +
      numericFilters.hashCode +
      hitsPerPage.hashCode +
      aroundLatLng.hashCode +
      aroundLatLngViaIP.hashCode +
      aroundRadius.hashCode +
      aroundPrecision.hashCode +
      minimumAroundRadius.hashCode +
      (insideBoundingBox == null ? 0 : insideBoundingBox.hashCode) +
      insidePolygon.hashCode +
      queryLanguages.hashCode +
      naturalLanguages.hashCode +
      enableRules.hashCode +
      ruleContexts.hashCode +
      userToken.hashCode +
      clickAnalytics.hashCode +
      analytics.hashCode +
      analyticsTags.hashCode +
      enableABTest.hashCode +
      enableReRanking.hashCode;

  factory Params.fromJson(Map<String, dynamic> json) => _$ParamsFromJson(json);

  Map<String, dynamic> toJson() => _$ParamsToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
