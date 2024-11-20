// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'bought_together_query.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BoughtTogetherQuery _$BoughtTogetherQueryFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'BoughtTogetherQuery',
      json,
      ($checkedConvert) {
        final val = BoughtTogetherQuery(
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
              'model', (v) => $enumDecode(_$FbtModelEnumMap, v)),
          objectID: $checkedConvert('objectID', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$BoughtTogetherQueryToJson(
        BoughtTogetherQuery instance) =>
    <String, dynamic>{
      'indexName': instance.indexName,
      'threshold': instance.threshold,
      if (instance.maxRecommendations case final value?)
        'maxRecommendations': value,
      if (instance.queryParameters?.toJson() case final value?)
        'queryParameters': value,
      'model': instance.model.toJson(),
      'objectID': instance.objectID,
    };

const _$FbtModelEnumMap = {
  FbtModel.boughtTogether: 'bought-together',
};
