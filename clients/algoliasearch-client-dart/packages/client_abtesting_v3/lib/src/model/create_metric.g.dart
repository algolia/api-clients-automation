// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'create_metric.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CreateMetric _$CreateMetricFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'CreateMetric',
      json,
      ($checkedConvert) {
        final val = CreateMetric(
          name: $checkedConvert('name', (v) => v as String),
          dimension: $checkedConvert('dimension', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$CreateMetricToJson(CreateMetric instance) {
  final val = <String, dynamic>{
    'name': instance.name,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('dimension', instance.dimension);
  return val;
}
