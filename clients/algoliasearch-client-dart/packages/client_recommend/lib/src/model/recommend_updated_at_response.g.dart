// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'recommend_updated_at_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RecommendUpdatedAtResponse _$RecommendUpdatedAtResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'RecommendUpdatedAtResponse',
      json,
      ($checkedConvert) {
        final val = RecommendUpdatedAtResponse(
          taskID: $checkedConvert('taskID', (v) => (v as num).toInt()),
          updatedAt: $checkedConvert('updatedAt', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$RecommendUpdatedAtResponseToJson(
        RecommendUpdatedAtResponse instance) =>
    <String, dynamic>{
      'taskID': instance.taskID,
      'updatedAt': instance.updatedAt,
    };
