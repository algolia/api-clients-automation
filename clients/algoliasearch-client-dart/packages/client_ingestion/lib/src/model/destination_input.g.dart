// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'destination_input.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

DestinationInput _$DestinationInputFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'DestinationInput',
      json,
      ($checkedConvert) {
        final val = DestinationInput(
          indexName: $checkedConvert('indexName', (v) => v as String),
          recordType: $checkedConvert(
              'recordType', (v) => $enumDecodeNullable(_$RecordTypeEnumMap, v)),
          attributesToExclude: $checkedConvert('attributesToExclude',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$DestinationInputToJson(DestinationInput instance) {
  final val = <String, dynamic>{
    'indexName': instance.indexName,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('recordType', instance.recordType?.toJson());
  writeNotNull('attributesToExclude', instance.attributesToExclude);
  return val;
}

const _$RecordTypeEnumMap = {
  RecordType.product: 'product',
  RecordType.variant: 'variant',
  RecordType.collection: 'collection',
};
