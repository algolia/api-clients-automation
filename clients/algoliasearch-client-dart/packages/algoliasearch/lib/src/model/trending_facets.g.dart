// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'trending_facets.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TrendingFacets _$TrendingFacetsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'TrendingFacets',
      json,
      ($checkedConvert) {
        final val = TrendingFacets(
          facetName: $checkedConvert('facetName', (v) => v as String),
          model: $checkedConvert(
              'model', (v) => $enumDecode(_$TrendingFacetsModelEnumMap, v)),
          fallbackParameters: $checkedConvert(
              'fallbackParameters',
              (v) => v == null
                  ? null
                  : FallbackParams.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$TrendingFacetsToJson(TrendingFacets instance) =>
    <String, dynamic>{
      'facetName': instance.facetName,
      'model': instance.model.toJson(),
      if (instance.fallbackParameters?.toJson() case final value?)
        'fallbackParameters': value,
    };

const _$TrendingFacetsModelEnumMap = {
  TrendingFacetsModel.trendingFacets: 'trending-facets',
};
