// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'get_objects_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

GetObjectsResponse _$GetObjectsResponseFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'GetObjectsResponse',
      json,
      ($checkedConvert) {
        final val = GetObjectsResponse(
          message: $checkedConvert('message', (v) => v as String?),
          results: $checkedConvert('results',
              (v) => (v as List<dynamic>).map((e) => e as Object).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$GetObjectsResponseToJson(GetObjectsResponse instance) =>
    <String, dynamic>{
      if (instance.message case final value?) 'message': value,
      'results': instance.results,
    };
