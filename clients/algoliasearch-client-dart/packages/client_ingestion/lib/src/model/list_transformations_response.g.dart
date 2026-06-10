// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'list_transformations_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ListTransformationsResponse _$ListTransformationsResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ListTransformationsResponse',
      json,
      ($checkedConvert) {
        final val = ListTransformationsResponse(
          transformations: $checkedConvert(
              'transformations',
              (v) => (v as List<dynamic>)
                  .map(
                      (e) => Transformation.fromJson(e as Map<String, dynamic>))
                  .toList()),
          pagination: $checkedConvert('pagination',
              (v) => Pagination.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$ListTransformationsResponseToJson(
        ListTransformationsResponse instance) =>
    <String, dynamic>{
      'transformations':
          instance.transformations.map((e) => e.toJson()).toList(),
      'pagination': instance.pagination.toJson(),
    };
