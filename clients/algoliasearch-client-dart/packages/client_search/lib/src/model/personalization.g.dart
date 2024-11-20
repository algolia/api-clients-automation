// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'personalization.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Personalization _$PersonalizationFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'Personalization',
      json,
      ($checkedConvert) {
        final val = Personalization(
          filtersScore:
              $checkedConvert('filtersScore', (v) => (v as num?)?.toInt()),
          rankingScore:
              $checkedConvert('rankingScore', (v) => (v as num?)?.toInt()),
          score: $checkedConvert('score', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$PersonalizationToJson(Personalization instance) =>
    <String, dynamic>{
      if (instance.filtersScore case final value?) 'filtersScore': value,
      if (instance.rankingScore case final value?) 'rankingScore': value,
      if (instance.score case final value?) 'score': value,
    };
