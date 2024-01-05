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
          threshold: $checkedConvert('threshold', (v) => v as int?),
          maxRecommendations:
              $checkedConvert('maxRecommendations', (v) => v as int?),
          facetName: $checkedConvert('facetName', (v) => v as String),
          model: $checkedConvert('model',
              (v) => $enumDecodeNullable(_$TrendingFacetsModelEnumMap, v)),
        );
        return val;
      },
    );

Map<String, dynamic> _$TrendingFacetsQueryToJson(TrendingFacetsQuery instance) {
  final val = <String, dynamic>{
    'indexName': instance.indexName,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('threshold', instance.threshold);
  writeNotNull('maxRecommendations', instance.maxRecommendations);
  val['facetName'] = instance.facetName;
  writeNotNull('model', instance.model?.toJson());
  return val;
}

const _$TrendingFacetsModelEnumMap = {
  TrendingFacetsModel.trendingFacets: 'trending-facets',
};
