// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'destination_update_input.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

DestinationUpdateInput _$DestinationUpdateInputFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'DestinationUpdateInput',
      json,
      ($checkedConvert) {
        final val = DestinationUpdateInput(
          indexName: $checkedConvert('indexName', (v) => v as String?),
          recordType: $checkedConvert(
              'recordType', (v) => $enumDecodeNullable(_$RecordTypeEnumMap, v)),
          attributesToExclude: $checkedConvert('attributesToExclude',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$DestinationUpdateInputToJson(
    DestinationUpdateInput instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('indexName', instance.indexName);
  writeNotNull('recordType', instance.recordType?.toJson());
  writeNotNull('attributesToExclude', instance.attributesToExclude);
  return val;
}

const _$RecordTypeEnumMap = {
  RecordType.product: 'product',
  RecordType.variant: 'variant',
  RecordType.collection: 'collection',
};
