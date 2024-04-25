// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_recommend_rules_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchRecommendRulesResponse _$SearchRecommendRulesResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchRecommendRulesResponse',
      json,
      ($checkedConvert) {
        final val = SearchRecommendRulesResponse(
          hits: $checkedConvert(
              'hits',
              (v) => (v as List<dynamic>)
                  .map((e) => RecommendRule.fromJson(e as Map<String, dynamic>))
                  .toList()),
          nbHits: $checkedConvert('nbHits', (v) => (v as num).toInt()),
          page: $checkedConvert('page', (v) => (v as num).toInt()),
          nbPages: $checkedConvert('nbPages', (v) => (v as num).toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchRecommendRulesResponseToJson(
        SearchRecommendRulesResponse instance) =>
    <String, dynamic>{
      'hits': instance.hits.map((e) => e.toJson()).toList(),
      'nbHits': instance.nbHits,
      'page': instance.page,
      'nbPages': instance.nbPages,
    };
