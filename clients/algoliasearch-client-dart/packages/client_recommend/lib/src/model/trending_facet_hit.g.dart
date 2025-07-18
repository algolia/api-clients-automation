// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'trending_facet_hit.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TrendingFacetHit _$TrendingFacetHitFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'TrendingFacetHit',
      json,
      ($checkedConvert) {
        final val = TrendingFacetHit(
          score: $checkedConvert('_score', (v) => (v as num?)?.toDouble()),
          facetName: $checkedConvert('facetName', (v) => v as String),
          facetValue: $checkedConvert('facetValue', (v) => v as String),
        );
        return val;
      },
      fieldKeyMap: const {'score': '_score'},
    );

Map<String, dynamic> _$TrendingFacetHitToJson(TrendingFacetHit instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('_score', instance.score);
  val['facetName'] = instance.facetName;
  val['facetValue'] = instance.facetValue;
  return val;
}
