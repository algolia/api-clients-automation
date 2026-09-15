// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'bayesian_metric_result.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BayesianMetricResult _$BayesianMetricResultFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'BayesianMetricResult',
      json,
      ($checkedConvert) {
        final val = BayesianMetricResult(
          probabilityToBeBetter: $checkedConvert(
              'probabilityToBeBetter', (v) => (v as num?)?.toDouble()),
          relativeEffectCILow: $checkedConvert(
              'relativeEffectCILow', (v) => (v as num?)?.toDouble()),
          relativeEffectCIHigh: $checkedConvert(
              'relativeEffectCIHigh', (v) => (v as num?)?.toDouble()),
        );
        return val;
      },
    );

Map<String, dynamic> _$BayesianMetricResultToJson(
    BayesianMetricResult instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('probabilityToBeBetter', instance.probabilityToBeBetter);
  writeNotNull('relativeEffectCILow', instance.relativeEffectCILow);
  writeNotNull('relativeEffectCIHigh', instance.relativeEffectCIHigh);
  return val;
}
