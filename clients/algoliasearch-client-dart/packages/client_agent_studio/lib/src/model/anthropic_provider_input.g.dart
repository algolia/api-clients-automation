// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'anthropic_provider_input.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AnthropicProviderInput _$AnthropicProviderInputFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AnthropicProviderInput',
      json,
      ($checkedConvert) {
        final val = AnthropicProviderInput(
          apiKey: $checkedConvert('apiKey', (v) => v as String),
          baseUrl: $checkedConvert('baseUrl', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$AnthropicProviderInputToJson(
    AnthropicProviderInput instance) {
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
