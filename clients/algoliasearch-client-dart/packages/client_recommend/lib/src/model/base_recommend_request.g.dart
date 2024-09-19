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
    BaseRecommendRequest instance) {
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
  return val;
}
