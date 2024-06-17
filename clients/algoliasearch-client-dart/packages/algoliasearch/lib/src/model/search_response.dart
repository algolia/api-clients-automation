// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algoliasearch/src/model/redirect.dart';
import 'package:algoliasearch/src/model/hit.dart';
import 'package:algoliasearch/src/model/facets_stats.dart';
import 'package:algoliasearch/src/model/rendering_content.dart';
import 'package:algoliasearch/src/model/exhaustive.dart';

import 'package:json_annotation/json_annotation.dart';

part 'search_response.g.dart';

@JsonSerializable()
final class SearchResponse {
  /// Returns a new [SearchResponse] instance.
  const SearchResponse({
    this.abTestID,
    this.abTestVariantID,
    this.aroundLatLng,
    this.automaticRadius,
    this.exhaustive,
    this.exhaustiveFacetsCount,
    this.exhaustiveNbHits,
    this.exhaustiveTypo,
    this.facets,
    this.facetsStats,
    required this.hitsPerPage,
    this.index,
    this.indexUsed,
    this.message,
    required this.nbHits,
    required this.nbPages,
    this.nbSortedHits,
    required this.page,
    this.parsedQuery,
    required this.processingTimeMS,
    this.processingTimingsMS,
    this.queryAfterRemoval,
    this.redirect,
    this.renderingContent,
    this.serverTimeMS,
    this.serverUsed,
    this.userData,
    this.queryID,
    required this.hits,
    required this.query,
    required this.params,
  });

  /// A/B test ID. This is only included in the response for indices that are part of an A/B test.
  @JsonKey(name: r'abTestID')
  final int? abTestID;

  /// Variant ID. This is only included in the response for indices that are part of an A/B test.
  // minimum: 1
  @JsonKey(name: r'abTestVariantID')
  final int? abTestVariantID;

  /// Computed geographical location.
  @JsonKey(name: r'aroundLatLng')
  final String? aroundLatLng;

  /// Distance from a central coordinate provided by `aroundLatLng`.
  @JsonKey(name: r'automaticRadius')
  final String? automaticRadius;

  @JsonKey(name: r'exhaustive')
  final Exhaustive? exhaustive;

  /// See the `facetsCount` field of the `exhaustive` object in the response.
  @Deprecated('exhaustiveFacetsCount has been deprecated')
  @JsonKey(name: r'exhaustiveFacetsCount')
  final bool? exhaustiveFacetsCount;

  /// See the `nbHits` field of the `exhaustive` object in the response.
  @Deprecated('exhaustiveNbHits has been deprecated')
  @JsonKey(name: r'exhaustiveNbHits')
  final bool? exhaustiveNbHits;

  /// See the `typo` field of the `exhaustive` object in the response.
  @Deprecated('exhaustiveTypo has been deprecated')
  @JsonKey(name: r'exhaustiveTypo')
  final bool? exhaustiveTypo;

  /// Facet counts.
  @JsonKey(name: r'facets')
  final Map<String, Map<String, int>>? facets;

  /// Statistics for numerical facets.
  @JsonKey(name: r'facets_stats')
  final Map<String, FacetsStats>? facetsStats;

  /// Number of hits per page.
  // minimum: 1
  // maximum: 1000
  @JsonKey(name: r'hitsPerPage')
  final int hitsPerPage;

  /// Index name used for the query.
  @JsonKey(name: r'index')
  final String? index;

  /// Index name used for the query. During A/B testing, the targeted index isn't always the index used by the query.
  @JsonKey(name: r'indexUsed')
  final String? indexUsed;

  /// Warnings about the query.
  @JsonKey(name: r'message')
  final String? message;

  /// Number of results (hits).
  @JsonKey(name: r'nbHits')
  final int nbHits;

  /// Number of pages of results.
  @JsonKey(name: r'nbPages')
  final int nbPages;

  /// Number of hits selected and sorted by the relevant sort algorithm.
  @JsonKey(name: r'nbSortedHits')
  final int? nbSortedHits;

