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
          maxRecommendations: $checkedConvert(
              'maxRecommendations', (v) => (v as num?)?.toInt()),
          queryParameters: $checkedConvert(
              'queryParameters',
              (v) => v == null
                  ? null
                  : RecommendSearchParams.fromJson(v as Map<String, dynamic>)),
          facetName: $checkedConvert('facetName', (v) => v as String?),
          facetValue: $checkedConvert('facetValue', (v) => v as String?),
          model: $checkedConvert(
              'model', (v) => $enumDecode(_$TrendingItemsModelEnumMap, v)),
          fallbackParameters: $checkedConvert(
              'fallbackParameters',
              (v) => v == null
                  ? null
                  : FallbackParams.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$TrendingItemsQueryToJson(TrendingItemsQuery instance) =>
    <String, dynamic>{
      'indexName': instance.indexName,
      'threshold': instance.threshold,
      if (instance.maxRecommendations case final value?)
        'maxRecommendations': value,
      if (instance.queryParameters?.toJson() case final value?)
        'queryParameters': value,
      if (instance.facetName case final value?) 'facetName': value,
      if (instance.facetValue case final value?) 'facetValue': value,
      'model': instance.model.toJson(),
      if (instance.fallbackParameters?.toJson() case final value?)
        'fallbackParameters': value,
    };

const _$TrendingItemsModelEnumMap = {
  TrendingItemsModel.trendingItems: 'trending-items',
};
