// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'metrics_filter.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MetricsFilter _$MetricsFilterFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'MetricsFilter',
      json,
      ($checkedConvert) {
        final val = MetricsFilter(
          domain: $checkedConvert('domain', (v) => v as String),
          name: $checkedConvert('name', (v) => v as String),
          trackEffects: $checkedConvert('trackEffects', (v) => v as bool?),
          includes: $checkedConvert('includes', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$MetricsFilterToJson(MetricsFilter instance) {
  final val = <String, dynamic>{
    'domain': instance.domain,
    'name': instance.name,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('trackEffects', instance.trackEffects);
  writeNotNull('includes', instance.includes);
  return val;
}
