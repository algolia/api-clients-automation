// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_dictionary_entries_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchDictionaryEntriesResponse _$SearchDictionaryEntriesResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchDictionaryEntriesResponse',
      json,
      ($checkedConvert) {
        final val = SearchDictionaryEntriesResponse(
          hits: $checkedConvert(
              'hits',
              (v) => (v as List<dynamic>)
                  .map((e) =>
                      DictionaryEntry.fromJson(e as Map<String, dynamic>))
                  .toList()),
          page: $checkedConvert('page', (v) => v as int),
          nbHits: $checkedConvert('nbHits', (v) => v as int),
          nbPages: $checkedConvert('nbPages', (v) => v as int),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchDictionaryEntriesResponseToJson(
        SearchDictionaryEntriesResponse instance) =>
    <String, dynamic>{
      'hits': instance.hits.map((e) => e.toJson()).toList(),
      'page': instance.page,
      'nbHits': instance.nbHits,
      'nbPages': instance.nbPages,
    };
