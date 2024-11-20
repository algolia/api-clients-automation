// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_for_facet_values_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchForFacetValuesRequest _$SearchForFacetValuesRequestFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchForFacetValuesRequest',
      json,
      ($checkedConvert) {
        final val = SearchForFacetValuesRequest(
          params: $checkedConvert('params', (v) => v as String?),
          facetQuery: $checkedConvert('facetQuery', (v) => v as String?),
          maxFacetHits:
              $checkedConvert('maxFacetHits', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchForFacetValuesRequestToJson(
        SearchForFacetValuesRequest instance) =>
    <String, dynamic>{
      if (instance.params case final value?) 'params': value,
      if (instance.facetQuery case final value?) 'facetQuery': value,
      if (instance.maxFacetHits case final value?) 'maxFacetHits': value,
    };
