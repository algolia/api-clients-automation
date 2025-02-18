// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_for_facet_values_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchForFacetValuesResponse _$SearchForFacetValuesResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchForFacetValuesResponse',
      json,
      ($checkedConvert) {
        final val = SearchForFacetValuesResponse(
          results: $checkedConvert(
              'results',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => SearchForFacetValuesResults.fromJson(
                      e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchForFacetValuesResponseToJson(
        SearchForFacetValuesResponse instance) =>
    <String, dynamic>{
      if (instance.results?.map((e) => e.toJson()).toList() case final value?)
        'results': value,
    };
