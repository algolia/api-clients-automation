// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'mistral_provider_input.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MistralProviderInput _$MistralProviderInputFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'MistralProviderInput',
      json,
      ($checkedConvert) {
        final val = MistralProviderInput(
          apiKey: $checkedConvert('apiKey', (v) => v as String),
          baseUrl: $checkedConvert('baseUrl', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$MistralProviderInputToJson(
    MistralProviderInput instance) {
  final val = <String, dynamic>{
    'apiKey': instance.apiKey,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('baseUrl', instance.baseUrl);
  return val;
}
