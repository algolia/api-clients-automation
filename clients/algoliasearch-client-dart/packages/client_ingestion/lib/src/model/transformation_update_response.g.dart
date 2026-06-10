// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'transformation_update_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TransformationUpdateResponse _$TransformationUpdateResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'TransformationUpdateResponse',
      json,
      ($checkedConvert) {
        final val = TransformationUpdateResponse(
          transformationID:
              $checkedConvert('transformationID', (v) => v as String),
          updatedAt: $checkedConvert('updatedAt', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$TransformationUpdateResponseToJson(
        TransformationUpdateResponse instance) =>
    <String, dynamic>{
      'transformationID': instance.transformationID,
      'updatedAt': instance.updatedAt,
    };
