// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'tool_message_agui.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ToolMessageAGUI _$ToolMessageAGUIFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ToolMessageAGUI',
      json,
      ($checkedConvert) {
        final val = ToolMessageAGUI(
          id: $checkedConvert('id', (v) => v as String),
          role: $checkedConvert('role', (v) => v as String),
          content: $checkedConvert('content', (v) => v as String),
          toolCallId: $checkedConvert('toolCallId', (v) => v as String),
          error: $checkedConvert('error', (v) => v as String?),
          encryptedValue:
              $checkedConvert('encryptedValue', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$ToolMessageAGUIToJson(ToolMessageAGUI instance) {
  final val = <String, dynamic>{
    'id': instance.id,
    'role': instance.role,
    'content': instance.content,
    'toolCallId': instance.toolCallId,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('error', instance.error);
  writeNotNull('encryptedValue', instance.encryptedValue);
  return val;
}
