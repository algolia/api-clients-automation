// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'time_range.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TimeRange _$TimeRangeFromJson(Map<String, dynamic> json) => $checkedCreate(
      'TimeRange',
      json,
      ($checkedConvert) {
        final val = TimeRange(
          from: $checkedConvert('from', (v) => (v as num?)?.toInt()),
          until: $checkedConvert('until', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$TimeRangeToJson(TimeRange instance) => <String, dynamic>{
      if (instance.from case final value?) 'from': value,
      if (instance.until case final value?) 'until': value,
    };
