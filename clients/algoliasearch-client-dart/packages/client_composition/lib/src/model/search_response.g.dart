// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchResponse _$SearchResponseFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchResponse',
      json,
      ($checkedConvert) {
        final val = SearchResponse(
          compositions: $checkedConvert(
              'compositions',
              (v) => v == null
                  ? null
                  : CompositionsSearchResponse.fromJson(
                      v as Map<String, dynamic>)),
          results: $checkedConvert(
              'results',
              (v) => (v as List<dynamic>)
                  .map((e) =>
                      SearchResultsItem.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchResponseToJson(SearchResponse instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('compositions', instance.compositions?.toJson());
  val['results'] = instance.results.map((e) => e.toJson()).toList();
  return val;
}
