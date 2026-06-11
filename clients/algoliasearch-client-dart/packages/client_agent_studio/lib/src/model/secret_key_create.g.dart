// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'secret_key_create.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SecretKeyCreate _$SecretKeyCreateFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SecretKeyCreate',
      json,
      ($checkedConvert) {
        final val = SecretKeyCreate(
          name: $checkedConvert('name', (v) => v as String),
          agentIds: $checkedConvert('agentIds',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$SecretKeyCreateToJson(SecretKeyCreate instance) {
  final val = <String, dynamic>{
    'name': instance.name,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('agentIds', instance.agentIds);
  return val;
}
