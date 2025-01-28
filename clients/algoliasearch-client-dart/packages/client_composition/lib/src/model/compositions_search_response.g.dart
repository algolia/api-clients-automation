// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'compositions_search_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CompositionsSearchResponse _$CompositionsSearchResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'CompositionsSearchResponse',
      json,
      ($checkedConvert) {
        final val = CompositionsSearchResponse(
          run: $checkedConvert(
              'run',
              (v) => (v as List<dynamic>)
                  .map((e) => CompositionRunSearchResponse.fromJson(
                      e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

const _$CompositionsSearchResponseFieldMap = <String, String>{
  'run': 'run',
};

Map<String, dynamic> _$CompositionsSearchResponseToJson(
        CompositionsSearchResponse instance) =>
    <String, dynamic>{
      'run': instance.run.map((e) => e.toJson()).toList(),
    };
