// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'reasoning_part.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ReasoningPart _$ReasoningPartFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ReasoningPart',
      json,
      ($checkedConvert) {
        final val = ReasoningPart(
          type: $checkedConvert('type', (v) => v as String),
          text: $checkedConvert('text', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$ReasoningPartToJson(ReasoningPart instance) =>
    <String, dynamic>{
      'type': instance.type,
      'text': instance.text,
    };
