// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'streaming_trigger.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

StreamingTrigger _$StreamingTriggerFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'StreamingTrigger',
      json,
      ($checkedConvert) {
        final val = StreamingTrigger(
          type: $checkedConvert(
              'type', (v) => $enumDecode(_$StreamingTriggerTypeEnumMap, v)),
        );
        return val;
      },
    );

Map<String, dynamic> _$StreamingTriggerToJson(StreamingTrigger instance) =>
    <String, dynamic>{
      'type': instance.type.toJson(),
    };

const _$StreamingTriggerTypeEnumMap = {
  StreamingTriggerType.streaming: 'streaming',
};
