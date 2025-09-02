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

Map<String, dynamic> _$TrendingFacetsQueryToJson(TrendingFacetsQuery instance) {
  final val = <String, dynamic>{
    'indexName': instance.indexName,
    'threshold': instance.threshold,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('maxRecommendations', instance.maxRecommendations);
  writeNotNull('queryParameters', instance.queryParameters?.toJson());
  val['facetName'] = instance.facetName;
  val['model'] = instance.model.toJson();
  writeNotNull('fallbackParameters', instance.fallbackParameters?.toJson());
  return val;
}

const _$TrendingFacetsModelEnumMap = {
  TrendingFacetsModel.trendingFacets: 'trending-facets',
};
