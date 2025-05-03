// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'ranking_info.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RankingInfo _$RankingInfoFromJson(Map<String, dynamic> json) => $checkedCreate(
      'RankingInfo',
      json,
      ($checkedConvert) {
        final val = RankingInfo(
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
        );
        return val;
      },
    );

Map<String, dynamic> _$RankingInfoToJson(RankingInfo instance) =>
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
    };
