// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'secured_api_key_restrictions.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SecuredApiKeyRestrictions _$SecuredApiKeyRestrictionsFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SecuredApiKeyRestrictions',
      json,
      ($checkedConvert) {
        final val = SecuredApiKeyRestrictions(
          searchParams: $checkedConvert(
              'searchParams',
              (v) => v == null
                  ? null
                  : SearchParamsObject.fromJson(v as Map<String, dynamic>)),
          filters: $checkedConvert('filters', (v) => v as String?),
          validUntil:
              $checkedConvert('validUntil', (v) => (v as num?)?.toInt()),
          restrictIndices: $checkedConvert('restrictIndices',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          restrictSources:
              $checkedConvert('restrictSources', (v) => v as String?),
          userToken: $checkedConvert('userToken', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$SecuredApiKeyRestrictionsToJson(
        SecuredApiKeyRestrictions instance) =>
    <String, dynamic>{
      if (instance.searchParams?.toJson() case final value?)
        'searchParams': value,
      if (instance.filters case final value?) 'filters': value,
      if (instance.validUntil case final value?) 'validUntil': value,
      if (instance.restrictIndices case final value?) 'restrictIndices': value,
      if (instance.restrictSources case final value?) 'restrictSources': value,
      if (instance.userToken case final value?) 'userToken': value,
    };
