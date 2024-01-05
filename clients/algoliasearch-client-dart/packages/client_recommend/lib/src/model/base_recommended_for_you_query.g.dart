// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'base_recommended_for_you_query.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BaseRecommendedForYouQuery _$BaseRecommendedForYouQueryFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'BaseRecommendedForYouQuery',
      json,
      ($checkedConvert) {
        final val = BaseRecommendedForYouQuery(
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

Map<String, dynamic> _$BaseRecommendedForYouQueryToJson(
    BaseRecommendedForYouQuery instance) {
  final val = <String, dynamic>{
    'model': instance.model.toJson(),
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

const _$RecommendedForYouModelEnumMap = {
  RecommendedForYouModel.recommendedForYou: 'recommended-for-you',
};
