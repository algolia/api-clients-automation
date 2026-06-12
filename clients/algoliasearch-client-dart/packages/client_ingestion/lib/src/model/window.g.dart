// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'window.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Window _$WindowFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Window',
      json,
      ($checkedConvert) {
        final val = Window(
          startDate: $checkedConvert('startDate', (v) => v as String),
          endDate: $checkedConvert('endDate', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$WindowToJson(Window instance) => <String, dynamic>{
      'startDate': instance.startDate,
      'endDate': instance.endDate,
    };
