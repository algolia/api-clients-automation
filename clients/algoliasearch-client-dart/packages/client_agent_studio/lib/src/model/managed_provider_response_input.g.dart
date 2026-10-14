// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'managed_provider_response_input.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ManagedProviderResponseInput _$ManagedProviderResponseInputFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ManagedProviderResponseInput',
      json,
      ($checkedConvert) {
        final val = ManagedProviderResponseInput(
          defaultModel: $checkedConvert('defaultModel', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$ManagedProviderResponseInputToJson(
        ManagedProviderResponseInput instance) =>
    <String, dynamic>{
      'defaultModel': instance.defaultModel,
    };
