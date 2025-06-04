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

Map<String, dynamic> _$WatchResponseToJson(WatchResponse instance) =>
    <String, dynamic>{
      'runID': instance.runID,
      if (instance.eventID case final value?) 'eventID': value,
      if (instance.data case final value?) 'data': value,
      if (instance.events?.map((e) => e.toJson()).toList() case final value?)
        'events': value,
      if (instance.message case final value?) 'message': value,
      if (instance.createdAt case final value?) 'createdAt': value,
    };
