// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'reasoning_message_agui.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ReasoningMessageAGUI _$ReasoningMessageAGUIFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ReasoningMessageAGUI',
      json,
      ($checkedConvert) {
        final val = ReasoningMessageAGUI(
          id: $checkedConvert('id', (v) => v as String),
          role: $checkedConvert('role', (v) => v as String),
          content: $checkedConvert('content', (v) => v as String),
          encryptedValue:
              $checkedConvert('encryptedValue', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$ReasoningMessageAGUIToJson(
    ReasoningMessageAGUI instance) {
  final val = <String, dynamic>{
    'id': instance.id,
    'role': instance.role,
    'content': instance.content,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('encryptedValue', instance.encryptedValue);
  return val;
}
