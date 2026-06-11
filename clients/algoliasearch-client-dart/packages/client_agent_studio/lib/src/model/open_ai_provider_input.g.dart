// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'open_ai_provider_input.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

OpenAIProviderInput _$OpenAIProviderInputFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'OpenAIProviderInput',
      json,
      ($checkedConvert) {
        final val = OpenAIProviderInput(
          apiKey: $checkedConvert('apiKey', (v) => v as String),
          baseUrl: $checkedConvert('baseUrl', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$OpenAIProviderInputToJson(OpenAIProviderInput instance) {
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
