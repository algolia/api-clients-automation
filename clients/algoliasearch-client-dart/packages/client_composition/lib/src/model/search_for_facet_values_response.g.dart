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
    SearchForFacetValuesResponse instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('results', instance.results?.map((e) => e.toJson()).toList());
  return val;
}
