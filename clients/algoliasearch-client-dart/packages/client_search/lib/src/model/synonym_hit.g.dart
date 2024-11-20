// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'synonym_hit.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SynonymHit _$SynonymHitFromJson(Map<String, dynamic> json) => $checkedCreate(
      'SynonymHit',
      json,
      ($checkedConvert) {
        final val = SynonymHit(
          objectID: $checkedConvert('objectID', (v) => v as String),
          type: $checkedConvert(
              'type', (v) => $enumDecode(_$SynonymTypeEnumMap, v)),
          synonyms: $checkedConvert('synonyms',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          input: $checkedConvert('input', (v) => v as String?),
          word: $checkedConvert('word', (v) => v as String?),
          corrections: $checkedConvert('corrections',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          placeholder: $checkedConvert('placeholder', (v) => v as String?),
          replacements: $checkedConvert('replacements',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$SynonymHitToJson(SynonymHit instance) =>
    <String, dynamic>{
      'objectID': instance.objectID,
      'type': instance.type.toJson(),
      if (instance.synonyms case final value?) 'synonyms': value,
      if (instance.input case final value?) 'input': value,
      if (instance.word case final value?) 'word': value,
      if (instance.corrections case final value?) 'corrections': value,
      if (instance.placeholder case final value?) 'placeholder': value,
      if (instance.replacements case final value?) 'replacements': value,
    };

const _$SynonymTypeEnumMap = {
  SynonymType.synonym: 'synonym',
  SynonymType.onewaysynonym: 'onewaysynonym',
  SynonymType.altcorrection1: 'altcorrection1',
  SynonymType.altcorrection2: 'altcorrection2',
  SynonymType.placeholder: 'placeholder',
  SynonymType.oneWaySynonym: 'oneWaySynonym',
  SynonymType.altCorrection1: 'altCorrection1',
  SynonymType.altCorrection2: 'altCorrection2',
};
