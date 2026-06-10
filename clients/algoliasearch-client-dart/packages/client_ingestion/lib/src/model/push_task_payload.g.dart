// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'push_task_payload.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PushTaskPayload _$PushTaskPayloadFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'PushTaskPayload',
      json,
      ($checkedConvert) {
        final val = PushTaskPayload(
          action:
              $checkedConvert('action', (v) => $enumDecode(_$ActionEnumMap, v)),
          records: $checkedConvert(
              'records',
              (v) => (v as List<dynamic>)
                  .map((e) =>
                      PushTaskRecords.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$PushTaskPayloadToJson(PushTaskPayload instance) =>
    <String, dynamic>{
      'action': instance.action.toJson(),
      'records': instance.records.map((e) => e.toJson()).toList(),
    };

const _$ActionEnumMap = {
  Action.addObject: 'addObject',
  Action.updateObject: 'updateObject',
  Action.partialUpdateObject: 'partialUpdateObject',
  Action.partialUpdateObjectNoCreate: 'partialUpdateObjectNoCreate',
  Action.deleteObject: 'deleteObject',
  Action.delete: 'delete',
  Action.clear: 'clear',
};
