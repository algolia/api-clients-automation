// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'facet_request_scope.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

FacetRequestScope _$FacetRequestScopeFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'FacetRequestScope',
      json,
      ($checkedConvert) {
        final val = FacetRequestScope(
          facetName: $checkedConvert('facetName', (v) => v as String),
          facetValue: $checkedConvert('facetValue', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$FacetRequestScopeToJson(FacetRequestScope instance) =>
    <String, dynamic>{
      'facetName': instance.facetName,
      'facetValue': instance.facetValue,
    };
