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
        );
        return val;
      },
    );

Map<String, dynamic> _$AlgoliaSearchToolConfigToJson(
        AlgoliaSearchToolConfig instance) =>
    <String, dynamic>{
      'name': instance.name,
      'type': instance.type,
      'indices': instance.indices.map((e) => e.toJson()).toList(),
    };
