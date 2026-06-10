// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'task_replace.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TaskReplace _$TaskReplaceFromJson(Map<String, dynamic> json) => $checkedCreate(
      'TaskReplace',
      json,
      ($checkedConvert) {
        final val = TaskReplace(
          destinationID: $checkedConvert('destinationID', (v) => v as String),
          action: $checkedConvert(
              'action', (v) => $enumDecode(_$ActionTypeEnumMap, v)),
          subscriptionAction: $checkedConvert('subscriptionAction',
              (v) => $enumDecodeNullable(_$ActionTypeEnumMap, v)),
          cron: $checkedConvert('cron', (v) => v as String?),
          enabled: $checkedConvert('enabled', (v) => v as bool?),
          failureThreshold:
              $checkedConvert('failureThreshold', (v) => (v as num?)?.toInt()),
          input: $checkedConvert('input', (v) => v),
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
        );
        return val;
      },
    );

Map<String, dynamic> _$TaskReplaceToJson(TaskReplace instance) {
  final val = <String, dynamic>{
    'destinationID': instance.destinationID,
    'action': instance.action.toJson(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('subscriptionAction', instance.subscriptionAction?.toJson());
  writeNotNull('cron', instance.cron);
  writeNotNull('enabled', instance.enabled);
  writeNotNull('failureThreshold', instance.failureThreshold);
  writeNotNull('input', instance.input);
  writeNotNull('cursor', instance.cursor);
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
