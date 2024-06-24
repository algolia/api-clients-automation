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
        );
        return val;
      },
    );

Map<String, dynamic> _$RecommendationsHitsToJson(
        RecommendationsHits instance) =>
    <String, dynamic>{
      'hits': instance.hits.toList(),
    };
