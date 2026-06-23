// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'dynamic_threshold.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

DynamicThreshold _$DynamicThresholdFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'DynamicThreshold',
      json,
      ($checkedConvert) {
        final val = DynamicThreshold(
          enabled: $checkedConvert('enabled', (v) => v as bool?),
          aggression:
              $checkedConvert('aggression', (v) => (v as num?)?.toDouble()),
          upperLimit:
              $checkedConvert('upperLimit', (v) => (v as num?)?.toDouble()),
          lowerLimit:
              $checkedConvert('lowerLimit', (v) => (v as num?)?.toDouble()),
        );
        return val;
      },
    );

Map<String, dynamic> _$DynamicThresholdToJson(DynamicThreshold instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('enabled', instance.enabled);
  writeNotNull('aggression', instance.aggression);
  writeNotNull('upperLimit', instance.upperLimit);
  writeNotNull('lowerLimit', instance.lowerLimit);
  return val;
}
