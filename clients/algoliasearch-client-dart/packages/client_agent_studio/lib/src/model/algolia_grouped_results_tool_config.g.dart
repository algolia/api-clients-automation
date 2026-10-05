// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'algolia_grouped_results_tool_config.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AlgoliaGroupedResultsToolConfig _$AlgoliaGroupedResultsToolConfigFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AlgoliaGroupedResultsToolConfig',
      json,
      ($checkedConvert) {
        final val = AlgoliaGroupedResultsToolConfig(
          name: $checkedConvert('name', (v) => v as String?),
          isTerminal: $checkedConvert('isTerminal', (v) => v as bool?),
          minGroups: $checkedConvert('minGroups', (v) => (v as num?)?.toInt()),
          maxGroups: $checkedConvert('maxGroups', (v) => (v as num?)?.toInt()),
          minResultsPerGroup: $checkedConvert(
              'minResultsPerGroup', (v) => (v as num?)?.toInt()),
          maxResultsPerGroup: $checkedConvert(
              'maxResultsPerGroup', (v) => (v as num?)?.toInt()),
          type: $checkedConvert('type', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$AlgoliaGroupedResultsToolConfigToJson(
    AlgoliaGroupedResultsToolConfig instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('name', instance.name);
  writeNotNull('isTerminal', instance.isTerminal);
  writeNotNull('minGroups', instance.minGroups);
  writeNotNull('maxGroups', instance.maxGroups);
  writeNotNull('minResultsPerGroup', instance.minResultsPerGroup);
  writeNotNull('maxResultsPerGroup', instance.maxResultsPerGroup);
  val['type'] = instance.type;
  return val;
}
