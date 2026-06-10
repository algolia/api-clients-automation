// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'source_create.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SourceCreate _$SourceCreateFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SourceCreate',
      json,
      ($checkedConvert) {
        final val = SourceCreate(
          type: $checkedConvert(
              'type', (v) => $enumDecode(_$SourceTypeEnumMap, v)),
          name: $checkedConvert('name', (v) => v as String),
          input: $checkedConvert('input', (v) => v),
          authenticationID:
              $checkedConvert('authenticationID', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$SourceCreateToJson(SourceCreate instance) {
  final val = <String, dynamic>{
    'type': instance.type.toJson(),
    'name': instance.name,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('input', instance.input);
  writeNotNull('authenticationID', instance.authenticationID);
  return val;
}

const _$SourceTypeEnumMap = {
  SourceType.algoliaIndex: 'algoliaIndex',
  SourceType.bigcommerce: 'bigcommerce',
  SourceType.bigquery: 'bigquery',
  SourceType.commercetools: 'commercetools',
  SourceType.csv: 'csv',
  SourceType.docker: 'docker',
  SourceType.ga4BigqueryExport: 'ga4BigqueryExport',
  SourceType.json: 'json',
  SourceType.shopify: 'shopify',
  SourceType.push: 'push',
};
