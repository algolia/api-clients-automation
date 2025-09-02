// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'hit_ranking_info.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

HitRankingInfo _$HitRankingInfoFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'HitRankingInfo',
      json,
      ($checkedConvert) {
        final val = HitRankingInfo(
          filters: $checkedConvert('filters', (v) => (v as num?)?.toInt()),
          firstMatchedWord:
              $checkedConvert('firstMatchedWord', (v) => (v as num).toInt()),
          geoDistance:
              $checkedConvert('geoDistance', (v) => (v as num).toInt()),
          geoPrecision:
              $checkedConvert('geoPrecision', (v) => (v as num?)?.toInt()),
          matchedGeoLocation: $checkedConvert(
              'matchedGeoLocation',
              (v) => v == null
                  ? null
                  : MatchedGeoLocation.fromJson(v as Map<String, dynamic>)),
          personalization: $checkedConvert(
              'personalization',
              (v) => v == null
                  ? null
                  : Personalization.fromJson(v as Map<String, dynamic>)),
          nbExactWords:
              $checkedConvert('nbExactWords', (v) => (v as num).toInt()),
          nbTypos: $checkedConvert('nbTypos', (v) => (v as num).toInt()),
          promoted: $checkedConvert('promoted', (v) => v as bool?),
          proximityDistance:
              $checkedConvert('proximityDistance', (v) => (v as num?)?.toInt()),
          userScore: $checkedConvert('userScore', (v) => (v as num).toInt()),
          words: $checkedConvert('words', (v) => (v as num?)?.toInt()),
          promotedByReRanking:
              $checkedConvert('promotedByReRanking', (v) => v as bool?),
          composed: $checkedConvert(
              'composed',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(
                        k,
                        CompositionIdRankingInfo.fromJson(
                            e as Map<String, dynamic>)),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$HitRankingInfoToJson(HitRankingInfo instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('filters', instance.filters);
  val['firstMatchedWord'] = instance.firstMatchedWord;
  val['geoDistance'] = instance.geoDistance;
  writeNotNull('geoPrecision', instance.geoPrecision);
  writeNotNull('matchedGeoLocation', instance.matchedGeoLocation?.toJson());
  writeNotNull('personalization', instance.personalization?.toJson());
  val['nbExactWords'] = instance.nbExactWords;
  val['nbTypos'] = instance.nbTypos;
  writeNotNull('promoted', instance.promoted);
  writeNotNull('proximityDistance', instance.proximityDistance);
  val['userScore'] = instance.userScore;
  writeNotNull('words', instance.words);
  writeNotNull('promotedByReRanking', instance.promotedByReRanking);
  writeNotNull(
      'composed', instance.composed?.map((k, e) => MapEntry(k, e.toJson())));
  return val;
}
