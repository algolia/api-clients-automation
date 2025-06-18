// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'replace_all_objects_with_transformation_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ReplaceAllObjectsWithTransformationResponse
    _$ReplaceAllObjectsWithTransformationResponseFromJson(
            Map<String, dynamic> json) =>
        $checkedCreate(
          'ReplaceAllObjectsWithTransformationResponse',
          json,
          ($checkedConvert) {
            final val = ReplaceAllObjectsWithTransformationResponse(
              copyOperationResponse: $checkedConvert('copyOperationResponse',
                  (v) => UpdatedAtResponse.fromJson(v as Map<String, dynamic>)),
              watchResponses: $checkedConvert(
                  'watchResponses',
                  (v) => (v as List<dynamic>)
                      .map((e) =>
                          WatchResponse.fromJson(e as Map<String, dynamic>))
                      .toList()),
              moveOperationResponse: $checkedConvert('moveOperationResponse',
                  (v) => UpdatedAtResponse.fromJson(v as Map<String, dynamic>)),
            );
            return val;
          },
        );

Map<String, dynamic> _$ReplaceAllObjectsWithTransformationResponseToJson(
        ReplaceAllObjectsWithTransformationResponse instance) =>
    <String, dynamic>{
      'copyOperationResponse': instance.copyOperationResponse.toJson(),
      'watchResponses': instance.watchResponses.map((e) => e.toJson()).toList(),
      'moveOperationResponse': instance.moveOperationResponse.toJson(),
    };
