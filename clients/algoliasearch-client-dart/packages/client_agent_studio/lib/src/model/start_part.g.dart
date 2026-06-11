// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'start_part.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

StartPart _$StartPartFromJson(Map<String, dynamic> json) => $checkedCreate(
      'StartPart',
      json,
      ($checkedConvert) {
        final val = StartPart(
          type: $checkedConvert('type', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$StartPartToJson(StartPart instance) => <String, dynamic>{
      'type': instance.type,
    };
