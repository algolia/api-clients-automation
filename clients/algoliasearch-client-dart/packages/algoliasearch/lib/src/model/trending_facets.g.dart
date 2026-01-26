// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'trending_facets.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TrendingFacets _$TrendingFacetsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'TrendingFacets',
      json,
      ($checkedConvert) {
        final val = TrendingFacets(
          indexName: $checkedConvert('indexName', (v) => v as String),
          threshold: $checkedConvert('threshold', (v) => (v as num).toDouble()),
          maxRecommendations: $checkedConvert(
              'maxRecommendations', (v) => (v as num?)?.toInt()),
          facetName: $checkedConvert('facetName', (v) => v as String),
          model: $checkedConvert(
              'model', (v) => $enumDecode(_$TrendingFacetsModelEnumMap, v)),
        );
        return val;
      },
    );

Map<String, dynamic> _$TrendingFacetsToJson(TrendingFacets instance) {
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
  val['facetName'] = instance.facetName;
  val['model'] = instance.model.toJson();
  return val;
}

const _$TrendingFacetsModelEnumMap = {
  TrendingFacetsModel.trendingFacets: 'trending-facets',
};
