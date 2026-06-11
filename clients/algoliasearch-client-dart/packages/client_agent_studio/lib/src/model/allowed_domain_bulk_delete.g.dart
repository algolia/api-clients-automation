// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'allowed_domain_bulk_delete.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AllowedDomainBulkDelete _$AllowedDomainBulkDeleteFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AllowedDomainBulkDelete',
      json,
      ($checkedConvert) {
        final val = AllowedDomainBulkDelete(
          domainIds: $checkedConvert('domainIds',
              (v) => (v as List<dynamic>).map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$AllowedDomainBulkDeleteToJson(
        AllowedDomainBulkDelete instance) =>
    <String, dynamic>{
      'domainIds': instance.domainIds,
    };
