// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'xai_provider_input.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

XAIProviderInput _$XAIProviderInputFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'XAIProviderInput',
      json,
      ($checkedConvert) {
        final val = XAIProviderInput(
          apiKey: $checkedConvert('apiKey', (v) => v as String),
          baseUrl: $checkedConvert('baseUrl', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$XAIProviderInputToJson(XAIProviderInput instance) {
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
