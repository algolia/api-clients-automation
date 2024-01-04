// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'recommended_for_you_query.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RecommendedForYouQuery _$RecommendedForYouQueryFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'RecommendedForYouQuery',
      json,
      ($checkedConvert) {
        final val = RecommendedForYouQuery(
          indexName: $checkedConvert('indexName', (v) => v as String),
          threshold: $checkedConvert('threshold', (v) => v as int?),
          maxRecommendations:
              $checkedConvert('maxRecommendations', (v) => v as int?),
          model: $checkedConvert(
              'model', (v) => $enumDecode(_$RecommendedForYouModelEnumMap, v)),
          queryParameters: $checkedConvert(
              'queryParameters',
              (v) => v == null
                  ? null
                  : RecommendedForYouQueryParameters.fromJson(
                      v as Map<String, dynamic>)),
          fallbackParameters: $checkedConvert(
              'fallbackParameters',
              (v) => v == null
                  ? null
                  : RecommendedForYouQueryParameters.fromJson(
                      v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$RecommendedForYouQueryToJson(
    RecommendedForYouQuery instance) {
  final val = <String, dynamic>{
    'indexName': instance.indexName,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('threshold', instance.threshold);
  writeNotNull('maxRecommendations', instance.maxRecommendations);
  val['model'] = instance.model.toJson();
  writeNotNull('queryParameters', instance.queryParameters?.toJson());
  writeNotNull('fallbackParameters', instance.fallbackParameters?.toJson());
  return val;
}

const _$RecommendedForYouModelEnumMap = {
  RecommendedForYouModel.recommendedForYou: 'recommended-for-you',
};
