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
    SecuredApiKeyRestrictions instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('searchParams', instance.searchParams?.toJson());
  writeNotNull('filters', instance.filters);
  writeNotNull('validUntil', instance.validUntil);
  writeNotNull('restrictIndices', instance.restrictIndices);
  writeNotNull('restrictSources', instance.restrictSources);
  writeNotNull('userToken', instance.userToken);
  return val;
}
