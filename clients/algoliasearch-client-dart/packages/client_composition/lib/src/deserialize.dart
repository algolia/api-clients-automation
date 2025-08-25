import 'package:algolia_client_composition/src/model/around_radius_all.dart';
import 'package:algolia_client_composition/src/model/banner.dart';
import 'package:algolia_client_composition/src/model/banner_image.dart';
import 'package:algolia_client_composition/src/model/banner_image_url.dart';
import 'package:algolia_client_composition/src/model/banner_link.dart';
import 'package:algolia_client_composition/src/model/base_search_response.dart';
import 'package:algolia_client_composition/src/model/composition_base_search_response.dart';
import 'package:algolia_client_composition/src/model/composition_id_ranking_info.dart';
import 'package:algolia_client_composition/src/model/composition_ranking_info.dart';
import 'package:algolia_client_composition/src/model/composition_run_applied_rules.dart';
import 'package:algolia_client_composition/src/model/composition_run_search_response.dart';
import 'package:algolia_client_composition/src/model/compositions_search_response.dart';
import 'package:algolia_client_composition/src/model/error_base.dart';
import 'package:algolia_client_composition/src/model/exhaustive.dart';
import 'package:algolia_client_composition/src/model/facet_hits.dart';
import 'package:algolia_client_composition/src/model/facet_ordering.dart';
import 'package:algolia_client_composition/src/model/facet_stats.dart';
import 'package:algolia_client_composition/src/model/facets.dart';
import 'package:algolia_client_composition/src/model/highlight_result_option.dart';
import 'package:algolia_client_composition/src/model/hit.dart';
import 'package:algolia_client_composition/src/model/hit_metadata.dart';
import 'package:algolia_client_composition/src/model/hit_ranking_info.dart';
import 'package:algolia_client_composition/src/model/match_level.dart';
import 'package:algolia_client_composition/src/model/matched_geo_location.dart';
import 'package:algolia_client_composition/src/model/params.dart';
import 'package:algolia_client_composition/src/model/personalization.dart';
import 'package:algolia_client_composition/src/model/range.dart';
import 'package:algolia_client_composition/src/model/ranking_info.dart';
import 'package:algolia_client_composition/src/model/redirect.dart';
import 'package:algolia_client_composition/src/model/redirect_rule_index_data.dart';
import 'package:algolia_client_composition/src/model/redirect_rule_index_metadata.dart';
import 'package:algolia_client_composition/src/model/redirect_url.dart';
import 'package:algolia_client_composition/src/model/rendering_content.dart';
import 'package:algolia_client_composition/src/model/request_body.dart';
import 'package:algolia_client_composition/src/model/results_composition_info_response.dart';
import 'package:algolia_client_composition/src/model/results_compositions_response.dart';
import 'package:algolia_client_composition/src/model/results_injected_item_applied_rules_info_response.dart';
import 'package:algolia_client_composition/src/model/results_injected_item_info_response.dart';
import 'package:algolia_client_composition/src/model/search_for_facet_values_params.dart';
import 'package:algolia_client_composition/src/model/search_for_facet_values_request.dart';
import 'package:algolia_client_composition/src/model/search_for_facet_values_response.dart';
import 'package:algolia_client_composition/src/model/search_for_facet_values_results.dart';
import 'package:algolia_client_composition/src/model/search_hits.dart';
import 'package:algolia_client_composition/src/model/search_pagination.dart';
import 'package:algolia_client_composition/src/model/search_response.dart';
import 'package:algolia_client_composition/src/model/search_results.dart';
import 'package:algolia_client_composition/src/model/search_results_item.dart';
import 'package:algolia_client_composition/src/model/snippet_result_option.dart';
import 'package:algolia_client_composition/src/model/sort_remaining_by.dart';
import 'package:algolia_client_composition/src/model/supported_language.dart';
import 'package:algolia_client_composition/src/model/value.dart';
import 'package:algolia_client_composition/src/model/widgets.dart';

final _regList = RegExp(r'^List<(.*)>$');
final _regSet = RegExp(r'^Set<(.*)>$');
final _regMap = RegExp(r'^Map<String,(.*)>$');

