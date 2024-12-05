// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'delete_by_params.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

DeleteByParams _$DeleteByParamsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'DeleteByParams',
      json,
      ($checkedConvert) {
        final val = DeleteByParams(
          facetFilters: $checkedConvert('facetFilters', (v) => v),
          filters: $checkedConvert('filters', (v) => v as String?),
          numericFilters: $checkedConvert('numericFilters', (v) => v),
          tagFilters: $checkedConvert('tagFilters', (v) => v),
          aroundLatLng: $checkedConvert('aroundLatLng', (v) => v as String?),
          aroundRadius: $checkedConvert('aroundRadius', (v) => v),
          insideBoundingBox: $checkedConvert('insideBoundingBox', (v) => v),
          insidePolygon: $checkedConvert(
              'insidePolygon',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => (e as List<dynamic>)
                      .map((e) => (e as num).toDouble())
                      .toList())
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$DeleteByParamsToJson(DeleteByParams instance) =>
    <String, dynamic>{
      if (instance.facetFilters case final value?) 'facetFilters': value,
      if (instance.filters case final value?) 'filters': value,
      if (instance.numericFilters case final value?) 'numericFilters': value,
      if (instance.tagFilters case final value?) 'tagFilters': value,
      if (instance.aroundLatLng case final value?) 'aroundLatLng': value,
      if (instance.aroundRadius case final value?) 'aroundRadius': value,
      if (instance.insideBoundingBox case final value?)
        'insideBoundingBox': value,
      if (instance.insidePolygon case final value?) 'insidePolygon': value,
    };
