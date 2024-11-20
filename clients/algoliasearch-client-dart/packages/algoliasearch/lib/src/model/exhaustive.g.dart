// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'exhaustive.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Exhaustive _$ExhaustiveFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Exhaustive',
      json,
      ($checkedConvert) {
        final val = Exhaustive(
          facetsCount: $checkedConvert('facetsCount', (v) => v as bool?),
          facetValues: $checkedConvert('facetValues', (v) => v as bool?),
          nbHits: $checkedConvert('nbHits', (v) => v as bool?),
          rulesMatch: $checkedConvert('rulesMatch', (v) => v as bool?),
          typo: $checkedConvert('typo', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$ExhaustiveToJson(Exhaustive instance) =>
    <String, dynamic>{
      if (instance.facetsCount case final value?) 'facetsCount': value,
      if (instance.facetValues case final value?) 'facetValues': value,
      if (instance.nbHits case final value?) 'nbHits': value,
      if (instance.rulesMatch case final value?) 'rulesMatch': value,
      if (instance.typo case final value?) 'typo': value,
    };
