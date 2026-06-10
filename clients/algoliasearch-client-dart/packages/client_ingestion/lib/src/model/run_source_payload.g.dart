// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'run_source_payload.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RunSourcePayload _$RunSourcePayloadFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'RunSourcePayload',
      json,
      ($checkedConvert) {
        final val = RunSourcePayload(
          indexToInclude: $checkedConvert('indexToInclude',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          indexToExclude: $checkedConvert('indexToExclude',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          entityIDs: $checkedConvert('entityIDs',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          entityType: $checkedConvert(
              'entityType', (v) => $enumDecodeNullable(_$EntityTypeEnumMap, v)),
          runMetadata: $checkedConvert(
              'runMetadata',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$RunSourcePayloadToJson(RunSourcePayload instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('indexToInclude', instance.indexToInclude);
  writeNotNull('indexToExclude', instance.indexToExclude);
  writeNotNull('entityIDs', instance.entityIDs);
  writeNotNull('entityType', instance.entityType?.toJson());
  writeNotNull('runMetadata', instance.runMetadata);
  return val;
}

const _$EntityTypeEnumMap = {
  EntityType.product: 'product',
  EntityType.collection: 'collection',
};
