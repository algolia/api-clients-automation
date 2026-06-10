// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'user_message_v5.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

UserMessageV5 _$UserMessageV5FromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'UserMessageV5',
      json,
      ($checkedConvert) {
        final val = UserMessageV5(
          id: $checkedConvert('id', (v) => v as String?),
          role: $checkedConvert('role', (v) => v as String),
          parts: $checkedConvert(
              'parts',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => TextPartV5.fromJson(e as Map<String, dynamic>))
                  .toList()),
          metadata: $checkedConvert(
              'metadata',
              (v) => v == null
                  ? null
                  : UserMessageMetadataV5.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$UserMessageV5ToJson(UserMessageV5 instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('id', instance.id);
  val['role'] = instance.role;
  writeNotNull('parts', instance.parts?.map((e) => e.toJson()).toList());
  writeNotNull('metadata', instance.metadata?.toJson());
  return val;
}
