// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_recommend_rules_params.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchRecommendRulesParams _$SearchRecommendRulesParamsFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchRecommendRulesParams',
      json,
      ($checkedConvert) {
        final val = SearchRecommendRulesParams(
          query: $checkedConvert('query', (v) => v as String?),
          context: $checkedConvert('context', (v) => v as String?),
          page: $checkedConvert('page', (v) => (v as num?)?.toInt()),
          hitsPerPage:
              $checkedConvert('hitsPerPage', (v) => (v as num?)?.toInt()),
          enabled: $checkedConvert('enabled', (v) => v as bool?),
          filters: $checkedConvert('filters', (v) => v as String?),
          facets: $checkedConvert('facets',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          maxValuesPerFacet:
              $checkedConvert('maxValuesPerFacet', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchRecommendRulesParamsToJson(
        SearchRecommendRulesParams instance) =>
    <String, dynamic>{
      if (instance.query case final value?) 'query': value,
      if (instance.context case final value?) 'context': value,
      if (instance.page case final value?) 'page': value,
      if (instance.hitsPerPage case final value?) 'hitsPerPage': value,
      if (instance.enabled case final value?) 'enabled': value,
      if (instance.filters case final value?) 'filters': value,
      if (instance.facets case final value?) 'facets': value,
      if (instance.maxValuesPerFacet case final value?)
        'maxValuesPerFacet': value,
    };
