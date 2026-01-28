import 'package:algolia_client_composition/src/model/action.dart';
import 'package:algolia_client_composition/src/model/advanced_syntax_features.dart';
import 'package:algolia_client_composition/src/model/alternatives_as_exact.dart';
import 'package:algolia_client_composition/src/model/anchoring.dart';
import 'package:algolia_client_composition/src/model/around_radius_all.dart';
import 'package:algolia_client_composition/src/model/banner.dart';
import 'package:algolia_client_composition/src/model/banner_image.dart';
import 'package:algolia_client_composition/src/model/banner_image_url.dart';
import 'package:algolia_client_composition/src/model/banner_link.dart';
import 'package:algolia_client_composition/src/model/base_injection_query_parameters.dart';
import 'package:algolia_client_composition/src/model/base_search_response.dart';
import 'package:algolia_client_composition/src/model/batch_params.dart';
import 'package:algolia_client_composition/src/model/boolean_string.dart';
import 'package:algolia_client_composition/src/model/composition.dart';
import 'package:algolia_client_composition/src/model/composition_base_search_response.dart';
import 'package:algolia_client_composition/src/model/composition_id_ranking_info.dart';
import 'package:algolia_client_composition/src/model/composition_injection_behavior.dart';
import 'package:algolia_client_composition/src/model/composition_multifeed_behavior.dart';
import 'package:algolia_client_composition/src/model/composition_ranking_info.dart';
import 'package:algolia_client_composition/src/model/composition_rule.dart';
import 'package:algolia_client_composition/src/model/composition_rule_consequence.dart';
import 'package:algolia_client_composition/src/model/composition_rules_batch_params.dart';
import 'package:algolia_client_composition/src/model/composition_run_applied_rules.dart';
import 'package:algolia_client_composition/src/model/composition_run_search_response.dart';
import 'package:algolia_client_composition/src/model/composition_source.dart';
import 'package:algolia_client_composition/src/model/composition_source_search.dart';
import 'package:algolia_client_composition/src/model/compositions_search_response.dart';
import 'package:algolia_client_composition/src/model/condition.dart';
import 'package:algolia_client_composition/src/model/dedup_positioning.dart';
import 'package:algolia_client_composition/src/model/deduplication.dart';
import 'package:algolia_client_composition/src/model/delete_composition_action.dart';
import 'package:algolia_client_composition/src/model/delete_composition_rule_action.dart';
import 'package:algolia_client_composition/src/model/error_base.dart';
import 'package:algolia_client_composition/src/model/exact_on_single_word_query.dart';
import 'package:algolia_client_composition/src/model/exhaustive.dart';
import 'package:algolia_client_composition/src/model/external.dart';
import 'package:algolia_client_composition/src/model/external_injected_item.dart';
import 'package:algolia_client_composition/src/model/external_injection.dart';
import 'package:algolia_client_composition/src/model/external_ordering.dart';
import 'package:algolia_client_composition/src/model/external_source.dart';
import 'package:algolia_client_composition/src/model/facet_hits.dart';
import 'package:algolia_client_composition/src/model/facet_ordering.dart';
import 'package:algolia_client_composition/src/model/facet_stats.dart';
import 'package:algolia_client_composition/src/model/get_task_response.dart';
import 'package:algolia_client_composition/src/model/highlight_result_option.dart';
import 'package:algolia_client_composition/src/model/hit.dart';
import 'package:algolia_client_composition/src/model/hit_metadata.dart';
import 'package:algolia_client_composition/src/model/hit_ranking_info.dart';
import 'package:algolia_client_composition/src/model/index_settings_facets.dart';
import 'package:algolia_client_composition/src/model/injected_item.dart';
import 'package:algolia_client_composition/src/model/injected_item_hits_metadata.dart';
import 'package:algolia_client_composition/src/model/injected_item_metadata.dart';
import 'package:algolia_client_composition/src/model/injection.dart';
import 'package:algolia_client_composition/src/model/list_compositions_response.dart';
import 'package:algolia_client_composition/src/model/main.dart';
import 'package:algolia_client_composition/src/model/main_injection_query_parameters.dart';
import 'package:algolia_client_composition/src/model/match_level.dart';
import 'package:algolia_client_composition/src/model/matched_geo_location.dart';
import 'package:algolia_client_composition/src/model/multifeed.dart';
import 'package:algolia_client_composition/src/model/multiple_batch_request.dart';
import 'package:algolia_client_composition/src/model/multiple_batch_response.dart';
import 'package:algolia_client_composition/src/model/params.dart';
import 'package:algolia_client_composition/src/model/personalization.dart';
import 'package:algolia_client_composition/src/model/query_type.dart';
import 'package:algolia_client_composition/src/model/range.dart';
import 'package:algolia_client_composition/src/model/ranking_info.dart';
import 'package:algolia_client_composition/src/model/redirect.dart';
import 'package:algolia_client_composition/src/model/redirect_rule_index_data.dart';
import 'package:algolia_client_composition/src/model/redirect_rule_index_metadata.dart';
import 'package:algolia_client_composition/src/model/redirect_url.dart';
import 'package:algolia_client_composition/src/model/remove_words_if_no_results.dart';
import 'package:algolia_client_composition/src/model/rendering_content.dart';
import 'package:algolia_client_composition/src/model/request_body.dart';
import 'package:algolia_client_composition/src/model/results_composition_info_response.dart';
import 'package:algolia_client_composition/src/model/results_compositions_response.dart';
import 'package:algolia_client_composition/src/model/results_injected_item_applied_rules_info_response.dart';
import 'package:algolia_client_composition/src/model/results_injected_item_info_response.dart';
import 'package:algolia_client_composition/src/model/rules_multiple_batch_request.dart';
import 'package:algolia_client_composition/src/model/rules_multiple_batch_response.dart';
import 'package:algolia_client_composition/src/model/search.dart';
import 'package:algolia_client_composition/src/model/search_composition_rules_params.dart';
import 'package:algolia_client_composition/src/model/search_composition_rules_response.dart';
import 'package:algolia_client_composition/src/model/search_fields.dart';
import 'package:algolia_client_composition/src/model/search_for_facet_values_params.dart';
import 'package:algolia_client_composition/src/model/search_for_facet_values_request.dart';
import 'package:algolia_client_composition/src/model/search_for_facet_values_response.dart';
import 'package:algolia_client_composition/src/model/search_for_facet_values_results.dart';
import 'package:algolia_client_composition/src/model/search_response.dart';
import 'package:algolia_client_composition/src/model/search_results.dart';
import 'package:algolia_client_composition/src/model/search_results_item.dart';
import 'package:algolia_client_composition/src/model/search_source.dart';
import 'package:algolia_client_composition/src/model/snippet_result_option.dart';
import 'package:algolia_client_composition/src/model/sort_remaining_by.dart';
import 'package:algolia_client_composition/src/model/supported_language.dart';
import 'package:algolia_client_composition/src/model/task_id_response.dart';
import 'package:algolia_client_composition/src/model/task_status.dart';
import 'package:algolia_client_composition/src/model/time_range.dart';
import 'package:algolia_client_composition/src/model/typo_tolerance_enum.dart';
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
    case 'Action':
      return Action.fromJson(value) as ReturnType;
    case 'AdvancedSyntaxFeatures':
      return AdvancedSyntaxFeatures.fromJson(value) as ReturnType;
    case 'AlternativesAsExact':
      return AlternativesAsExact.fromJson(value) as ReturnType;
    case 'Anchoring':
      return Anchoring.fromJson(value) as ReturnType;
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
    case 'BaseInjectionQueryParameters':
      return BaseInjectionQueryParameters.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'BaseSearchResponse':
      return BaseSearchResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BatchParams':
      return BatchParams.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'BooleanString':
      return BooleanString.fromJson(value) as ReturnType;
    case 'Composition':
      return Composition.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'CompositionBaseSearchResponse':
      return CompositionBaseSearchResponse.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'CompositionIdRankingInfo':
      return CompositionIdRankingInfo.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'CompositionInjectionBehavior':
      return CompositionInjectionBehavior.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'CompositionMultifeedBehavior':
      return CompositionMultifeedBehavior.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'CompositionRankingInfo':
      return CompositionRankingInfo.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'CompositionRule':
      return CompositionRule.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'CompositionRuleConsequence':
      return CompositionRuleConsequence.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'CompositionRulesBatchParams':
      return CompositionRulesBatchParams.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'CompositionRunAppliedRules':
      return CompositionRunAppliedRules.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'CompositionRunSearchResponse':
      return CompositionRunSearchResponse.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'CompositionSource':
      return CompositionSource.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'CompositionSourceSearch':
      return CompositionSourceSearch.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'CompositionsSearchResponse':
      return CompositionsSearchResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Condition':
      return Condition.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'DedupPositioning':
      return DedupPositioning.fromJson(value) as ReturnType;
    case 'Deduplication':
      return Deduplication.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'DeleteCompositionAction':
      return DeleteCompositionAction.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'DeleteCompositionRuleAction':
      return DeleteCompositionRuleAction.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ErrorBase':
      return ErrorBase.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'ExactOnSingleWordQuery':
      return ExactOnSingleWordQuery.fromJson(value) as ReturnType;
    case 'Exhaustive':
      return Exhaustive.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'External':
      return External.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'ExternalInjectedItem':
      return ExternalInjectedItem.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ExternalInjection':
      return ExternalInjection.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ExternalOrdering':
      return ExternalOrdering.fromJson(value) as ReturnType;
    case 'ExternalSource':
      return ExternalSource.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'FacetHits':
      return FacetHits.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'FacetOrdering':
      return FacetOrdering.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'FacetStats':
      return FacetStats.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'GetTaskResponse':
      return GetTaskResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
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
    case 'IndexSettingsFacets':
      return IndexSettingsFacets.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'InjectedItem':
      return InjectedItem.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'InjectedItemHitsMetadata':
      return InjectedItemHitsMetadata.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'InjectedItemMetadata':
      return InjectedItemMetadata.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Injection':
      return Injection.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'ListCompositionsResponse':
      return ListCompositionsResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Main':
      return Main.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'MainInjectionQueryParameters':
      return MainInjectionQueryParameters.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'MatchLevel':
      return MatchLevel.fromJson(value) as ReturnType;
    case 'MatchedGeoLocation':
      return MatchedGeoLocation.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Multifeed':
      return Multifeed.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'MultipleBatchRequest':
      return MultipleBatchRequest.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'MultipleBatchResponse':
      return MultipleBatchResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Params':
      return Params.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'Personalization':
      return Personalization.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'QueryType':
      return QueryType.fromJson(value) as ReturnType;
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
    case 'RemoveWordsIfNoResults':
      return RemoveWordsIfNoResults.fromJson(value) as ReturnType;
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
    case 'RulesMultipleBatchRequest':
      return RulesMultipleBatchRequest.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RulesMultipleBatchResponse':
      return RulesMultipleBatchResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Search':
      return Search.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'SearchCompositionRulesParams':
      return SearchCompositionRulesParams.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'SearchCompositionRulesResponse':
      return SearchCompositionRulesResponse.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'SearchFields':
      return SearchFields.fromJson(value as Map<String, dynamic>) as ReturnType;
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
    case 'SearchResponse':
      return SearchResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchResults':
      return SearchResults.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchResultsItem':
      return SearchResultsItem.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchSource':
      return SearchSource.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'SnippetResultOption':
      return SnippetResultOption.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SortRemainingBy':
      return SortRemainingBy.fromJson(value) as ReturnType;
    case 'SupportedLanguage':
      return SupportedLanguage.fromJson(value) as ReturnType;
    case 'TaskIDResponse':
      return TaskIDResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'TaskStatus':
      return TaskStatus.fromJson(value) as ReturnType;
    case 'TimeRange':
      return TimeRange.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'TypoToleranceEnum':
      return TypoToleranceEnum.fromJson(value) as ReturnType;
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
