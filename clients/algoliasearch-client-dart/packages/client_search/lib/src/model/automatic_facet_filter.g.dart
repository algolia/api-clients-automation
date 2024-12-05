// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'automatic_facet_filter.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AutomaticFacetFilter _$AutomaticFacetFilterFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AutomaticFacetFilter',
      json,
      ($checkedConvert) {
        final val = AutomaticFacetFilter(
          facet: $checkedConvert('facet', (v) => v as String),
          score: $checkedConvert('score', (v) => (v as num?)?.toInt()),
          disjunctive: $checkedConvert('disjunctive', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$AutomaticFacetFilterToJson(
        AutomaticFacetFilter instance) =>
    <String, dynamic>{
      'facet': instance.facet,
      if (instance.score case final value?) 'score': value,
      if (instance.disjunctive case final value?) 'disjunctive': value,
    };
