// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'provider_authentication_create.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ProviderAuthenticationCreate _$ProviderAuthenticationCreateFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ProviderAuthenticationCreate',
      json,
      ($checkedConvert) {
        final val = ProviderAuthenticationCreate(
          name: $checkedConvert('name', (v) => v as String),
          providerName: $checkedConvert(
              'providerName', (v) => $enumDecode(_$ProviderNameEnumMap, v)),
          input: $checkedConvert('input', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$ProviderAuthenticationCreateToJson(
    ProviderAuthenticationCreate instance) {
  final val = <String, dynamic>{
    'name': instance.name,
    'providerName': instance.providerName.toJson(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('input', instance.input);
  return val;
}

const _$ProviderNameEnumMap = {
  ProviderName.openai: 'openai',
  ProviderName.azureOpenai: 'azure_openai',
  ProviderName.googleGenai: 'google_genai',
  ProviderName.deepseek: 'deepseek',
  ProviderName.openaiCompatible: 'openai_compatible',
  ProviderName.anthropic: 'anthropic',
};
