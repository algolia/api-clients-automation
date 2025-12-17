// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'get_api_key_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

GetApiKeyResponse _$GetApiKeyResponseFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'GetApiKeyResponse',
      json,
      ($checkedConvert) {
        final val = GetApiKeyResponse(
          value: $checkedConvert('value', (v) => v as String),
          createdAt: $checkedConvert('createdAt', (v) => (v as num).toInt()),
          acl: $checkedConvert(
              'acl',
              (v) => (v as List<dynamic>)
                  .map((e) => $enumDecode(_$AclEnumMap, e))
                  .toList()),
          description: $checkedConvert('description', (v) => v as String?),
          indexes: $checkedConvert('indexes',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          maxHitsPerQuery:
              $checkedConvert('maxHitsPerQuery', (v) => (v as num?)?.toInt()),
          maxQueriesPerIPPerHour: $checkedConvert(
              'maxQueriesPerIPPerHour', (v) => (v as num?)?.toInt()),
          queryParameters:
              $checkedConvert('queryParameters', (v) => v as String?),
          referers: $checkedConvert('referers',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          validity: $checkedConvert('validity', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$GetApiKeyResponseToJson(GetApiKeyResponse instance) {
  final val = <String, dynamic>{
    'value': instance.value,
    'createdAt': instance.createdAt,
    'acl': instance.acl.map((e) => e.toJson()).toList(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('description', instance.description);
  writeNotNull('indexes', instance.indexes);
  writeNotNull('maxHitsPerQuery', instance.maxHitsPerQuery);
  writeNotNull('maxQueriesPerIPPerHour', instance.maxQueriesPerIPPerHour);
  writeNotNull('queryParameters', instance.queryParameters);
  writeNotNull('referers', instance.referers);
  writeNotNull('validity', instance.validity);
  return val;
}

const _$AclEnumMap = {
  Acl.addObject: 'addObject',
  Acl.analytics: 'analytics',
  Acl.browse: 'browse',
  Acl.deleteObject: 'deleteObject',
  Acl.deleteIndex: 'deleteIndex',
  Acl.editSettings: 'editSettings',
  Acl.inference: 'inference',
  Acl.listIndexes: 'listIndexes',
  Acl.logs: 'logs',
  Acl.personalization: 'personalization',
  Acl.recommendation: 'recommendation',
  Acl.search: 'search',
  Acl.seeUnretrievableAttributes: 'seeUnretrievableAttributes',
  Acl.settings: 'settings',
  Acl.usage: 'usage',
  Acl.nluWriteProject: 'nluWriteProject',
  Acl.nluReadProject: 'nluReadProject',
  Acl.nluWriteEntity: 'nluWriteEntity',
  Acl.nluReadEntity: 'nluReadEntity',
  Acl.nluWriteIntent: 'nluWriteIntent',
  Acl.nluReadIntent: 'nluReadIntent',
  Acl.nluPrediction: 'nluPrediction',
  Acl.nluReadAnswers: 'nluReadAnswers',
};
