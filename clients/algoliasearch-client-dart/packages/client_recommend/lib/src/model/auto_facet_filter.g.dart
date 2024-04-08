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

Map<String, dynamic> _$AutoFacetFilterToJson(AutoFacetFilter instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('facet', instance.facet);
  writeNotNull('negative', instance.negative);
  return val;
}
