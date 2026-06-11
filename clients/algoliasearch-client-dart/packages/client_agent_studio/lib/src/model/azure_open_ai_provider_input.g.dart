// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'azure_open_ai_provider_input.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AzureOpenAIProviderInput _$AzureOpenAIProviderInputFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AzureOpenAIProviderInput',
      json,
      ($checkedConvert) {
        final val = AzureOpenAIProviderInput(
          apiKey: $checkedConvert('apiKey', (v) => v as String),
          azureEndpoint: $checkedConvert('azureEndpoint', (v) => v as String),
          azureDeployment:
              $checkedConvert('azureDeployment', (v) => v as String),
          apiVersion: $checkedConvert('apiVersion', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$AzureOpenAIProviderInputToJson(
    AzureOpenAIProviderInput instance) {
  final val = <String, dynamic>{
    'apiKey': instance.apiKey,
    'azureEndpoint': instance.azureEndpoint,
    'azureDeployment': instance.azureDeployment,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('apiVersion', instance.apiVersion);
  return val;
}
