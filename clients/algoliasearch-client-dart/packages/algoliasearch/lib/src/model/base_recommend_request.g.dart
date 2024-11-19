// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'base_recommend_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BaseRecommendRequest _$BaseRecommendRequestFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'BaseRecommendRequest',
      json,
      ($checkedConvert) {
        final val = BaseRecommendRequest(
          indexName: $checkedConvert('indexName', (v) => v as String),
          threshold: $checkedConvert('threshold', (v) => (v as num).toDouble()),
          maxRecommendations: $checkedConvert(
              'maxRecommendations', (v) => (v as num?)?.toInt()),
          queryParameters: $checkedConvert(
              'queryParameters',
              (v) => v == null
                  ? null
                  : RecommendSearchParams.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$BaseRecommendRequestToJson(
        BaseRecommendRequest instance) =>
    <String, dynamic>{
      'indexName': instance.indexName,
      'threshold': instance.threshold,
      if (instance.maxRecommendations case final value?)
        'maxRecommendations': value,
      if (instance.queryParameters?.toJson() case final value?)
        'queryParameters': value,
    };
