// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'schedule_ab_tests_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ScheduleABTestsRequest _$ScheduleABTestsRequestFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ScheduleABTestsRequest',
      json,
      ($checkedConvert) {
        final val = ScheduleABTestsRequest(
          name: $checkedConvert('name', (v) => v as String),
          variants: $checkedConvert('variants', (v) => v as List<dynamic>),
          metrics: $checkedConvert(
              'metrics',
              (v) => (v as List<dynamic>)
                  .map((e) => CreateMetric.fromJson(e as Map<String, dynamic>))
                  .toList()),
          configuration: $checkedConvert(
              'configuration',
              (v) => v == null
                  ? null
                  : ABTestConfiguration.fromJson(v as Map<String, dynamic>)),
          scheduledAt: $checkedConvert('scheduledAt', (v) => v as String),
          endAt: $checkedConvert('endAt', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$ScheduleABTestsRequestToJson(
    ScheduleABTestsRequest instance) {
  final val = <String, dynamic>{
    'name': instance.name,
    'variants': instance.variants.toList(),
    'metrics': instance.metrics.map((e) => e.toJson()).toList(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('configuration', instance.configuration?.toJson());
  val['scheduledAt'] = instance.scheduledAt;
  val['endAt'] = instance.endAt;
  return val;
}
