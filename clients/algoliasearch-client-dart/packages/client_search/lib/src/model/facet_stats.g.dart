// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'facet_stats.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

FacetStats _$FacetStatsFromJson(Map<String, dynamic> json) => $checkedCreate(
      'FacetStats',
      json,
      ($checkedConvert) {
        final val = FacetStats(
          min: $checkedConvert('min', (v) => (v as num?)?.toDouble()),
          max: $checkedConvert('max', (v) => (v as num?)?.toDouble()),
          avg: $checkedConvert('avg', (v) => (v as num?)?.toDouble()),
          sum: $checkedConvert('sum', (v) => (v as num?)?.toDouble()),
        );
        return val;
      },
    );

Map<String, dynamic> _$FacetStatsToJson(FacetStats instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('min', instance.min);
  writeNotNull('max', instance.max);
  writeNotNull('avg', instance.avg);
  writeNotNull('sum', instance.sum);
  return val;
}
