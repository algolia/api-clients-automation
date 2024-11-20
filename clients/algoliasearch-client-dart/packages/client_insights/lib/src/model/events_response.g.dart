// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'events_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

EventsResponse _$EventsResponseFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'EventsResponse',
      json,
      ($checkedConvert) {
        final val = EventsResponse(
          message: $checkedConvert('message', (v) => v as String?),
          status: $checkedConvert('status', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$EventsResponseToJson(EventsResponse instance) =>
    <String, dynamic>{
      if (instance.message case final value?) 'message': value,
      if (instance.status case final value?) 'status': value,
    };
