// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_fields.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchFields _$SearchFieldsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchFields',
      json,
      ($checkedConvert) {
        final val = SearchFields(
          hits: $checkedConvert(
              'hits',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => Hit.fromJson(e as Map<String, dynamic>))
                  .toList()),
          hitsPerPage:
              $checkedConvert('hitsPerPage', (v) => (v as num?)?.toInt()),
          nbHits: $checkedConvert('nbHits', (v) => (v as num?)?.toInt()),
          nbPages: $checkedConvert('nbPages', (v) => (v as num?)?.toInt()),
          page: $checkedConvert('page', (v) => (v as num?)?.toInt()),
          params: $checkedConvert('params', (v) => v as String?),
          query: $checkedConvert('query', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchFieldsToJson(SearchFields instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('hits', instance.hits?.map((e) => e.toJson()).toList());
  writeNotNull('hitsPerPage', instance.hitsPerPage);
  writeNotNull('nbHits', instance.nbHits);
  writeNotNull('nbPages', instance.nbPages);
  writeNotNull('page', instance.page);
  writeNotNull('params', instance.params);
  writeNotNull('query', instance.query);
  return val;
}
