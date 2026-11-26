// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'get_task_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

GetTaskResponse _$GetTaskResponseFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'GetTaskResponse',
      json,
      ($checkedConvert) {
        final val = GetTaskResponse(
          status: $checkedConvert(
              'status', (v) => $enumDecode(_$TaskStatusEnumMap, v)),
          pendingTask: $checkedConvert('pendingTask', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$GetTaskResponseToJson(GetTaskResponse instance) {
  final val = <String, dynamic>{
    'status': instance.status.toJson(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('pendingTask', instance.pendingTask);
  return val;
}

const _$TaskStatusEnumMap = {
  TaskStatus.published: 'published',
  TaskStatus.notPublished: 'notPublished',
};
