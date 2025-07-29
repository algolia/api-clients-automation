// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'timeseries_variant.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TimeseriesVariant _$TimeseriesVariantFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'TimeseriesVariant',
      json,
      ($checkedConvert) {
        final val = TimeseriesVariant(
          dates: $checkedConvert(
              'dates',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => MetricDate.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$TimeseriesVariantToJson(TimeseriesVariant instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('dates', instance.dates?.map((e) => e.toJson()).toList());
  return val;
}
