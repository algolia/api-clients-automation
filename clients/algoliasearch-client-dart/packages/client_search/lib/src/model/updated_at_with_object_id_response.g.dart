// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'updated_at_with_object_id_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

UpdatedAtWithObjectIdResponse _$UpdatedAtWithObjectIdResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'UpdatedAtWithObjectIdResponse',
      json,
      ($checkedConvert) {
        final val = UpdatedAtWithObjectIdResponse(
          taskID: $checkedConvert('taskID', (v) => (v as num?)?.toInt()),
          updatedAt: $checkedConvert('updatedAt', (v) => v as String?),
          objectID: $checkedConvert('objectID', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$UpdatedAtWithObjectIdResponseToJson(
        UpdatedAtWithObjectIdResponse instance) =>
    <String, dynamic>{
      if (instance.taskID case final value?) 'taskID': value,
      if (instance.updatedAt case final value?) 'updatedAt': value,
      if (instance.objectID case final value?) 'objectID': value,
    };
