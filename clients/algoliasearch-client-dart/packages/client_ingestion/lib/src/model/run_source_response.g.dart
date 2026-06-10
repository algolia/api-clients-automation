// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'run_source_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RunSourceResponse _$RunSourceResponseFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'RunSourceResponse',
      json,
      ($checkedConvert) {
        final val = RunSourceResponse(
          taskWithRunID: $checkedConvert(
              'taskWithRunID', (v) => Map<String, String>.from(v as Map)),
          createdAt: $checkedConvert('createdAt', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$RunSourceResponseToJson(RunSourceResponse instance) =>
    <String, dynamic>{
      'taskWithRunID': instance.taskWithRunID,
      'createdAt': instance.createdAt,
    };
