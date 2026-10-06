// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'user_message_agui.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

UserMessageAGUI _$UserMessageAGUIFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'UserMessageAGUI',
      json,
      ($checkedConvert) {
        final val = UserMessageAGUI(
          id: $checkedConvert('id', (v) => v as String),
          role: $checkedConvert('role', (v) => v as String),
          parts: $checkedConvert(
              'parts',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => TextPartAGUI.fromJson(e as Map<String, dynamic>))
                  .toList()),
          createdAt: $checkedConvert('createdAt', (v) => v as String?),
          content: $checkedConvert('content', (v) => v as String),
          metadata: $checkedConvert(
              'metadata',
              (v) => v == null
                  ? null
                  : UserMessageMetadataAGUI.fromJson(
                      v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$UserMessageAGUIToJson(UserMessageAGUI instance) {
  final val = <String, dynamic>{
    'id': instance.id,
    'role': instance.role,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('parts', instance.parts?.map((e) => e.toJson()).toList());
  writeNotNull('createdAt', instance.createdAt);
  val['content'] = instance.content;
  writeNotNull('metadata', instance.metadata?.toJson());
  return val;
}
