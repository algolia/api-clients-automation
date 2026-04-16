// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'injection_main_search_source.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

InjectionMainSearchSource _$InjectionMainSearchSourceFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'InjectionMainSearchSource',
      json,
      ($checkedConvert) {
        final val = InjectionMainSearchSource(
          search: $checkedConvert(
              'search', (v) => MainSearch.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$InjectionMainSearchSourceToJson(
        InjectionMainSearchSource instance) =>
    <String, dynamic>{
      'search': instance.search.toJson(),
    };
