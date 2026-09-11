// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'compaction_stats.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CompactionStats _$CompactionStatsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'CompactionStats',
      json,
      ($checkedConvert) {
        final val = CompactionStats(
          compacted: $checkedConvert('compacted', (v) => v as bool),
          chunksProcessed:
              $checkedConvert('chunksProcessed', (v) => (v as num?)?.toInt()),
          passes: $checkedConvert('passes', (v) => (v as num?)?.toInt()),
          summarizerPromptTokens: $checkedConvert(
              'summarizerPromptTokens', (v) => (v as num?)?.toInt()),
          summarizerCompletionTokens: $checkedConvert(
              'summarizerCompletionTokens', (v) => (v as num?)?.toInt()),
          targetTokensEstimate: $checkedConvert(
              'targetTokensEstimate', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$CompactionStatsToJson(CompactionStats instance) {
  final val = <String, dynamic>{
    'compacted': instance.compacted,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('chunksProcessed', instance.chunksProcessed);
  writeNotNull('passes', instance.passes);
  writeNotNull('summarizerPromptTokens', instance.summarizerPromptTokens);
  writeNotNull(
      'summarizerCompletionTokens', instance.summarizerCompletionTokens);
  writeNotNull('targetTokensEstimate', instance.targetTokensEstimate);
  return val;
}
