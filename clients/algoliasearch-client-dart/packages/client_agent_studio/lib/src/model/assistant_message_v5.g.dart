// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'assistant_message_v5.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AssistantMessageV5 _$AssistantMessageV5FromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'AssistantMessageV5',
      json,
      ($checkedConvert) {
        final val = AssistantMessageV5(
          id: $checkedConvert('id', (v) => v as String?),
          role: $checkedConvert('role', (v) => v as String),
          parts: $checkedConvert('parts', (v) => v as List<dynamic>?),
        );
        return val;
      },
    );

Map<String, dynamic> _$AssistantMessageV5ToJson(AssistantMessageV5 instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('id', instance.id);
  val['role'] = instance.role;
  writeNotNull('parts', instance.parts?.toList());
  return val;
}
