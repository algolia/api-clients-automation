// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_params_query.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchParamsQuery _$SearchParamsQueryFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchParamsQuery',
      json,
      ($checkedConvert) {
        final val = SearchParamsQuery(
          query: $checkedConvert('query', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchParamsQueryToJson(SearchParamsQuery instance) =>
    <String, dynamic>{
      if (instance.query case final value?) 'query': value,
    };
