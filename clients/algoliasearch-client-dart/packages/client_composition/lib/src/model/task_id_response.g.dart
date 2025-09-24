// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'task_id_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TaskIDResponse _$TaskIDResponseFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'TaskIDResponse',
      json,
      ($checkedConvert) {
        final val = TaskIDResponse(
          taskID: $checkedConvert('taskID', (v) => (v as num).toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$TaskIDResponseToJson(TaskIDResponse instance) =>
    <String, dynamic>{
      'taskID': instance.taskID,
    };
