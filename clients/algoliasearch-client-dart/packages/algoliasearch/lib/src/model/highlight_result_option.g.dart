// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'highlight_result_option.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

HighlightResultOption _$HighlightResultOptionFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'HighlightResultOption',
      json,
      ($checkedConvert) {
        final val = HighlightResultOption(
          value: $checkedConvert('value', (v) => v as String),
          matchLevel: $checkedConvert(
              'matchLevel', (v) => $enumDecode(_$MatchLevelEnumMap, v)),
          matchedWords: $checkedConvert('matchedWords',
              (v) => (v as List<dynamic>).map((e) => e as String).toList()),
          fullyHighlighted:
              $checkedConvert('fullyHighlighted', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$HighlightResultOptionToJson(
        HighlightResultOption instance) =>
    <String, dynamic>{
      'value': instance.value,
      'matchLevel': instance.matchLevel.toJson(),
      'matchedWords': instance.matchedWords,
      if (instance.fullyHighlighted case final value?)
        'fullyHighlighted': value,
    };

const _$MatchLevelEnumMap = {
  MatchLevel.none: 'none',
  MatchLevel.partial: 'partial',
  MatchLevel.full: 'full',
};
