// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'task_v1.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TaskV1 _$TaskV1FromJson(Map<String, dynamic> json) => $checkedCreate(
      'TaskV1',
      json,
      ($checkedConvert) {
        final val = TaskV1(
          taskID: $checkedConvert('taskID', (v) => v as String),
          sourceID: $checkedConvert('sourceID', (v) => v as String),
          destinationID: $checkedConvert('destinationID', (v) => v as String),
          trigger: $checkedConvert('trigger', (v) => v),
          input: $checkedConvert('input', (v) => v),
          enabled: $checkedConvert('enabled', (v) => v as bool),
          failureThreshold:
              $checkedConvert('failureThreshold', (v) => (v as num?)?.toInt()),
          action: $checkedConvert(
              'action', (v) => $enumDecodeNullable(_$ActionTypeEnumMap, v)),
          cursor: $checkedConvert('cursor', (v) => v as String?),
          notifications: $checkedConvert(
              'notifications',
              (v) => v == null
                  ? null
                  : Notifications.fromJson(v as Map<String, dynamic>)),
          policies: $checkedConvert(
              'policies',
              (v) => v == null
                  ? null
                  : Policies.fromJson(v as Map<String, dynamic>)),
          createdAt: $checkedConvert('createdAt', (v) => v as String),
          updatedAt: $checkedConvert('updatedAt', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$TaskV1ToJson(TaskV1 instance) {
  final val = <String, dynamic>{
    'taskID': instance.taskID,
    'sourceID': instance.sourceID,
    'destinationID': instance.destinationID,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('trigger', instance.trigger);
  writeNotNull('input', instance.input);
  val['enabled'] = instance.enabled;
  writeNotNull('failureThreshold', instance.failureThreshold);
  writeNotNull('action', instance.action?.toJson());
  writeNotNull('cursor', instance.cursor);
  writeNotNull('notifications', instance.notifications?.toJson());
  writeNotNull('policies', instance.policies?.toJson());
  val['createdAt'] = instance.createdAt;
  val['updatedAt'] = instance.updatedAt;
  return val;
}

const _$ActionTypeEnumMap = {
  ActionType.replace: 'replace',
  ActionType.save: 'save',
  ActionType.partial: 'partial',
  ActionType.partialNoCreate: 'partialNoCreate',
  ActionType.append: 'append',
};
