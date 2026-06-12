// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'secret_key_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SecretKeyResponse _$SecretKeyResponseFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SecretKeyResponse',
      json,
      ($checkedConvert) {
        final val = SecretKeyResponse(
          id: $checkedConvert('id', (v) => v as String),
          name: $checkedConvert('name', (v) => v as String),
          value: $checkedConvert('value', (v) => v as String),
          createdAt: $checkedConvert('createdAt', (v) => v as String),
          updatedAt: $checkedConvert('updatedAt', (v) => v as String),
          lastUsedAt: $checkedConvert('lastUsedAt', (v) => v as String?),
          isDefault: $checkedConvert('isDefault', (v) => v as bool?),
          agentIds: $checkedConvert('agentIds',
              (v) => (v as List<dynamic>).map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$SecretKeyResponseToJson(SecretKeyResponse instance) {
  final val = <String, dynamic>{
    'id': instance.id,
    'name': instance.name,
    'value': instance.value,
    'createdAt': instance.createdAt,
    'updatedAt': instance.updatedAt,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('lastUsedAt', instance.lastUsedAt);
  writeNotNull('isDefault', instance.isDefault);
  val['agentIds'] = instance.agentIds;
  return val;
}
