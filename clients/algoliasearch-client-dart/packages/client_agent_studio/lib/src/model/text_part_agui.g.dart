// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'text_part_agui.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TextPartAGUI _$TextPartAGUIFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'TextPartAGUI',
      json,
      ($checkedConvert) {
        final val = TextPartAGUI(
          type: $checkedConvert('type', (v) => v as String),
          content: $checkedConvert('content', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$TextPartAGUIToJson(TextPartAGUI instance) =>
    <String, dynamic>{
      'type': instance.type,
      'content': instance.content,
    };
