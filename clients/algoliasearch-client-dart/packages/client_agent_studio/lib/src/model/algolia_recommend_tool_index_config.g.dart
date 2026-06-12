// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'algolia_recommend_tool_index_config.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AlgoliaRecommendToolIndexConfig _$AlgoliaRecommendToolIndexConfigFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AlgoliaRecommendToolIndexConfig',
      json,
      ($checkedConvert) {
        final val = AlgoliaRecommendToolIndexConfig(
          index: $checkedConvert('index', (v) => v as String),
          modelName: $checkedConvert('modelName', (v) => v as String),
          description: $checkedConvert('description', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$AlgoliaRecommendToolIndexConfigToJson(
    AlgoliaRecommendToolIndexConfig instance) {
  final val = <String, dynamic>{
    'index': instance.index,
    'modelName': instance.modelName,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('description', instance.description);
  return val;
}
