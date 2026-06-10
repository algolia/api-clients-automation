// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'source.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Source _$SourceFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Source',
      json,
      ($checkedConvert) {
        final val = Source(
          sourceID: $checkedConvert('sourceID', (v) => v as String),
          type: $checkedConvert(
              'type', (v) => $enumDecode(_$SourceTypeEnumMap, v)),
          name: $checkedConvert('name', (v) => v as String),
          owner: $checkedConvert('owner', (v) => v as String?),
          input: $checkedConvert('input', (v) => v),
          authenticationID:
              $checkedConvert('authenticationID', (v) => v as String?),
          createdAt: $checkedConvert('createdAt', (v) => v as String),
          updatedAt: $checkedConvert('updatedAt', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$SourceToJson(Source instance) {
  final val = <String, dynamic>{
    'sourceID': instance.sourceID,
    'type': instance.type.toJson(),
    'name': instance.name,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('owner', instance.owner);
  writeNotNull('input', instance.input);
  writeNotNull('authenticationID', instance.authenticationID);
  val['createdAt'] = instance.createdAt;
  val['updatedAt'] = instance.updatedAt;
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
