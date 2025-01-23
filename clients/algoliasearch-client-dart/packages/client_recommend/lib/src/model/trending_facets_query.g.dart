// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'trending_facets_query.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TrendingFacetsQuery _$TrendingFacetsQueryFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'TrendingFacetsQuery',
      json,
      ($checkedConvert) {
        final val = TrendingFacetsQuery(
          indexName: $checkedConvert('indexName', (v) => v as String),
          threshold: $checkedConvert('threshold', (v) => (v as num).toDouble()),
          maxRecommendations: $checkedConvert(
              'maxRecommendations', (v) => (v as num?)?.toInt()),
          queryParameters: $checkedConvert(
              'queryParameters',
              (v) => v == null
                  ? null
                  : RecommendSearchParams.fromJson(v as Map<String, dynamic>)),
          facetName: $checkedConvert('facetName', (v) => v as String),
          model: $checkedConvert(
              'model', (v) => $enumDecode(_$TrendingFacetsModelEnumMap, v)),
          fallbackParameters: $checkedConvert(
              'fallbackParameters',
              (v) => v == null
                  ? null
                  : FallbackParams.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$TrendingFacetsQueryToJson(
        TrendingFacetsQuery instance) =>
    <String, dynamic>{
      'indexName': instance.indexName,
      'threshold': instance.threshold,
      if (instance.maxRecommendations case final value?)
        'maxRecommendations': value,
      if (instance.queryParameters?.toJson() case final value?)
        'queryParameters': value,
      'facetName': instance.facetName,
      'model': instance.model.toJson(),
      if (instance.fallbackParameters?.toJson() case final value?)
        'fallbackParameters': value,
    };

const _$TrendingFacetsModelEnumMap = {
  TrendingFacetsModel.trendingFacets: 'trending-facets',
};
