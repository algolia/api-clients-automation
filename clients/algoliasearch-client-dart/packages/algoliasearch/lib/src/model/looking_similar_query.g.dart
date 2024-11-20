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

Map<String, dynamic> _$LookingSimilarQueryToJson(
        LookingSimilarQuery instance) =>
    <String, dynamic>{
      'indexName': instance.indexName,
      'threshold': instance.threshold,
      if (instance.maxRecommendations case final value?)
        'maxRecommendations': value,
      if (instance.queryParameters?.toJson() case final value?)
        'queryParameters': value,
      'model': instance.model.toJson(),
      'objectID': instance.objectID,
      if (instance.fallbackParameters?.toJson() case final value?)
        'fallbackParameters': value,
    };

const _$LookingSimilarModelEnumMap = {
  LookingSimilarModel.lookingSimilar: 'looking-similar',
};
