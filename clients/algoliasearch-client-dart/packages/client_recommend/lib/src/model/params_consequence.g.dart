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

Map<String, dynamic> _$ParamsConsequenceToJson(ParamsConsequence instance) =>
    <String, dynamic>{
      if (instance.automaticFacetFilters?.map((e) => e.toJson()).toList()
          case final value?)
        'automaticFacetFilters': value,
      if (instance.filters case final value?) 'filters': value,
      if (instance.optionalFilters case final value?) 'optionalFilters': value,
    };
