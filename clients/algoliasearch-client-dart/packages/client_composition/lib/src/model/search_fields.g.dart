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
              (v) => (v as List<dynamic>)
                  .map((e) => Hit.fromJson(e as Map<String, dynamic>))
                  .toList()),
          hitsPerPage:
              $checkedConvert('hitsPerPage', (v) => (v as num).toInt()),
          nbHits: $checkedConvert('nbHits', (v) => (v as num).toInt()),
          nbPages: $checkedConvert('nbPages', (v) => (v as num).toInt()),
          page: $checkedConvert('page', (v) => (v as num).toInt()),
          params: $checkedConvert('params', (v) => v as String),
          query: $checkedConvert('query', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchFieldsToJson(SearchFields instance) =>
    <String, dynamic>{
      'hits': instance.hits.map((e) => e.toJson()).toList(),
      'hitsPerPage': instance.hitsPerPage,
      'nbHits': instance.nbHits,
      'nbPages': instance.nbPages,
      'page': instance.page,
      'params': instance.params,
      'query': instance.query,
    };
