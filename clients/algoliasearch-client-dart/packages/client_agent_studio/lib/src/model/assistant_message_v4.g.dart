// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'assistant_message_v4.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AssistantMessageV4 _$AssistantMessageV4FromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'AssistantMessageV4',
      json,
      ($checkedConvert) {
        final val = AssistantMessageV4(
          id: $checkedConvert('id', (v) => v as String?),
          role: $checkedConvert('role', (v) => v as String),
          content: $checkedConvert('content', (v) => v as String),
          parts: $checkedConvert('parts', (v) => v as List<dynamic>?),
          toolInvocations: $checkedConvert(
              'toolInvocations',
              (v) => (v as List<dynamic>?)
                  ?.map((e) =>
                      ToolInvocationV4.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$AssistantMessageV4ToJson(AssistantMessageV4 instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('id', instance.id);
  val['role'] = instance.role;
  val['content'] = instance.content;
  writeNotNull('parts', instance.parts?.toList());
  writeNotNull('toolInvocations',
      instance.toolInvocations?.map((e) => e.toJson()).toList());
  return val;
}
