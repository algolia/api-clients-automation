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

Map<String, dynamic> _$TrendingItemsToJson(TrendingItems instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('facetName', instance.facetName);
  writeNotNull('facetValue', instance.facetValue);
  val['model'] = instance.model.toJson();
  writeNotNull('fallbackParameters', instance.fallbackParameters?.toJson());
  return val;
}

const _$TrendingItemsModelEnumMap = {
  TrendingItemsModel.trendingItems: 'trending-items',
};
