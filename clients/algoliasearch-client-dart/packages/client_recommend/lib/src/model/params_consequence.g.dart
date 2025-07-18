// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'params_consequence.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ParamsConsequence _$ParamsConsequenceFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ParamsConsequence',
      json,
      ($checkedConvert) {
        final val = ParamsConsequence(
          automaticFacetFilters: $checkedConvert(
              'automaticFacetFilters',
              (v) => (v as List<dynamic>?)
                  ?.map((e) =>
                      AutoFacetFilter.fromJson(e as Map<String, dynamic>))
                  .toList()),
          filters: $checkedConvert('filters', (v) => v as String?),
          optionalFilters: $checkedConvert('optionalFilters',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$ParamsConsequenceToJson(ParamsConsequence instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('automaticFacetFilters',
      instance.automaticFacetFilters?.map((e) => e.toJson()).toList());
  writeNotNull('filters', instance.filters);
  writeNotNull('optionalFilters', instance.optionalFilters);
  return val;
}
