// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'facet_ordering.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

FacetOrdering _$FacetOrderingFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'FacetOrdering',
      json,
      ($checkedConvert) {
        final val = FacetOrdering(
          facets: $checkedConvert(
              'facets',
              (v) => v == null
                  ? null
                  : Facets.fromJson(v as Map<String, dynamic>)),
          values: $checkedConvert(
              'values',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) =>
                        MapEntry(k, Value.fromJson(e as Map<String, dynamic>)),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$FacetOrderingToJson(FacetOrdering instance) =>
    <String, dynamic>{
      if (instance.facets?.toJson() case final value?) 'facets': value,
      if (instance.values?.map((k, e) => MapEntry(k, e.toJson()))
          case final value?)
        'values': value,
    };
