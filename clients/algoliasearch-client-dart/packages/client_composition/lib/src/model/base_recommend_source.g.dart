// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'base_recommend_source.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BaseRecommendSource _$BaseRecommendSourceFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'BaseRecommendSource',
      json,
      ($checkedConvert) {
        final val = BaseRecommendSource(
          indexName: $checkedConvert('indexName', (v) => v as String),
          model:
              $checkedConvert('model', (v) => $enumDecode(_$ModelEnumMap, v)),
          threshold: $checkedConvert('threshold', (v) => (v as num).toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$BaseRecommendSourceToJson(
        BaseRecommendSource instance) =>
    <String, dynamic>{
      'indexName': instance.indexName,
      'model': instance.model.toJson(),
      'threshold': instance.threshold,
    };

const _$ModelEnumMap = {
  Model.trendingItems: 'trending-items',
};
