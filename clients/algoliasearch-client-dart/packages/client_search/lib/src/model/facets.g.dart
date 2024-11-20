// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'facets.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Facets _$FacetsFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Facets',
      json,
      ($checkedConvert) {
        final val = Facets(
          order: $checkedConvert('order',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$FacetsToJson(Facets instance) => <String, dynamic>{
      if (instance.order case final value?) 'order': value,
    };
