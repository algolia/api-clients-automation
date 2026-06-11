// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'start_step_part.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

StartStepPart _$StartStepPartFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'StartStepPart',
      json,
      ($checkedConvert) {
        final val = StartStepPart(
          type: $checkedConvert('type', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$StartStepPartToJson(StartStepPart instance) =>
    <String, dynamic>{
      'type': instance.type,
    };
