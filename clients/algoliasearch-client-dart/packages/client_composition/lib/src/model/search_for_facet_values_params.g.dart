// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_for_facet_values_params.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchForFacetValuesParams _$SearchForFacetValuesParamsFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchForFacetValuesParams',
      json,
      ($checkedConvert) {
        final val = SearchForFacetValuesParams(
          query: $checkedConvert('query', (v) => v as String?),
          maxFacetHits:
              $checkedConvert('maxFacetHits', (v) => (v as num?)?.toInt()),
          searchQuery: $checkedConvert(
              'searchQuery',
              (v) => v == null
                  ? null
                  : Params.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchForFacetValuesParamsToJson(
    SearchForFacetValuesParams instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('query', instance.query);
  writeNotNull('maxFacetHits', instance.maxFacetHits);
  writeNotNull('searchQuery', instance.searchQuery?.toJson());
  return val;
}
