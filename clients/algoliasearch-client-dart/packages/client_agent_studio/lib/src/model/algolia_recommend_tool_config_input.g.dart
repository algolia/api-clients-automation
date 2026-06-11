// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'algolia_recommend_tool_config_input.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AlgoliaRecommendToolConfigInput _$AlgoliaRecommendToolConfigInputFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AlgoliaRecommendToolConfigInput',
      json,
      ($checkedConvert) {
        final val = AlgoliaRecommendToolConfigInput(
          name: $checkedConvert('name', (v) => v as String),
          type: $checkedConvert('type', (v) => v as String),
          allowedConfigs: $checkedConvert(
              'allowedConfigs',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => AlgoliaRecommendToolIndexConfig.fromJson(
                      e as Map<String, dynamic>))
                  .toList()),
          predefinedRecommendParameters: $checkedConvert(
              'predefinedRecommendParameters',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$AlgoliaRecommendToolConfigInputToJson(
    AlgoliaRecommendToolConfigInput instance) {
  final val = <String, dynamic>{
    'name': instance.name,
    'type': instance.type,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('allowedConfigs',
      instance.allowedConfigs?.map((e) => e.toJson()).toList());
  writeNotNull(
      'predefinedRecommendParameters', instance.predefinedRecommendParameters);
  return val;
}
