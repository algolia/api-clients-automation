// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'algolia_compare_products_tool_config.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AlgoliaCompareProductsToolConfig _$AlgoliaCompareProductsToolConfigFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AlgoliaCompareProductsToolConfig',
      json,
      ($checkedConvert) {
        final val = AlgoliaCompareProductsToolConfig(
          name: $checkedConvert('name', (v) => v as String?),
          type: $checkedConvert('type', (v) => v as String),
          description: $checkedConvert('description', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$AlgoliaCompareProductsToolConfigToJson(
    AlgoliaCompareProductsToolConfig instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('name', instance.name);
  val['type'] = instance.type;
  writeNotNull('description', instance.description);
  return val;
}
