// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'allowed_domain_list_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AllowedDomainListResponse _$AllowedDomainListResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AllowedDomainListResponse',
      json,
      ($checkedConvert) {
        final val = AllowedDomainListResponse(
          domains: $checkedConvert(
              'domains',
              (v) => (v as List<dynamic>)
                  .map((e) =>
                      AllowedDomainResponse.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$AllowedDomainListResponseToJson(
        AllowedDomainListResponse instance) =>
    <String, dynamic>{
      'domains': instance.domains.map((e) => e.toJson()).toList(),
    };
