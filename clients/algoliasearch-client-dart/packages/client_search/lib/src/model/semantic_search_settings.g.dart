// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'semantic_search_settings.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SemanticSearchSettings _$SemanticSearchSettingsFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SemanticSearchSettings',
      json,
      ($checkedConvert) {
        final val = SemanticSearchSettings(
          neuralSearchMode: $checkedConvert('neuralSearchMode',
              (v) => $enumDecodeNullable(_$NeuralSearchModeEnumMap, v)),
          eventSources: $checkedConvert('eventSources',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          neuralExpression: $checkedConvert(
              'neuralExpression',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, (e as num).toDouble()),
                  )),
          vectorModelId: $checkedConvert('vectorModelId', (v) => v as String?),
          neuralSearchPreset: $checkedConvert('neuralSearchPreset',
              (v) => $enumDecodeNullable(_$NeuralSearchPresetEnumMap, v)),
          semanticBlendWeight: $checkedConvert(
              'semanticBlendWeight', (v) => (v as num?)?.toDouble()),
          minHitsForSemantic: $checkedConvert(
              'minHitsForSemantic', (v) => (v as num?)?.toInt()),
          enableNeuralSearchSortBy:
              $checkedConvert('enableNeuralSearchSortBy', (v) => v as bool?),
          dynamicThreshold: $checkedConvert(
              'dynamicThreshold',
              (v) => v == null
                  ? null
                  : DynamicThreshold.fromJson(v as Map<String, dynamic>)),
          usePositionalSemanticRanking: $checkedConvert(
              'usePositionalSemanticRanking', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$SemanticSearchSettingsToJson(
    SemanticSearchSettings instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('neuralSearchMode', instance.neuralSearchMode?.toJson());
  writeNotNull('eventSources', instance.eventSources);
  writeNotNull('neuralExpression', instance.neuralExpression);
  writeNotNull('vectorModelId', instance.vectorModelId);
  writeNotNull('neuralSearchPreset', instance.neuralSearchPreset?.toJson());
  writeNotNull('semanticBlendWeight', instance.semanticBlendWeight);
  writeNotNull('minHitsForSemantic', instance.minHitsForSemantic);
  writeNotNull('enableNeuralSearchSortBy', instance.enableNeuralSearchSortBy);
  writeNotNull('dynamicThreshold', instance.dynamicThreshold?.toJson());
  writeNotNull(
      'usePositionalSemanticRanking', instance.usePositionalSemanticRanking);
  return val;
}

const _$NeuralSearchModeEnumMap = {
  NeuralSearchMode.inactive: 'inactive',
  NeuralSearchMode.active: 'active',
  NeuralSearchMode.preview: 'preview',
};

const _$NeuralSearchPresetEnumMap = {
  NeuralSearchPreset.conservative: 'conservative',
  NeuralSearchPreset.expandedReach: 'expanded_reach',
  NeuralSearchPreset.appendOnly: 'append_only',
  NeuralSearchPreset.default_: 'default',
  NeuralSearchPreset.custom: 'custom',
};
