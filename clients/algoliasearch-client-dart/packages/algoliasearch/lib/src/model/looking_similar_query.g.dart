// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'looking_similar_query.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

LookingSimilarQuery _$LookingSimilarQueryFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'LookingSimilarQuery',
      json,
      ($checkedConvert) {
        final val = LookingSimilarQuery(
          indexName: $checkedConvert('indexName', (v) => v as String),
          threshold: $checkedConvert('threshold', (v) => (v as num).toDouble()),
          maxRecommendations: $checkedConvert(
              'maxRecommendations', (v) => (v as num?)?.toInt()),
          queryParameters: $checkedConvert(
              'queryParameters',
              (v) => v == null
                  ? null
                  : RecommendSearchParams.fromJson(v as Map<String, dynamic>)),
          model: $checkedConvert(
              'model', (v) => $enumDecode(_$LookingSimilarModelEnumMap, v)),
          objectID: $checkedConvert('objectID', (v) => v as String),
          fallbackParameters: $checkedConvert(
              'fallbackParameters',
              (v) => v == null
                  ? null
                  : FallbackParams.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$LookingSimilarQueryToJson(LookingSimilarQuery instance) {
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
  val['model'] = instance.model.toJson();
  val['objectID'] = instance.objectID;
  writeNotNull('fallbackParameters', instance.fallbackParameters?.toJson());
  return val;
}

const _$LookingSimilarModelEnumMap = {
  LookingSimilarModel.lookingSimilar: 'looking-similar',
};
