// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'allowed_domain_bulk_insert.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AllowedDomainBulkInsert _$AllowedDomainBulkInsertFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AllowedDomainBulkInsert',
      json,
      ($checkedConvert) {
        final val = AllowedDomainBulkInsert(
          domains: $checkedConvert('domains',
              (v) => (v as List<dynamic>).map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$AllowedDomainBulkInsertToJson(
        AllowedDomainBulkInsert instance) =>
    <String, dynamic>{
      'domains': instance.domains,
    };
