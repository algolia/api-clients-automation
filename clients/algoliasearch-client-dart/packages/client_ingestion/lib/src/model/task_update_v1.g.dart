// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'task_update_v1.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TaskUpdateV1 _$TaskUpdateV1FromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'TaskUpdateV1',
      json,
      ($checkedConvert) {
        final val = TaskUpdateV1(
          destinationID: $checkedConvert('destinationID', (v) => v as String?),
          trigger: $checkedConvert(
              'trigger',
              (v) => v == null
                  ? null
                  : TriggerUpdateInput.fromJson(v as Map<String, dynamic>)),
          input: $checkedConvert('input', (v) => v),
          enabled: $checkedConvert('enabled', (v) => v as bool?),
          failureThreshold:
              $checkedConvert('failureThreshold', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$TaskUpdateV1ToJson(TaskUpdateV1 instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('destinationID', instance.destinationID);
  writeNotNull('trigger', instance.trigger?.toJson());
  writeNotNull('input', instance.input);
  writeNotNull('enabled', instance.enabled);
  writeNotNull('failureThreshold', instance.failureThreshold);
  return val;
}
