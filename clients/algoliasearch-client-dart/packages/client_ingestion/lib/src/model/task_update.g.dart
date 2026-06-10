// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'task_update.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TaskUpdate _$TaskUpdateFromJson(Map<String, dynamic> json) => $checkedCreate(
      'TaskUpdate',
      json,
      ($checkedConvert) {
        final val = TaskUpdate(
          destinationID: $checkedConvert('destinationID', (v) => v as String?),
          cron: $checkedConvert('cron', (v) => v as String?),
          input: $checkedConvert('input', (v) => v),
          enabled: $checkedConvert('enabled', (v) => v as bool?),
          subscriptionAction: $checkedConvert('subscriptionAction',
              (v) => $enumDecodeNullable(_$ActionTypeEnumMap, v)),
          failureThreshold:
              $checkedConvert('failureThreshold', (v) => (v as num?)?.toInt()),
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
        );
        return val;
      },
    );

Map<String, dynamic> _$TaskUpdateToJson(TaskUpdate instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('destinationID', instance.destinationID);
  writeNotNull('cron', instance.cron);
  writeNotNull('input', instance.input);
  writeNotNull('enabled', instance.enabled);
  writeNotNull('subscriptionAction', instance.subscriptionAction?.toJson());
  writeNotNull('failureThreshold', instance.failureThreshold);
  writeNotNull('notifications', instance.notifications?.toJson());
  writeNotNull('policies', instance.policies?.toJson());
  return val;
}

const _$ActionTypeEnumMap = {
  ActionType.replace: 'replace',
  ActionType.save: 'save',
  ActionType.partial: 'partial',
  ActionType.partialNoCreate: 'partialNoCreate',
  ActionType.append: 'append',
};
