// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'open_ai_compatible_provider_input.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

OpenAICompatibleProviderInput _$OpenAICompatibleProviderInputFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'OpenAICompatibleProviderInput',
      json,
      ($checkedConvert) {
        final val = OpenAICompatibleProviderInput(
          apiKey: $checkedConvert('apiKey', (v) => v as String),
          baseUrl: $checkedConvert('baseUrl', (v) => v as String),
          defaultModel: $checkedConvert('defaultModel', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$OpenAICompatibleProviderInputToJson(
        OpenAICompatibleProviderInput instance) =>
    <String, dynamic>{
      'apiKey': instance.apiKey,
      'baseUrl': instance.baseUrl,
      'defaultModel': instance.defaultModel,
    };
