// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'range.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Range _$RangeFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Range',
      json,
      ($checkedConvert) {
        final val = Range(
          from: $checkedConvert('from', (v) => (v as num?)?.toInt()),
          value: $checkedConvert('value', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$RangeToJson(Range instance) => <String, dynamic>{
      if (instance.from case final value?) 'from': value,
      if (instance.value case final value?) 'value': value,
    };
