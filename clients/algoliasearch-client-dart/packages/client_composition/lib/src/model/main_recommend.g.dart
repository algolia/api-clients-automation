// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'main_recommend.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MainRecommend _$MainRecommendFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'MainRecommend',
      json,
      ($checkedConvert) {
        final val = MainRecommend(
          indexName: $checkedConvert('indexName', (v) => v as String),
          model:
              $checkedConvert('model', (v) => $enumDecode(_$ModelEnumMap, v)),
          threshold: $checkedConvert('threshold', (v) => (v as num).toInt()),
          queryParameters: $checkedConvert(
              'queryParameters',
              (v) => v == null
                  ? null
                  : MainInjectionQueryParameters.fromJson(
                      v as Map<String, dynamic>)),
          fallbackParameters: $checkedConvert(
              'fallbackParameters',
              (v) => v == null
                  ? null
                  : MainInjectionQueryParameters.fromJson(
                      v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$MainRecommendToJson(MainRecommend instance) {
  final val = <String, dynamic>{
    'indexName': instance.indexName,
    'model': instance.model.toJson(),
    'threshold': instance.threshold,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('queryParameters', instance.queryParameters?.toJson());
  writeNotNull('fallbackParameters', instance.fallbackParameters?.toJson());
  return val;
}

const _$ModelEnumMap = {
  Model.trendingItems: 'trending-items',
};
