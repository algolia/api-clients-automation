// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'composition_source.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CompositionSource _$CompositionSourceFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'CompositionSource',
      json,
      ($checkedConvert) {
        final val = CompositionSource(
          search: $checkedConvert(
              'search',
              (v) =>
                  CompositionSourceSearch.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$CompositionSourceToJson(CompositionSource instance) =>
    <String, dynamic>{
      'search': instance.search.toJson(),
    };
