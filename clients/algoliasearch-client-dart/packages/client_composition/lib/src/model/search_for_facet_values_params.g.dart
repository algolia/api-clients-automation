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
        SearchForFacetValuesParams instance) =>
    <String, dynamic>{
      if (instance.query case final value?) 'query': value,
      if (instance.maxFacetHits case final value?) 'maxFacetHits': value,
      if (instance.searchQuery?.toJson() case final value?)
        'searchQuery': value,
    };
