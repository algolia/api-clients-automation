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
  return val;
}

const _$ErrorCorrectionTypeEnumMap = {
  ErrorCorrectionType.bonferroni: 'bonferroni',
  ErrorCorrectionType.benjaminiHochberg: 'benjamini-hochberg',
};
