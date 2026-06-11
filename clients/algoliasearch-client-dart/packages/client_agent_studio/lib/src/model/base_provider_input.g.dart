// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'base_provider_input.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BaseProviderInput _$BaseProviderInputFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'BaseProviderInput',
      json,
      ($checkedConvert) {
        final val = BaseProviderInput(
          apiKey: $checkedConvert('apiKey', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$BaseProviderInputToJson(BaseProviderInput instance) =>
    <String, dynamic>{
      'apiKey': instance.apiKey,
    };
