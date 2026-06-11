// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'allowed_domain_create.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AllowedDomainCreate _$AllowedDomainCreateFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'AllowedDomainCreate',
      json,
      ($checkedConvert) {
        final val = AllowedDomainCreate(
          domain: $checkedConvert('domain', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$AllowedDomainCreateToJson(
        AllowedDomainCreate instance) =>
    <String, dynamic>{
      'domain': instance.domain,
    };
