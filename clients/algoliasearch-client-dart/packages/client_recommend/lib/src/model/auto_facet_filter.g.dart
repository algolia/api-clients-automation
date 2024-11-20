// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'auto_facet_filter.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AutoFacetFilter _$AutoFacetFilterFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'AutoFacetFilter',
      json,
      ($checkedConvert) {
        final val = AutoFacetFilter(
          facet: $checkedConvert('facet', (v) => v as String?),
          negative: $checkedConvert('negative', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$AutoFacetFilterToJson(AutoFacetFilter instance) =>
    <String, dynamic>{
      if (instance.facet case final value?) 'facet': value,
      if (instance.negative case final value?) 'negative': value,
    };
