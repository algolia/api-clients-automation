// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'rules_multiple_batch_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RulesMultipleBatchResponse _$RulesMultipleBatchResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'RulesMultipleBatchResponse',
      json,
      ($checkedConvert) {
        final val = RulesMultipleBatchResponse(
          taskID: $checkedConvert('taskID', (v) => (v as num).toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$RulesMultipleBatchResponseToJson(
        RulesMultipleBatchResponse instance) =>
    <String, dynamic>{
      'taskID': instance.taskID,
    };
