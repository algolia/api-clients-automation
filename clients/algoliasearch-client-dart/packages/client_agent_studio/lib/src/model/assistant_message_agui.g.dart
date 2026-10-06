// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'assistant_message_agui.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AssistantMessageAGUI _$AssistantMessageAGUIFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AssistantMessageAGUI',
      json,
      ($checkedConvert) {
        final val = AssistantMessageAGUI(
          id: $checkedConvert('id', (v) => v as String),
          role: $checkedConvert('role', (v) => v as String),
          content: $checkedConvert('content', (v) => v as String?),
          name: $checkedConvert('name', (v) => v as String?),
          toolCalls: $checkedConvert(
              'toolCalls',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => ToolCallAGUI.fromJson(e as Map<String, dynamic>))
                  .toList()),
          encryptedContent:
              $checkedConvert('encryptedContent', (v) => v as String?),
          parts: $checkedConvert('parts', (v) => v as List<dynamic>?),
          createdAt: $checkedConvert('createdAt', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$AssistantMessageAGUIToJson(
    AssistantMessageAGUI instance) {
  final val = <String, dynamic>{
    'id': instance.id,
    'role': instance.role,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('content', instance.content);
  writeNotNull('name', instance.name);
  writeNotNull(
      'toolCalls', instance.toolCalls?.map((e) => e.toJson()).toList());
  writeNotNull('encryptedContent', instance.encryptedContent);
  writeNotNull('parts', instance.parts?.toList());
  writeNotNull('createdAt', instance.createdAt);
  return val;
}
