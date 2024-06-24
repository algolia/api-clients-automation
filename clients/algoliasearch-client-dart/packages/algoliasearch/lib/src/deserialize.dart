import 'package:algoliasearch/src/model/acl.dart';
import 'package:algoliasearch/src/model/advanced_syntax_features.dart';
import 'package:algoliasearch/src/model/alternatives_as_exact.dart';
import 'package:algoliasearch/src/model/api_key.dart';
import 'package:algoliasearch/src/model/around_precision_from_value_inner.dart';
import 'package:algoliasearch/src/model/around_radius_all.dart';
import 'package:algoliasearch/src/model/automatic_facet_filter.dart';
import 'package:algoliasearch/src/model/base_get_api_key_response.dart';
import 'package:algoliasearch/src/model/base_index_settings.dart';
import 'package:algoliasearch/src/model/base_recommend_request.dart';
import 'package:algoliasearch/src/model/base_search_params.dart';
import 'package:algoliasearch/src/model/base_search_params_without_query.dart';
import 'package:algoliasearch/src/model/base_search_response.dart';
import 'package:algoliasearch/src/model/bought_together_query.dart';
import 'package:algoliasearch/src/model/browse_params_object.dart';
import 'package:algoliasearch/src/model/browse_response.dart';
import 'package:algoliasearch/src/model/consequence_params.dart';
import 'package:algoliasearch/src/model/consequence_query_object.dart';
import 'package:algoliasearch/src/model/cursor.dart';
import 'package:algoliasearch/src/model/edit.dart';
import 'package:algoliasearch/src/model/edit_type.dart';
import 'package:algoliasearch/src/model/error_base.dart';
import 'package:algoliasearch/src/model/exact_on_single_word_query.dart';
import 'package:algoliasearch/src/model/exhaustive.dart';
import 'package:algoliasearch/src/model/facet_hits.dart';
import 'package:algoliasearch/src/model/facet_ordering.dart';
import 'package:algoliasearch/src/model/facets.dart';
import 'package:algoliasearch/src/model/facets_stats.dart';
import 'package:algoliasearch/src/model/fallback_params.dart';
import 'package:algoliasearch/src/model/fbt_model.dart';
import 'package:algoliasearch/src/model/frequently_bought_together.dart';
import 'package:algoliasearch/src/model/get_api_key_response.dart';
import 'package:algoliasearch/src/model/get_recommendations_params.dart';
import 'package:algoliasearch/src/model/get_recommendations_response.dart';
import 'package:algoliasearch/src/model/highlight_result_option.dart';
import 'package:algoliasearch/src/model/hit.dart';
import 'package:algoliasearch/src/model/index_settings.dart';
import 'package:algoliasearch/src/model/index_settings_as_search_params.dart';
import 'package:algoliasearch/src/model/looking_similar.dart';
import 'package:algoliasearch/src/model/looking_similar_model.dart';
import 'package:algoliasearch/src/model/looking_similar_query.dart';
import 'package:algoliasearch/src/model/match_level.dart';
import 'package:algoliasearch/src/model/matched_geo_location.dart';
import 'package:algoliasearch/src/model/mode.dart';
import 'package:algoliasearch/src/model/params.dart';
import 'package:algoliasearch/src/model/personalization.dart';
import 'package:algoliasearch/src/model/query_type.dart';
import 'package:algoliasearch/src/model/ranking_info.dart';
import 'package:algoliasearch/src/model/recommend_hit.dart';
import 'package:algoliasearch/src/model/recommendations_hits.dart';
import 'package:algoliasearch/src/model/recommendations_results.dart';
import 'package:algoliasearch/src/model/recommended_for_you.dart';
import 'package:algoliasearch/src/model/recommended_for_you_model.dart';
import 'package:algoliasearch/src/model/recommended_for_you_query.dart';
import 'package:algoliasearch/src/model/redirect.dart';
import 'package:algoliasearch/src/model/redirect_rule_index_metadata.dart';
import 'package:algoliasearch/src/model/redirect_rule_index_metadata_data.dart';
import 'package:algoliasearch/src/model/related_model.dart';
import 'package:algoliasearch/src/model/related_products.dart';
import 'package:algoliasearch/src/model/related_query.dart';
import 'package:algoliasearch/src/model/remove_words_if_no_results.dart';
import 'package:algoliasearch/src/model/rendering_content.dart';
import 'package:algoliasearch/src/model/search_for_facet_values_response.dart';
import 'package:algoliasearch/src/model/search_for_facets.dart';
import 'package:algoliasearch/src/model/search_for_facets_options.dart';
import 'package:algoliasearch/src/model/search_for_hits.dart';
import 'package:algoliasearch/src/model/search_for_hits_options.dart';
import 'package:algoliasearch/src/model/search_hits.dart';
import 'package:algoliasearch/src/model/search_method_params.dart';
import 'package:algoliasearch/src/model/search_params.dart';
import 'package:algoliasearch/src/model/search_params_object.dart';
import 'package:algoliasearch/src/model/search_params_query.dart';
import 'package:algoliasearch/src/model/search_response.dart';
import 'package:algoliasearch/src/model/search_responses.dart';
import 'package:algoliasearch/src/model/search_strategy.dart';
import 'package:algoliasearch/src/model/search_type_default.dart';
import 'package:algoliasearch/src/model/search_type_facet.dart';
import 'package:algoliasearch/src/model/semantic_search.dart';
import 'package:algoliasearch/src/model/snippet_result_option.dart';
import 'package:algoliasearch/src/model/sort_remaining_by.dart';
import 'package:algoliasearch/src/model/supported_language.dart';
import 'package:algoliasearch/src/model/trending_facet_hit.dart';
import 'package:algoliasearch/src/model/trending_facets.dart';
import 'package:algoliasearch/src/model/trending_facets_model.dart';
import 'package:algoliasearch/src/model/trending_facets_query.dart';
import 'package:algoliasearch/src/model/trending_items.dart';
import 'package:algoliasearch/src/model/trending_items_model.dart';
import 'package:algoliasearch/src/model/trending_items_query.dart';
import 'package:algoliasearch/src/model/typo_tolerance_enum.dart';
import 'package:algoliasearch/src/model/value.dart';

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
    case 'Acl':
      return Acl.fromJson(value) as ReturnType;
    case 'AdvancedSyntaxFeatures':
      return AdvancedSyntaxFeatures.fromJson(value) as ReturnType;
    case 'AlternativesAsExact':
      return AlternativesAsExact.fromJson(value) as ReturnType;
    case 'ApiKey':
      return ApiKey.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'AroundPrecisionFromValueInner':
      return AroundPrecisionFromValueInner.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'AroundRadiusAll':
      return AroundRadiusAll.fromJson(value) as ReturnType;
    case 'AutomaticFacetFilter':
      return AutomaticFacetFilter.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BaseGetApiKeyResponse':
      return BaseGetApiKeyResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BaseIndexSettings':
      return BaseIndexSettings.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BaseRecommendRequest':
      return BaseRecommendRequest.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BaseSearchParams':
      return BaseSearchParams.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BaseSearchParamsWithoutQuery':
      return BaseSearchParamsWithoutQuery.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'BaseSearchResponse':
      return BaseSearchResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BoughtTogetherQuery':
      return BoughtTogetherQuery.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BrowseParamsObject':
      return BrowseParamsObject.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'BrowseResponse':
      return BrowseResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ConsequenceParams':
      return ConsequenceParams.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'ConsequenceQueryObject':
      return ConsequenceQueryObject.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Cursor':
      return Cursor.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'Edit':
      return Edit.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'EditType':
      return EditType.fromJson(value) as ReturnType;
    case 'ErrorBase':
      return ErrorBase.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'ExactOnSingleWordQuery':
      return ExactOnSingleWordQuery.fromJson(value) as ReturnType;
    case 'Exhaustive':
      return Exhaustive.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'FacetHits':
      return FacetHits.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'FacetOrdering':
      return FacetOrdering.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Facets':
      return Facets.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'FacetsStats':
      return FacetsStats.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'FallbackParams':
      return FallbackParams.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'FbtModel':
      return FbtModel.fromJson(value) as ReturnType;
    case 'FrequentlyBoughtTogether':
      return FrequentlyBoughtTogether.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'GetApiKeyResponse':
      return GetApiKeyResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'GetRecommendationsParams':
      return GetRecommendationsParams.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'GetRecommendationsResponse':
      return GetRecommendationsResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'HighlightResultOption':
      return HighlightResultOption.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'Hit':
      return Hit.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'IndexSettings':
      return IndexSettings.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'IndexSettingsAsSearchParams':
      return IndexSettingsAsSearchParams.fromJson(value as Map<String, dynamic>)
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
    case 'Mode':
      return Mode.fromJson(value) as ReturnType;
    case 'Params':
      return Params.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'Personalization':
      return Personalization.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'QueryType':
      return QueryType.fromJson(value) as ReturnType;
    case 'RankingInfo':
      return RankingInfo.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'RecommendHit':
      return RecommendHit.fromJson(value as Map<String, dynamic>) as ReturnType;
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
    case 'RedirectRuleIndexMetadata':
      return RedirectRuleIndexMetadata.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'RedirectRuleIndexMetadataData':
      return RedirectRuleIndexMetadataData.fromJson(
          value as Map<String, dynamic>) as ReturnType;
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
    case 'SearchForFacetValuesResponse':
      return SearchForFacetValuesResponse.fromJson(
          value as Map<String, dynamic>) as ReturnType;
    case 'SearchForFacets':
      return SearchForFacets.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchForFacetsOptions':
      return SearchForFacetsOptions.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchForHits':
      return SearchForHits.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchForHitsOptions':
      return SearchForHitsOptions.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchHits':
      return SearchHits.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'SearchMethodParams':
      return SearchMethodParams.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchParams':
      return SearchParams.fromJson(value as Map<String, dynamic>) as ReturnType;
    case 'SearchParamsObject':
      return SearchParamsObject.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchParamsQuery':
      return SearchParamsQuery.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchResponse':
      return SearchResponse.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchResponses':
      return SearchResponses.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SearchStrategy':
      return SearchStrategy.fromJson(value) as ReturnType;
    case 'SearchTypeDefault':
      return SearchTypeDefault.fromJson(value) as ReturnType;
    case 'SearchTypeFacet':
      return SearchTypeFacet.fromJson(value) as ReturnType;
    case 'SemanticSearch':
      return SemanticSearch.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SnippetResultOption':
      return SnippetResultOption.fromJson(value as Map<String, dynamic>)
          as ReturnType;
    case 'SortRemainingBy':
      return SortRemainingBy.fromJson(value) as ReturnType;
    case 'SupportedLanguage':
      return SupportedLanguage.fromJson(value) as ReturnType;
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
