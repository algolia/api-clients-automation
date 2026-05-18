// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'transformation_code.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TransformationCode _$TransformationCodeFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'TransformationCode',
      json,
      ($checkedConvert) {
        final val = TransformationCode(
          code: $checkedConvert('code', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$TransformationCodeToJson(TransformationCode instance) =>
    <String, dynamic>{
      'code': instance.code,
    };
