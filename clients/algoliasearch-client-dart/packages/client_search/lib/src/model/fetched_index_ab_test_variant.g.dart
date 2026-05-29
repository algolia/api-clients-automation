// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'fetched_index_ab_test_variant.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

FetchedIndexAbTestVariant _$FetchedIndexAbTestVariantFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'FetchedIndexAbTestVariant',
      json,
      ($checkedConvert) {
        final val = FetchedIndexAbTestVariant(
          indexName: $checkedConvert('indexName', (v) => v as String?),
          percentage: $checkedConvert('percentage', (v) => (v as num).toInt()),
          customSearchParameters:
              $checkedConvert('customSearchParameters', (v) => v as String?),
          payload: $checkedConvert(
              'payload',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$FetchedIndexAbTestVariantToJson(
    FetchedIndexAbTestVariant instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('indexName', instance.indexName);
  val['percentage'] = instance.percentage;
  writeNotNull('customSearchParameters', instance.customSearchParameters);
  writeNotNull('payload', instance.payload);
  return val;
}
