// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'index_settings_facets.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

IndexSettingsFacets _$IndexSettingsFacetsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'IndexSettingsFacets',
      json,
      ($checkedConvert) {
        final val = IndexSettingsFacets(
          order: $checkedConvert('order',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$IndexSettingsFacetsToJson(
        IndexSettingsFacets instance) =>
    <String, dynamic>{
      if (instance.order case final value?) 'order': value,
    };
