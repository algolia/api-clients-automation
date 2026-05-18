// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'push_task_records.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PushTaskRecords _$PushTaskRecordsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'PushTaskRecords',
      json,
      ($checkedConvert) {
        final val = PushTaskRecords(
          objectID: $checkedConvert('objectID', (v) => v as String),
        );
        return val;
      },
    );

const _$PushTaskRecordsFieldMap = <String, String>{
  'objectID': 'objectID',
};

Map<String, dynamic> _$PushTaskRecordsToJson(PushTaskRecords instance) =>
    <String, dynamic>{
      'objectID': instance.objectID,
    };
