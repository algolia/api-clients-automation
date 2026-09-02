// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'ab_test_configuration.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ABTestConfiguration _$ABTestConfigurationFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ABTestConfiguration',
      json,
      ($checkedConvert) {
        final val = ABTestConfiguration(
          minimumDetectableEffect: $checkedConvert(
              'minimumDetectableEffect',
              (v) => v == null
                  ? null
                  : MinimumDetectableEffect.fromJson(
                      v as Map<String, dynamic>)),
          filters: $checkedConvert(
              'filters',
              (v) => (v as List<dynamic>?)
                  ?.map(
                      (e) => MetricsFilter.fromJson(e as Map<String, dynamic>))
                  .toList()),
          errorCorrection: $checkedConvert('errorCorrection',
              (v) => $enumDecodeNullable(_$ErrorCorrectionTypeEnumMap, v)),
          method: $checkedConvert(
              'method', (v) => $enumDecodeNullable(_$AnalysisMethodEnumMap, v)),
          primaryMetric: $checkedConvert('primaryMetric',
              (v) => $enumDecodeNullable(_$PrimaryMetricEnumMap, v)),
        );
        return val;
      },
    );

Map<String, dynamic> _$ABTestConfigurationToJson(ABTestConfiguration instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull(
      'minimumDetectableEffect', instance.minimumDetectableEffect?.toJson());
  writeNotNull('filters', instance.filters?.map((e) => e.toJson()).toList());
  writeNotNull('errorCorrection', instance.errorCorrection?.toJson());
  writeNotNull('method', instance.method?.toJson());
  writeNotNull('primaryMetric', instance.primaryMetric?.toJson());
  return val;
}

const _$ErrorCorrectionTypeEnumMap = {
  ErrorCorrectionType.bonferroni: 'bonferroni',
  ErrorCorrectionType.benjaminiHochberg: 'benjamini-hochberg',
};

const _$AnalysisMethodEnumMap = {
  AnalysisMethod.bayesian: 'bayesian',
  AnalysisMethod.frequentist: 'frequentist',
};

const _$PrimaryMetricEnumMap = {
  PrimaryMetric.addToCartRate: 'add_to_cart_rate',
  PrimaryMetric.clickThroughRate: 'click_through_rate',
  PrimaryMetric.conversionRate: 'conversion_rate',
  PrimaryMetric.purchaseRate: 'purchase_rate',
  PrimaryMetric.noResultsRate: 'no_results_rate',
};
