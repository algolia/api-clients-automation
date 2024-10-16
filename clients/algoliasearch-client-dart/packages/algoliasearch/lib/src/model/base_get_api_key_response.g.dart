// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'base_get_api_key_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BaseGetApiKeyResponse _$BaseGetApiKeyResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'BaseGetApiKeyResponse',
      json,
      ($checkedConvert) {
        final val = BaseGetApiKeyResponse(
          value: $checkedConvert('value', (v) => v as String),
          createdAt: $checkedConvert('createdAt', (v) => (v as num).toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$BaseGetApiKeyResponseToJson(
        BaseGetApiKeyResponse instance) =>
    <String, dynamic>{
      'value': instance.value,
      'createdAt': instance.createdAt,
    };
