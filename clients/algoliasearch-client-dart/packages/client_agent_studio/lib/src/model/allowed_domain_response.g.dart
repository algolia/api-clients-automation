// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'allowed_domain_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AllowedDomainResponse _$AllowedDomainResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AllowedDomainResponse',
      json,
      ($checkedConvert) {
        final val = AllowedDomainResponse(
          id: $checkedConvert('id', (v) => v as String),
          appId: $checkedConvert('appId', (v) => v as String),
          agentId: $checkedConvert('agentId', (v) => v as String),
          domain: $checkedConvert('domain', (v) => v as String),
          createdAt: $checkedConvert('createdAt', (v) => v as String),
          updatedAt: $checkedConvert('updatedAt', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$AllowedDomainResponseToJson(
        AllowedDomainResponse instance) =>
    <String, dynamic>{
      'id': instance.id,
      'appId': instance.appId,
      'agentId': instance.agentId,
      'domain': instance.domain,
      'createdAt': instance.createdAt,
      'updatedAt': instance.updatedAt,
    };
