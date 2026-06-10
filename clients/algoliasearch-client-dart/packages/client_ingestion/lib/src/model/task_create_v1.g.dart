// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'task_create_v1.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TaskCreateV1 _$TaskCreateV1FromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'TaskCreateV1',
      json,
      ($checkedConvert) {
        final val = TaskCreateV1(
          sourceID: $checkedConvert('sourceID', (v) => v as String),
          destinationID: $checkedConvert('destinationID', (v) => v as String),
          trigger: $checkedConvert('trigger', (v) => v),
          action: $checkedConvert(
              'action', (v) => $enumDecode(_$ActionTypeEnumMap, v)),
          enabled: $checkedConvert('enabled', (v) => v as bool?),
          failureThreshold:
              $checkedConvert('failureThreshold', (v) => (v as num?)?.toInt()),
          input: $checkedConvert('input', (v) => v),
          cursor: $checkedConvert('cursor', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$TaskCreateV1ToJson(TaskCreateV1 instance) {
  final val = <String, dynamic>{
    'sourceID': instance.sourceID,
    'destinationID': instance.destinationID,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('trigger', instance.trigger);
  val['action'] = instance.action.toJson();
  writeNotNull('enabled', instance.enabled);
  writeNotNull('failureThreshold', instance.failureThreshold);
  writeNotNull('input', instance.input);
  writeNotNull('cursor', instance.cursor);
  return val;
}

const _$ActionTypeEnumMap = {
  ActionType.replace: 'replace',
  ActionType.save: 'save',
  ActionType.partial: 'partial',
  ActionType.partialNoCreate: 'partialNoCreate',
  ActionType.append: 'append',
};
