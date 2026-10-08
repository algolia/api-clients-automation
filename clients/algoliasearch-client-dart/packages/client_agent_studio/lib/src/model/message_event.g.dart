// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'message_event.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MessageEvent _$MessageEventFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'MessageEvent',
      json,
      ($checkedConvert) {
        final val = MessageEvent(
          eventType: $checkedConvert('eventType', (v) => v as String),
          eventName: $checkedConvert('eventName', (v) => v as String),
          objectId: $checkedConvert('objectId', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$MessageEventToJson(MessageEvent instance) {
  final val = <String, dynamic>{
    'eventType': instance.eventType,
    'eventName': instance.eventName,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('objectId', instance.objectId);
  return val;
}
