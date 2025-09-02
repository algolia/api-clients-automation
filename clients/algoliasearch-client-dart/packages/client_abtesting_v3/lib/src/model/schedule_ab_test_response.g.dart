// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'schedule_ab_test_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ScheduleABTestResponse _$ScheduleABTestResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ScheduleABTestResponse',
      json,
      ($checkedConvert) {
        final val = ScheduleABTestResponse(
          abTestScheduleID:
              $checkedConvert('abTestScheduleID', (v) => (v as num).toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$ScheduleABTestResponseToJson(
        ScheduleABTestResponse instance) =>
    <String, dynamic>{
      'abTestScheduleID': instance.abTestScheduleID,
    };