  /// Page of search results to retrieve.
  // minimum: 0
  @JsonKey(name: r'page')
  final int page;

  /// Post-[normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean) query string that will be searched.
  @JsonKey(name: r'parsedQuery')
  final String? parsedQuery;

  /// Time the server took to process the request, in milliseconds.
  @JsonKey(name: r'processingTimeMS')
  final int processingTimeMS;

  /// Experimental. List of processing steps and their times, in milliseconds. You can use this list to investigate performance issues.
  @JsonKey(name: r'processingTimingsMS')
  final Object? processingTimingsMS;

  /// Markup text indicating which parts of the original query have been removed to retrieve a non-empty result set.
  @JsonKey(name: r'queryAfterRemoval')
  final String? queryAfterRemoval;

  @JsonKey(name: r'redirect')
  final Redirect? redirect;

  @JsonKey(name: r'renderingContent')
  final RenderingContent? renderingContent;

  /// Time the server took to process the request, in milliseconds.
  @JsonKey(name: r'serverTimeMS')
  final int? serverTimeMS;

  /// Host name of the server that processed the request.
  @JsonKey(name: r'serverUsed')
  final String? serverUsed;

  /// An object with custom data.  You can store up to 32kB as custom data.
  @JsonKey(name: r'userData')
  final Object? userData;

  /// Unique identifier for the query. This is used for [click analytics](https://www.algolia.com/doc/guides/analytics/click-analytics/).
  @JsonKey(name: r'queryID')
  final String? queryID;

  /// Search results (hits).  Hits are records from your index that match the search criteria, augmented with additional attributes, such as, for highlighting.
  @JsonKey(name: r'hits')
  final List<Hit> hits;

  /// Search query.
  @JsonKey(name: r'query')
  final String query;

  /// URL-encoded string of all search parameters.
  @JsonKey(name: r'params')
  final String params;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is SearchResponse &&
          other.abTestID == abTestID &&
          other.abTestVariantID == abTestVariantID &&
          other.aroundLatLng == aroundLatLng &&
          other.automaticRadius == automaticRadius &&
          other.exhaustive == exhaustive &&
          other.facets == facets &&
          other.facetsStats == facetsStats &&
          other.hitsPerPage == hitsPerPage &&
          other.index == index &&
          other.indexUsed == indexUsed &&
          other.message == message &&
          other.nbHits == nbHits &&
          other.nbPages == nbPages &&
          other.nbSortedHits == nbSortedHits &&
          other.page == page &&
          other.parsedQuery == parsedQuery &&
          other.processingTimeMS == processingTimeMS &&
          other.processingTimingsMS == processingTimingsMS &&
          other.queryAfterRemoval == queryAfterRemoval &&
          other.redirect == redirect &&
          other.renderingContent == renderingContent &&
          other.serverTimeMS == serverTimeMS &&
          other.serverUsed == serverUsed &&
          other.userData == userData &&
          other.queryID == queryID &&
          other.hits == hits &&
          other.query == query &&
          other.params == params;

  @override
  int get hashCode =>
      abTestID.hashCode +
      abTestVariantID.hashCode +
      aroundLatLng.hashCode +
      automaticRadius.hashCode +
      exhaustive.hashCode +
      facets.hashCode +
      facetsStats.hashCode +
      hitsPerPage.hashCode +
      index.hashCode +
      indexUsed.hashCode +
      message.hashCode +
      nbHits.hashCode +
      nbPages.hashCode +
      nbSortedHits.hashCode +
      page.hashCode +
      parsedQuery.hashCode +
      processingTimeMS.hashCode +
      processingTimingsMS.hashCode +
      queryAfterRemoval.hashCode +
      redirect.hashCode +
      renderingContent.hashCode +
      serverTimeMS.hashCode +
      serverUsed.hashCode +
      userData.hashCode +
      queryID.hashCode +
      hits.hashCode +
      query.hashCode +
      params.hashCode;

  factory SearchResponse.fromJson(Map<String, dynamic> json) =>
      _$SearchResponseFromJson(json);

  Map<String, dynamic> toJson() => _$SearchResponseToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