ReturnType deserialize<ReturnType, BaseType>(dynamic value, String targetType,
    {bool growable = true}) {
  switch (targetType) {
    case 'String':
      return '$value' as ReturnType;
    case 'int':
      return (value is int ? value : int.parse('$value')) as ReturnType;
    case 'bool':
      if (value is bool) {
        return value as ReturnType;
      }
      final valueString = '$value'.toLowerCase();
      return (valueString == 'true' || valueString == '1') as ReturnType;
    case 'double':
      return (value is double ? value : double.parse('$value')) as ReturnType;
    case 'AroundRadiusAll':
      return AroundRadiusAll.fromJson(value) as ReturnType;
    case 'Banner':
      return Banner.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'BannerImage':
      return BannerImage.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'BannerImageUrl':
      return BannerImageUrl.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BannerLink':
      return BannerLink.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'BaseSearchResponse':
      return BaseSearchResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'CompositionBaseSearchResponse':
      return CompositionBaseSearchResponse.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'CompositionIdRankingInfo':
      return CompositionIdRankingInfo.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'CompositionRankingInfo':
      return CompositionRankingInfo.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'CompositionRunAppliedRules':
      return CompositionRunAppliedRules.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'CompositionRunSearchResponse':
      return CompositionRunSearchResponse.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'CompositionsSearchResponse':
      return CompositionsSearchResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ErrorBase':
      return ErrorBase.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'Exhaustive':
      return Exhaustive.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'FacetHits':
      return FacetHits.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'FacetOrdering':
      return FacetOrdering.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'FacetStats':
      return FacetStats.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'Facets':
      return Facets.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'HighlightResultOption':
      return HighlightResultOption.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Hit':
      return Hit.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'HitMetadata':
      return HitMetadata.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'HitRankingInfo':
      return HitRankingInfo.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'MatchLevel':
      return MatchLevel.fromJson(value) as ReturnType;
    case 'MatchedGeoLocation':
      return MatchedGeoLocation.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Params':
      return Params.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'Personalization':
      return Personalization.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Range':
      return Range.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'RankingInfo':
      return RankingInfo.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'Redirect':
      return Redirect.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'RedirectRuleIndexData':
      return RedirectRuleIndexData.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RedirectRuleIndexMetadata':
      return RedirectRuleIndexMetadata.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RedirectURL':
      return RedirectURL.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'RenderingContent':
      return RenderingContent.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RequestBody':
      return RequestBody.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'ResultsCompositionInfoResponse':
      return ResultsCompositionInfoResponse.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'ResultsCompositionsResponse':
      return ResultsCompositionsResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ResultsInjectedItemAppliedRulesInfoResponse':
      return ResultsInjectedItemAppliedRulesInfoResponse.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'ResultsInjectedItemInfoResponse':
      return ResultsInjectedItemInfoResponse.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'SearchForFacetValuesParams':
      return SearchForFacetValuesParams.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchForFacetValuesRequest':
      return SearchForFacetValuesRequest.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchForFacetValuesResponse':
      return SearchForFacetValuesResponse.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'SearchForFacetValuesResults':
      return SearchForFacetValuesResults.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchHits':
      return SearchHits.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'SearchPagination':
      return SearchPagination.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchResponse':
      return SearchResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchResults':
      return SearchResults.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchResultsItem':
      return SearchResultsItem.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SnippetResultOption':
      return SnippetResultOption.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SortRemainingBy':
      return SortRemainingBy.fromJson(value) as ReturnType;
    case 'SupportedLanguage':
      return SupportedLanguage.fromJson(value) as ReturnType;
    case 'Value':
      return Value.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'Widgets':
      return Widgets.fromJson(value as Map<String, dynamic>) as ReturnType;
    default:
      RegExpMatch? match;

      if (value is List && (match = _regList.firstMatch(targetType)) != null) {
        targetType = match![1]!; // ignore: parameter_assignments
        return value
            .map<BaseType>((dynamic v) => deserialize<BaseType, BaseType>(
                v, targetType,
                growable: growable))
            .toList(growable: growable) as ReturnType;
      }
      if (value is Set && (match = _regSet.firstMatch(targetType)) != null) {
        targetType = match![1]!; // ignore: parameter_assignments
        return value
            .map<BaseType>((dynamic v) => deserialize<BaseType, BaseType>(
                v, targetType,
                growable: growable))
            .toSet() as ReturnType;
      }
      if (value is Map && (match = _regMap.firstMatch(targetType)) != null) {
        targetType = match![1]!; // ignore: parameter_assignments
        return Map<dynamic, BaseType>.fromIterables(
          value.keys,
          value.values.map((dynamic v) => deserialize<BaseType, BaseType>(
              v, targetType,
              growable: growable)),
        ) as ReturnType;
      }
      if (targetType == 'Object') {
        return value;
      }
      break;
  }
  throw Exception('Cannot deserialize');
}
