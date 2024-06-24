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

Map<String, dynamic> _$TrendingItemsToJson(TrendingItems instance) {
  final val = <String, dynamic>{
    'facetName': instance.facetName,
    'facetValue': instance.facetValue,
    'model': instance.model.toJson(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('fallbackParameters', instance.fallbackParameters?.toJson());
  return val;
}

const _$TrendingItemsModelEnumMap = {
  TrendingItemsModel.trendingItems: 'trending-items',
};
