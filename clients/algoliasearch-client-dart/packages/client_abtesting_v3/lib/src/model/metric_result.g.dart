// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'metric_result.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MetricResult _$MetricResultFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'MetricResult',
      json,
      ($checkedConvert) {
        final val = MetricResult(
          name: $checkedConvert('name', (v) => v as String),
          updatedAt: $checkedConvert('updatedAt', (v) => v as String),
          value: $checkedConvert('value', (v) => (v as num).toDouble()),
          valueCIHigh:
              $checkedConvert('valueCIHigh', (v) => (v as num?)?.toDouble()),
          valueCILow:
              $checkedConvert('valueCILow', (v) => (v as num?)?.toDouble()),
          pValue: $checkedConvert('pValue', (v) => (v as num).toDouble()),
          dimension: $checkedConvert('dimension', (v) => v as String?),
          metadata: $checkedConvert(
              'metadata',
              (v) => v == null
                  ? null
                  : MetricMetadata.fromJson(v as Map<String, dynamic>)),
          criticalValue:
              $checkedConvert('criticalValue', (v) => (v as num?)?.toDouble()),
          significant: $checkedConvert('significant', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$MetricResultToJson(MetricResult instance) {
  final val = <String, dynamic>{
    'name': instance.name,
    'updatedAt': instance.updatedAt,
    'value': instance.value,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('valueCIHigh', instance.valueCIHigh);
  writeNotNull('valueCILow', instance.valueCILow);
  val['pValue'] = instance.pValue;
  writeNotNull('dimension', instance.dimension);
  writeNotNull('metadata', instance.metadata?.toJson());
  writeNotNull('criticalValue', instance.criticalValue);
  writeNotNull('significant', instance.significant);
  return val;
}
