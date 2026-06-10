// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'watch_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

WatchResponse _$WatchResponseFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'WatchResponse',
      json,
      ($checkedConvert) {
        final val = WatchResponse(
          runID: $checkedConvert('runID', (v) => v as String),
          eventID: $checkedConvert('eventID', (v) => v as String?),
          data: $checkedConvert('data',
              (v) => (v as List<dynamic>?)?.map((e) => e as Object).toList()),
          events: $checkedConvert(
              'events',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => Event.fromJson(e as Map<String, dynamic>))
                  .toList()),
          message: $checkedConvert('message', (v) => v as String?),
          createdAt: $checkedConvert('createdAt', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$WatchResponseToJson(WatchResponse instance) {
  final val = <String, dynamic>{
    'runID': instance.runID,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('eventID', instance.eventID);
  writeNotNull('data', instance.data);
  writeNotNull('events', instance.events?.map((e) => e.toJson()).toList());
  writeNotNull('message', instance.message);
  writeNotNull('createdAt', instance.createdAt);
  return val;
}
