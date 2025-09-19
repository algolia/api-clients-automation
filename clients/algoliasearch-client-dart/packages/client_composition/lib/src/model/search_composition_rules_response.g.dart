// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_composition_rules_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchCompositionRulesResponse _$SearchCompositionRulesResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchCompositionRulesResponse',
      json,
      ($checkedConvert) {
        final val = SearchCompositionRulesResponse(
          hits: $checkedConvert(
              'hits',
              (v) => (v as List<dynamic>)
                  .map((e) =>
                      CompositionRule.fromJson(e as Map<String, dynamic>))
                  .toList()),
          nbHits: $checkedConvert('nbHits', (v) => (v as num).toInt()),
          page: $checkedConvert('page', (v) => (v as num).toInt()),
          nbPages: $checkedConvert('nbPages', (v) => (v as num).toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchCompositionRulesResponseToJson(
        SearchCompositionRulesResponse instance) =>
    <String, dynamic>{
      'hits': instance.hits.map((e) => e.toJson()).toList(),
      'nbHits': instance.nbHits,
      'page': instance.page,
      'nbPages': instance.nbPages,
    };
