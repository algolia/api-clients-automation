// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'recommended_for_you.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RecommendedForYou _$RecommendedForYouFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'RecommendedForYou',
      json,
      ($checkedConvert) {
        final val = RecommendedForYou(
          model: $checkedConvert(
              'model', (v) => $enumDecode(_$RecommendedForYouModelEnumMap, v)),
          fallbackParameters: $checkedConvert(
              'fallbackParameters',
              (v) => v == null
                  ? null
                  : FallbackParams.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$RecommendedForYouToJson(RecommendedForYou instance) {
  final val = <String, dynamic>{
    'model': instance.model.toJson(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('fallbackParameters', instance.fallbackParameters?.toJson());
  return val;
}

const _$RecommendedForYouModelEnumMap = {
  RecommendedForYouModel.recommendedForYou: 'recommended-for-you',
};
