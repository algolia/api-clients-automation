// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'algolia_search_tool_config.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AlgoliaSearchToolConfig _$AlgoliaSearchToolConfigFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AlgoliaSearchToolConfig',
      json,
      ($checkedConvert) {
        final val = AlgoliaSearchToolConfig(
          name: $checkedConvert('name', (v) => v as String),
          type: $checkedConvert('type', (v) => v as String),
          indices: $checkedConvert(
              'indices',
              (v) => (v as List<dynamic>)
                  .map((e) => AlgoliaSearchToolIndexConfig.fromJson(
                      e as Map<String, dynamic>))
                  .toList()),
          mode: $checkedConvert(
              'mode', (v) => $enumDecodeNullable(_$ModeEnumEnumMap, v)),
          allowUnlistedIndices:
              $checkedConvert('allowUnlistedIndices', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$AlgoliaSearchToolConfigToJson(
    AlgoliaSearchToolConfig instance) {
  final val = <String, dynamic>{
    'name': instance.name,
    'type': instance.type,
    'indices': instance.indices.map((e) => e.toJson()).toList(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('mode', instance.mode?.toJson());
  writeNotNull('allowUnlistedIndices', instance.allowUnlistedIndices);
  return val;
}

const _$ModeEnumEnumMap = {
  ModeEnum.static_: 'static',
  ModeEnum.dynamic_: 'dynamic',
};
