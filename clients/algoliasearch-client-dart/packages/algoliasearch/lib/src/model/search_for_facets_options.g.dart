// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_for_facets_options.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchForFacetsOptions _$SearchForFacetsOptionsFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchForFacetsOptions',
      json,
      ($checkedConvert) {
        final val = SearchForFacetsOptions(
          facet: $checkedConvert('facet', (v) => v as String),
          indexName: $checkedConvert('indexName', (v) => v as String),
          facetQuery: $checkedConvert('facetQuery', (v) => v as String?),
          maxFacetHits:
              $checkedConvert('maxFacetHits', (v) => (v as num?)?.toInt()),
          type: $checkedConvert(
              'type', (v) => $enumDecode(_$SearchTypeFacetEnumMap, v)),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchForFacetsOptionsToJson(
        SearchForFacetsOptions instance) =>
    <String, dynamic>{
      'facet': instance.facet,
      'indexName': instance.indexName,
      if (instance.facetQuery case final value?) 'facetQuery': value,
      if (instance.maxFacetHits case final value?) 'maxFacetHits': value,
      'type': instance.type.toJson(),
    };

const _$SearchTypeFacetEnumMap = {
  SearchTypeFacet.facet: 'facet',
};
