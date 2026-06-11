// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'algolia_display_results_tool_config.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AlgoliaDisplayResultsToolConfig _$AlgoliaDisplayResultsToolConfigFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AlgoliaDisplayResultsToolConfig',
      json,
      ($checkedConvert) {
        final val = AlgoliaDisplayResultsToolConfig(
          name: $checkedConvert('name', (v) => v as String?),
          type: $checkedConvert('type', (v) => v as String),
          minGroups: $checkedConvert('minGroups', (v) => (v as num?)?.toInt()),
          maxGroups: $checkedConvert('maxGroups', (v) => (v as num?)?.toInt()),
          minResultsPerGroup: $checkedConvert(
              'minResultsPerGroup', (v) => (v as num?)?.toInt()),
          maxResultsPerGroup: $checkedConvert(
              'maxResultsPerGroup', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$AlgoliaDisplayResultsToolConfigToJson(
    AlgoliaDisplayResultsToolConfig instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('name', instance.name);
  val['type'] = instance.type;
  writeNotNull('minGroups', instance.minGroups);
  writeNotNull('maxGroups', instance.maxGroups);
  writeNotNull('minResultsPerGroup', instance.minResultsPerGroup);
  writeNotNull('maxResultsPerGroup', instance.maxResultsPerGroup);
  return val;
}
