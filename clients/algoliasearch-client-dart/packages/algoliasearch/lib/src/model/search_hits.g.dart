// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_hits.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchHits _$SearchHitsFromJson(Map<String, dynamic> json) => $checkedCreate(
      'SearchHits',
      json,
      ($checkedConvert) {
        final val = SearchHits(
          hits: $checkedConvert(
              'hits',
              (v) => (v as List<dynamic>)
                  .map((e) => Hit.fromJson(e as Map<String, dynamic>))
                  .toList()),
          query: $checkedConvert('query', (v) => v as String?),
          params: $checkedConvert('params', (v) => v as String?),
        );
        return val;
      },
    );

const _$SearchHitsFieldMap = <String, String>{
  'hits': 'hits',
  'query': 'query',
  'params': 'params',
};

Map<String, dynamic> _$SearchHitsToJson(SearchHits instance) {
  final val = <String, dynamic>{
    'hits': instance.hits.map((e) => e.toJson()).toList(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('query', instance.query);
  writeNotNull('params', instance.params);
  return val;
}
