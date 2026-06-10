// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'transformation_create_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TransformationCreateResponse _$TransformationCreateResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'TransformationCreateResponse',
      json,
      ($checkedConvert) {
        final val = TransformationCreateResponse(
          transformationID:
              $checkedConvert('transformationID', (v) => v as String),
          createdAt: $checkedConvert('createdAt', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$TransformationCreateResponseToJson(
        TransformationCreateResponse instance) =>
    <String, dynamic>{
      'transformationID': instance.transformationID,
      'createdAt': instance.createdAt,
    };
