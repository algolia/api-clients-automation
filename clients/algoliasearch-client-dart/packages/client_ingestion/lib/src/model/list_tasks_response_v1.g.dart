// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'list_tasks_response_v1.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ListTasksResponseV1 _$ListTasksResponseV1FromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ListTasksResponseV1',
      json,
      ($checkedConvert) {
        final val = ListTasksResponseV1(
          tasks: $checkedConvert(
              'tasks',
              (v) => (v as List<dynamic>)
                  .map((e) => TaskV1.fromJson(e as Map<String, dynamic>))
                  .toList()),
          pagination: $checkedConvert('pagination',
              (v) => Pagination.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$ListTasksResponseV1ToJson(
        ListTasksResponseV1 instance) =>
    <String, dynamic>{
      'tasks': instance.tasks.map((e) => e.toJson()).toList(),
      'pagination': instance.pagination.toJson(),
    };
