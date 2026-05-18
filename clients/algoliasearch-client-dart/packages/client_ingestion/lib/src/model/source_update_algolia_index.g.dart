// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'source_update_algolia_index.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SourceUpdateAlgoliaIndex _$SourceUpdateAlgoliaIndexFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SourceUpdateAlgoliaIndex',
      json,
      ($checkedConvert) {
        final val = SourceUpdateAlgoliaIndex(
          indexName: $checkedConvert('indexName', (v) => v as String?),
          filters: $checkedConvert('filters', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$SourceUpdateAlgoliaIndexToJson(
    SourceUpdateAlgoliaIndex instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('indexName', instance.indexName);
  writeNotNull('filters', instance.filters);
  return val;
}
