// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'algolia_search_tool_index_config.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AlgoliaSearchToolIndexConfig _$AlgoliaSearchToolIndexConfigFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AlgoliaSearchToolIndexConfig',
      json,
      ($checkedConvert) {
        final val = AlgoliaSearchToolIndexConfig(
          index: $checkedConvert('index', (v) => v as String),
          description: $checkedConvert('description', (v) => v as String),
          enhancedDescription:
              $checkedConvert('enhancedDescription', (v) => v as String?),
          searchParameters: $checkedConvert(
              'searchParameters',
              (v) => v == null
                  ? null
                  : SearchParameters.fromJson(v as Map<String, dynamic>)),
          searchControls: $checkedConvert(
              'searchControls',
              (v) => v == null
                  ? null
                  : IndexSearchParameters.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$AlgoliaSearchToolIndexConfigToJson(
    AlgoliaSearchToolIndexConfig instance) {
  final val = <String, dynamic>{
    'index': instance.index,
    'description': instance.description,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('enhancedDescription', instance.enhancedDescription);
  writeNotNull('searchParameters', instance.searchParameters?.toJson());
  writeNotNull('searchControls', instance.searchControls?.toJson());
  return val;
}
