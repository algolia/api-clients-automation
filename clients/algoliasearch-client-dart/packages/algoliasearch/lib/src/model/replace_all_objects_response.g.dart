// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'replace_all_objects_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ReplaceAllObjectsResponse _$ReplaceAllObjectsResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ReplaceAllObjectsResponse',
      json,
      ($checkedConvert) {
        final val = ReplaceAllObjectsResponse(
          copyOperationResponse: $checkedConvert('copyOperationResponse',
              (v) => UpdatedAtResponse.fromJson(v as Map<String, dynamic>)),
          batchResponses: $checkedConvert(
              'batchResponses',
              (v) => (v as List<dynamic>)
                  .map((e) => BatchResponse.fromJson(e as Map<String, dynamic>))
                  .toList()),
          moveOperationResponse: $checkedConvert('moveOperationResponse',
              (v) => UpdatedAtResponse.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$ReplaceAllObjectsResponseToJson(
        ReplaceAllObjectsResponse instance) =>
    <String, dynamic>{
      'copyOperationResponse': instance.copyOperationResponse.toJson(),
      'batchResponses': instance.batchResponses.map((e) => e.toJson()).toList(),
      'moveOperationResponse': instance.moveOperationResponse.toJson(),
    };
