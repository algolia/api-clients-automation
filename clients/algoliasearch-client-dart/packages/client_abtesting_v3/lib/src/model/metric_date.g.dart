// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'metric_date.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MetricDate _$MetricDateFromJson(Map<String, dynamic> json) => $checkedCreate(
      'MetricDate',
      json,
      ($checkedConvert) {
        final val = MetricDate(
          date: $checkedConvert('date', (v) => v as String?),
          metrics: $checkedConvert(
              'metrics',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => MetricResult.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$MetricDateToJson(MetricDate instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('date', instance.date);
  writeNotNull('metrics', instance.metrics?.map((e) => e.toJson()).toList());
  return val;
}
