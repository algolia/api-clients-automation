// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'provider_authentication_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ProviderAuthenticationResponse _$ProviderAuthenticationResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ProviderAuthenticationResponse',
      json,
      ($checkedConvert) {
        final val = ProviderAuthenticationResponse(
          id: $checkedConvert('id', (v) => v as String),
          name: $checkedConvert('name', (v) => v as String),
          providerName: $checkedConvert('providerName', (v) => v as String),
          input: $checkedConvert('input', (v) => v),
          createdAt: $checkedConvert('createdAt', (v) => v as String),
          updatedAt: $checkedConvert('updatedAt', (v) => v as String),
          lastUsedAt: $checkedConvert('lastUsedAt', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$ProviderAuthenticationResponseToJson(
    ProviderAuthenticationResponse instance) {
  final val = <String, dynamic>{
    'id': instance.id,
    'name': instance.name,
    'providerName': instance.providerName,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('input', instance.input);
  val['createdAt'] = instance.createdAt;
  val['updatedAt'] = instance.updatedAt;
  writeNotNull('lastUsedAt', instance.lastUsedAt);
  return val;
}
