// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_results.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchResults _$SearchResultsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchResults',
      json,
      ($checkedConvert) {
        final val = SearchResults(
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

Map<String, dynamic> _$SearchResultsToJson(SearchResults instance) =>
    <String, dynamic>{
      'results': instance.results.map((e) => e.toJson()).toList(),
    };
