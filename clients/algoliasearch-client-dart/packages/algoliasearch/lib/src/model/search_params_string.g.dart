// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_params_string.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchParamsString _$SearchParamsStringFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchParamsString',
      json,
      ($checkedConvert) {
        final val = SearchParamsString(
          params: $checkedConvert('params', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchParamsStringToJson(SearchParamsString instance) =>
    <String, dynamic>{
      if (instance.params case final value?) 'params': value,
    };
