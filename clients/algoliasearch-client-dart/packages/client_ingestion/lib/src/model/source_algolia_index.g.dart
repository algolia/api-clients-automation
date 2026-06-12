// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'source_algolia_index.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SourceAlgoliaIndex _$SourceAlgoliaIndexFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SourceAlgoliaIndex',
      json,
      ($checkedConvert) {
        final val = SourceAlgoliaIndex(
          indexName: $checkedConvert('indexName', (v) => v as String),
          filters: $checkedConvert('filters', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$SourceAlgoliaIndexToJson(SourceAlgoliaIndex instance) {
  final val = <String, dynamic>{
    'indexName': instance.indexName,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('filters', instance.filters);
  return val;
}
