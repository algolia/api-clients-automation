// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'trending_items.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TrendingItems _$TrendingItemsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'TrendingItems',
      json,
      ($checkedConvert) {
        final val = TrendingItems(
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

Map<String, dynamic> _$TrendingItemsToJson(TrendingItems instance) =>
    <String, dynamic>{
      if (instance.facetName case final value?) 'facetName': value,
      if (instance.facetValue case final value?) 'facetValue': value,
      'model': instance.model.toJson(),
      if (instance.fallbackParameters?.toJson() case final value?)
        'fallbackParameters': value,
    };

const _$TrendingItemsModelEnumMap = {
  TrendingItemsModel.trendingItems: 'trending-items',
};
