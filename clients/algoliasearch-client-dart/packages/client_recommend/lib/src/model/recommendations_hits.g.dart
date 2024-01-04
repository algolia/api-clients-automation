// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'recommendations_hits.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RecommendationsHits _$RecommendationsHitsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'RecommendationsHits',
      json,
      ($checkedConvert) {
        final val = RecommendationsHits(
          hits: $checkedConvert('hits', (v) => v as List<dynamic>),
          query: $checkedConvert('query', (v) => v as String?),
          params: $checkedConvert('params', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$RecommendationsHitsToJson(RecommendationsHits instance) {
  final val = <String, dynamic>{
    'hits': instance.hits.toList(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('query', instance.query);
  writeNotNull('params', instance.params);
  return val;
}
