// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'trending_items_query.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TrendingItemsQuery _$TrendingItemsQueryFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'TrendingItemsQuery',
      json,
      ($checkedConvert) {
        final val = TrendingItemsQuery(
          indexName: $checkedConvert('indexName', (v) => v as String),
          threshold: $checkedConvert('threshold', (v) => (v as num).toDouble()),
          maxRecommendations:
              $checkedConvert('maxRecommendations', (v) => v as int?),
          queryParameters: $checkedConvert(
              'queryParameters',
              (v) => v == null
                  ? null
                  : SearchParams.fromJson(v as Map<String, dynamic>)),
          facetName: $checkedConvert('facetName', (v) => v as String),
          facetValue: $checkedConvert('facetValue', (v) => v as String),
          model: $checkedConvert(
              'model', (v) => $enumDecode(_$TrendingItemsModelEnumMap, v)),
          fallbackParameters: $checkedConvert(
              'fallbackParameters',
              (v) => v == null
                  ? null
                  : SearchParamsObject.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$TrendingItemsQueryToJson(TrendingItemsQuery instance) {
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
  val['facetValue'] = instance.facetValue;
  val['model'] = instance.model.toJson();
  writeNotNull('fallbackParameters', instance.fallbackParameters?.toJson());
  return val;
}

const _$TrendingItemsModelEnumMap = {
  TrendingItemsModel.trendingItems: 'trending-items',
};
