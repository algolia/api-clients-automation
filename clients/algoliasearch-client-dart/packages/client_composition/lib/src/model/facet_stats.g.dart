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

Map<String, dynamic> _$FacetStatsToJson(FacetStats instance) =>
    <String, dynamic>{
      if (instance.min case final value?) 'min': value,
      if (instance.max case final value?) 'max': value,
      if (instance.avg case final value?) 'avg': value,
      if (instance.sum case final value?) 'sum': value,
    };
