// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'user_message_v4.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

UserMessageV4 _$UserMessageV4FromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'UserMessageV4',
      json,
      ($checkedConvert) {
        final val = UserMessageV4(
          id: $checkedConvert('id', (v) => v as String?),
          role: $checkedConvert('role', (v) => v as String),
          content: $checkedConvert('content', (v) => v as String),
          parts: $checkedConvert(
              'parts',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => TextPartV4.fromJson(e as Map<String, dynamic>))
                  .toList()),
          annotations: $checkedConvert(
              'annotations',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => (e as Map<String, dynamic>).map(
                        (k, e) => MapEntry(k, e as Object),
                      ))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$UserMessageV4ToJson(UserMessageV4 instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('id', instance.id);
  val['role'] = instance.role;
  val['content'] = instance.content;
  writeNotNull('parts', instance.parts?.map((e) => e.toJson()).toList());
  writeNotNull('annotations', instance.annotations);
  return val;
}
