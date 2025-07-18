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

Map<String, dynamic> _$IndexSettingsFacetsToJson(IndexSettingsFacets instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('order', instance.order);
  return val;
}
