// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'trigger_update_input.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TriggerUpdateInput _$TriggerUpdateInputFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'TriggerUpdateInput',
      json,
      ($checkedConvert) {
        final val = TriggerUpdateInput(
          cron: $checkedConvert('cron', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$TriggerUpdateInputToJson(TriggerUpdateInput instance) =>
    <String, dynamic>{
      'cron': instance.cron,
    };
