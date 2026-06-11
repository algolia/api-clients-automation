// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'text_part.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TextPart _$TextPartFromJson(Map<String, dynamic> json) => $checkedCreate(
      'TextPart',
      json,
      ($checkedConvert) {
        final val = TextPart(
          type: $checkedConvert('type', (v) => v as String),
          text: $checkedConvert('text', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$TextPartToJson(TextPart instance) => <String, dynamic>{
      'type': instance.type,
      'text': instance.text,
    };
