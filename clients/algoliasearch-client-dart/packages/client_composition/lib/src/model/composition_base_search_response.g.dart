// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'composition_base_search_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CompositionBaseSearchResponse _$CompositionBaseSearchResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'CompositionBaseSearchResponse',
      json,
      ($checkedConvert) {
        final val = CompositionBaseSearchResponse(
          compositions: $checkedConvert(
              'compositions',
              (v) => v == null
                  ? null
                  : CompositionsSearchResponse.fromJson(
                      v as Map<String, dynamic>)),
        );
        return val;
      },
    );

const _$CompositionBaseSearchResponseFieldMap = <String, String>{
  'compositions': 'compositions',
};

Map<String, dynamic> _$CompositionBaseSearchResponseToJson(
        CompositionBaseSearchResponse instance) =>
    <String, dynamic>{
      if (instance.compositions?.toJson() case final value?)
        'compositions': value,
    };
