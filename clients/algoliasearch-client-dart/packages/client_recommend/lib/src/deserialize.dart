import 'package:algolia_client_recommend/src/model/advanced_syntax_features.dart';
import 'package:algolia_client_recommend/src/model/alternatives_as_exact.dart';
import 'package:algolia_client_recommend/src/model/around_radius_all.dart';
import 'package:algolia_client_recommend/src/model/auto_facet_filter.dart';
import 'package:algolia_client_recommend/src/model/base_index_settings.dart';
import 'package:algolia_client_recommend/src/model/base_recommend_index_settings.dart';
import 'package:algolia_client_recommend/src/model/base_recommend_request.dart';
import 'package:algolia_client_recommend/src/model/base_recommend_search_params.dart';
import 'package:algolia_client_recommend/src/model/base_search_response.dart';
import 'package:algolia_client_recommend/src/model/boolean_string.dart';
import 'package:algolia_client_recommend/src/model/bought_together_query.dart';
import 'package:algolia_client_recommend/src/model/condition.dart';
import 'package:algolia_client_recommend/src/model/consequence.dart';
import 'package:algolia_client_recommend/src/model/deleted_at_response.dart';
import 'package:algolia_client_recommend/src/model/error_base.dart';
import 'package:algolia_client_recommend/src/model/exact_on_single_word_query.dart';
import 'package:algolia_client_recommend/src/model/exhaustive.dart';
import 'package:algolia_client_recommend/src/model/facet_ordering.dart';
import 'package:algolia_client_recommend/src/model/facet_stats.dart';
import 'package:algolia_client_recommend/src/model/fallback_params.dart';
import 'package:algolia_client_recommend/src/model/fbt_model.dart';
import 'package:algolia_client_recommend/src/model/frequently_bought_together.dart';
import 'package:algolia_client_recommend/src/model/get_recommend_task_response.dart';
import 'package:algolia_client_recommend/src/model/get_recommendations_params.dart';
import 'package:algolia_client_recommend/src/model/get_recommendations_response.dart';
import 'package:algolia_client_recommend/src/model/hide_consequence_object.dart';
import 'package:algolia_client_recommend/src/model/highlight_result_option.dart';
import 'package:algolia_client_recommend/src/model/index_settings_facets.dart';
import 'package:algolia_client_recommend/src/model/looking_similar.dart';
import 'package:algolia_client_recommend/src/model/looking_similar_model.dart';
import 'package:algolia_client_recommend/src/model/looking_similar_query.dart';
import 'package:algolia_client_recommend/src/model/match_level.dart';
import 'package:algolia_client_recommend/src/model/matched_geo_location.dart';
import 'package:algolia_client_recommend/src/model/params_consequence.dart';
import 'package:algolia_client_recommend/src/model/personalization.dart';
import 'package:algolia_client_recommend/src/model/promote_consequence_object.dart';
import 'package:algolia_client_recommend/src/model/query_type.dart';
import 'package:algolia_client_recommend/src/model/range.dart';
import 'package:algolia_client_recommend/src/model/ranking_info.dart';
import 'package:algolia_client_recommend/src/model/recommend_hit.dart';
import 'package:algolia_client_recommend/src/model/recommend_index_settings.dart';
import 'package:algolia_client_recommend/src/model/recommend_models.dart';
import 'package:algolia_client_recommend/src/model/recommend_rule.dart';
import 'package:algolia_client_recommend/src/model/recommend_search_params.dart';
import 'package:algolia_client_recommend/src/model/recommendations_hits.dart';
import 'package:algolia_client_recommend/src/model/recommendations_results.dart';
import 'package:algolia_client_recommend/src/model/recommended_for_you.dart';
import 'package:algolia_client_recommend/src/model/recommended_for_you_model.dart';
import 'package:algolia_client_recommend/src/model/recommended_for_you_query.dart';
import 'package:algolia_client_recommend/src/model/redirect.dart';
import 'package:algolia_client_recommend/src/model/redirect_rule_index_data.dart';
import 'package:algolia_client_recommend/src/model/redirect_rule_index_metadata.dart';
import 'package:algolia_client_recommend/src/model/redirect_url.dart';
import 'package:algolia_client_recommend/src/model/related_model.dart';
import 'package:algolia_client_recommend/src/model/related_products.dart';
import 'package:algolia_client_recommend/src/model/related_query.dart';
import 'package:algolia_client_recommend/src/model/remove_words_if_no_results.dart';
import 'package:algolia_client_recommend/src/model/rendering_content.dart';
import 'package:algolia_client_recommend/src/model/rule_metadata.dart';
import 'package:algolia_client_recommend/src/model/search_pagination.dart';
import 'package:algolia_client_recommend/src/model/search_params_query.dart';
import 'package:algolia_client_recommend/src/model/search_recommend_rules_params.dart';
import 'package:algolia_client_recommend/src/model/search_recommend_rules_response.dart';
import 'package:algolia_client_recommend/src/model/snippet_result_option.dart';
import 'package:algolia_client_recommend/src/model/sort_remaining_by.dart';
import 'package:algolia_client_recommend/src/model/supported_language.dart';
import 'package:algolia_client_recommend/src/model/task_status.dart';
import 'package:algolia_client_recommend/src/model/trending_facet_hit.dart';
import 'package:algolia_client_recommend/src/model/trending_facets.dart';
import 'package:algolia_client_recommend/src/model/trending_facets_model.dart';
import 'package:algolia_client_recommend/src/model/trending_facets_query.dart';
import 'package:algolia_client_recommend/src/model/trending_items.dart';
import 'package:algolia_client_recommend/src/model/trending_items_model.dart';
import 'package:algolia_client_recommend/src/model/trending_items_query.dart';
import 'package:algolia_client_recommend/src/model/typo_tolerance_enum.dart';
import 'package:algolia_client_recommend/src/model/value.dart';

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
    case 'AdvancedSyntaxFeatures':
      return AdvancedSyntaxFeatures.fromJson(value) as ReturnType;
    case 'AlternativesAsExact':
      return AlternativesAsExact.fromJson(value) as ReturnType;
    case 'AroundRadiusAll':
      return AroundRadiusAll.fromJson(value) as ReturnType;
    case 'AutoFacetFilter':
      return AutoFacetFilter.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BaseIndexSettings':
      return BaseIndexSettings.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BaseRecommendIndexSettings':
      return BaseRecommendIndexSettings.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BaseRecommendRequest':
      return BaseRecommendRequest.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BaseRecommendSearchParams':
      return BaseRecommendSearchParams.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BaseSearchResponse':
      return BaseSearchResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BooleanString':
      return BooleanString.fromJson(value) as ReturnType;
    case 'BoughtTogetherQuery':
      return BoughtTogetherQuery.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Condition':
      return Condition.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'Consequence':
      return Consequence.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'DeletedAtResponse':
      return DeletedAtResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ErrorBase':
      return ErrorBase.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'ExactOnSingleWordQuery':
      return ExactOnSingleWordQuery.fromJson(value) as ReturnType;
    case 'Exhaustive':
      return Exhaustive.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'FacetOrdering':
      return FacetOrdering.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'FacetStats':
      return FacetStats.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'FallbackParams':
      return FallbackParams.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'FbtModel':
      return FbtModel.fromJson(value) as ReturnType;
    case 'FrequentlyBoughtTogether':
      return FrequentlyBoughtTogether.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'GetRecommendTaskResponse':
      return GetRecommendTaskResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'GetRecommendationsParams':
      return GetRecommendationsParams.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'GetRecommendationsResponse':
      return GetRecommendationsResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'HideConsequenceObject':
      return HideConsequenceObject.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'HighlightResultOption':
      return HighlightResultOption.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'IndexSettingsFacets':
      return IndexSettingsFacets.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'LookingSimilar':
      return LookingSimilar.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'LookingSimilarModel':
      return LookingSimilarModel.fromJson(value) as ReturnType;
    case 'LookingSimilarQuery':
      return LookingSimilarQuery.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'MatchLevel':
      return MatchLevel.fromJson(value) as ReturnType;
    case 'MatchedGeoLocation':
      return MatchedGeoLocation.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ParamsConsequence':
      return ParamsConsequence.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Personalization':
      return Personalization.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'PromoteConsequenceObject':
      return PromoteConsequenceObject.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'QueryType':
      return QueryType.fromJson(value) as ReturnType;
    case 'Range':
      return Range.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'RankingInfo':
      return RankingInfo.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'RecommendHit':
      return RecommendHit.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'RecommendIndexSettings':
      return RecommendIndexSettings.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RecommendModels':
      return RecommendModels.fromJson(value) as ReturnType;
    case 'RecommendRule':
      return RecommendRule.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RecommendSearchParams':
      return RecommendSearchParams.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RecommendationsHits':
      return RecommendationsHits.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RecommendationsResults':
      return RecommendationsResults.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RecommendedForYou':
      return RecommendedForYou.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RecommendedForYouModel':
      return RecommendedForYouModel.fromJson(value) as ReturnType;
    case 'RecommendedForYouQuery':
      return RecommendedForYouQuery.fromJson(value as Map<String, dynamic>)
          as ReturnType;
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
    case 'RelatedModel':
      return RelatedModel.fromJson(value) as ReturnType;
    case 'RelatedProducts':
      return RelatedProducts.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RelatedQuery':
      return RelatedQuery.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'RemoveWordsIfNoResults':
      return RemoveWordsIfNoResults.fromJson(value) as ReturnType;
    case 'RenderingContent':
      return RenderingContent.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RuleMetadata':
      return RuleMetadata.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'SearchPagination':
      return SearchPagination.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchParamsQuery':
      return SearchParamsQuery.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchRecommendRulesParams':
      return SearchRecommendRulesParams.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchRecommendRulesResponse':
      return SearchRecommendRulesResponse.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'SnippetResultOption':
      return SnippetResultOption.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SortRemainingBy':
      return SortRemainingBy.fromJson(value) as ReturnType;
    case 'SupportedLanguage':
      return SupportedLanguage.fromJson(value) as ReturnType;
    case 'TaskStatus':
      return TaskStatus.fromJson(value) as ReturnType;
    case 'TrendingFacetHit':
      return TrendingFacetHit.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'TrendingFacets':
      return TrendingFacets.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'TrendingFacetsModel':
      return TrendingFacetsModel.fromJson(value) as ReturnType;
    case 'TrendingFacetsQuery':
      return TrendingFacetsQuery.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'TrendingItems':
      return TrendingItems.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'TrendingItemsModel':
      return TrendingItemsModel.fromJson(value) as ReturnType;
    case 'TrendingItemsQuery':
      return TrendingItemsQuery.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'TypoToleranceEnum':
      return TypoToleranceEnum.fromJson(value) as ReturnType;
    case 'Value':
      return Value.fromJson(value as Map<String, dynamic>) as ReturnType;
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
