// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'tool_call_result_part_agui.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ToolCallResultPartAGUI _$ToolCallResultPartAGUIFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ToolCallResultPartAGUI',
      json,
      ($checkedConvert) {
        final val = ToolCallResultPartAGUI(
          toolCallId: $checkedConvert('toolCallId', (v) => v as String),
          state: $checkedConvert('state', (v) => v as String),
          type: $checkedConvert('type', (v) => v as String),
          content: $checkedConvert('content', (v) => v as String),
          error: $checkedConvert('error', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$ToolCallResultPartAGUIToJson(
    ToolCallResultPartAGUI instance) {
  final val = <String, dynamic>{
    'toolCallId': instance.toolCallId,
    'state': instance.state,
    'type': instance.type,
    'content': instance.content,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('error', instance.error);
  return val;
}
