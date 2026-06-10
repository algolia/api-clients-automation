// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'transformation_no_code.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TransformationNoCode _$TransformationNoCodeFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'TransformationNoCode',
      json,
      ($checkedConvert) {
        final val = TransformationNoCode(
          steps: $checkedConvert('steps',
              (v) => (v as List<dynamic>).map((e) => e as Object).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$TransformationNoCodeToJson(
        TransformationNoCode instance) =>
    <String, dynamic>{
      'steps': instance.steps,
    };
