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

Map<String, dynamic> _$HitRankingInfoToJson(HitRankingInfo instance) =>
    <String, dynamic>{
      if (instance.filters case final value?) 'filters': value,
      'firstMatchedWord': instance.firstMatchedWord,
      'geoDistance': instance.geoDistance,
      if (instance.geoPrecision case final value?) 'geoPrecision': value,
      if (instance.matchedGeoLocation?.toJson() case final value?)
        'matchedGeoLocation': value,
      if (instance.personalization?.toJson() case final value?)
        'personalization': value,
      'nbExactWords': instance.nbExactWords,
      'nbTypos': instance.nbTypos,
      if (instance.promoted case final value?) 'promoted': value,
      if (instance.proximityDistance case final value?)
        'proximityDistance': value,
      'userScore': instance.userScore,
      if (instance.words case final value?) 'words': value,
      if (instance.promotedByReRanking case final value?)
        'promotedByReRanking': value,
      if (instance.composed?.map((k, e) => MapEntry(k, e.toJson()))
          case final value?)
        'composed': value,
    };
