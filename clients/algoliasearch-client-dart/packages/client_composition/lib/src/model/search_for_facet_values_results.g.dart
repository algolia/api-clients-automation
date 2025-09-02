// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_for_facet_values_results.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchForFacetValuesResults _$SearchForFacetValuesResultsFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchForFacetValuesResults',
      json,
      ($checkedConvert) {
        final val = SearchForFacetValuesResults(
          indexName: $checkedConvert('indexName', (v) => v as String),
          facetHits: $checkedConvert(
              'facetHits',
              (v) => (v as List<dynamic>)
                  .map((e) => FacetHits.fromJson(e as Map<String, dynamic>))
                  .toList()),
          exhaustiveFacetsCount:
              $checkedConvert('exhaustiveFacetsCount', (v) => v as bool),
          processingTimeMS:
              $checkedConvert('processingTimeMS', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchForFacetValuesResultsToJson(
    SearchForFacetValuesResults instance) {
  final val = <String, dynamic>{
    'indexName': instance.indexName,
    'facetHits': instance.facetHits.map((e) => e.toJson()).toList(),
    'exhaustiveFacetsCount': instance.exhaustiveFacetsCount,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('processingTimeMS', instance.processingTimeMS);
  return val;
}
