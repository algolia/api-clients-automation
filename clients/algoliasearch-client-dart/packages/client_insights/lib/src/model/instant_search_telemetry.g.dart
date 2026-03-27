// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'instant_search_telemetry.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

InstantSearchTelemetry _$InstantSearchTelemetryFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'InstantSearchTelemetry',
      json,
      ($checkedConvert) {
        final val = InstantSearchTelemetry(
          eventType: $checkedConvert('eventType',
              (v) => $enumDecode(_$InstantSearchTelemetryEventEnumMap, v)),
          eventName: $checkedConvert('eventName', (v) => v as String),
          sessionID: $checkedConvert('sessionID', (v) => v as String),
          userToken: $checkedConvert('userToken', (v) => v as String),
          authenticatedUserToken:
              $checkedConvert('authenticatedUserToken', (v) => v as String?),
          timestamp: $checkedConvert('timestamp', (v) => (v as num?)?.toInt()),
          performance: $checkedConvert('performance', (v) => v),
          widgets: $checkedConvert('widgets', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$InstantSearchTelemetryToJson(
    InstantSearchTelemetry instance) {
  final val = <String, dynamic>{
    'eventType': instance.eventType.toJson(),
    'eventName': instance.eventName,
    'sessionID': instance.sessionID,
    'userToken': instance.userToken,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('authenticatedUserToken', instance.authenticatedUserToken);
  writeNotNull('timestamp', instance.timestamp);
  writeNotNull('performance', instance.performance);
  writeNotNull('widgets', instance.widgets);
  return val;
}

const _$InstantSearchTelemetryEventEnumMap = {
  InstantSearchTelemetryEvent.instantsearchTelemetry: 'instantsearch_telemetry',
};
