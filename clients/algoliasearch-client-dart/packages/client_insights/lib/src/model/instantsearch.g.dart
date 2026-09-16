// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'instantsearch.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Instantsearch _$InstantsearchFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'Instantsearch',
      json,
      ($checkedConvert) {
        final val = Instantsearch(
          eventName: $checkedConvert('eventName', (v) => v as String),
          eventType: $checkedConvert(
              'eventType', (v) => $enumDecode(_$InstantsearchEventEnumMap, v)),
          userToken: $checkedConvert('userToken', (v) => v as String),
          authenticatedUserToken:
              $checkedConvert('authenticatedUserToken', (v) => v as String?),
          timestamp: $checkedConvert('timestamp', (v) => (v as num?)?.toInt()),
          agentID: $checkedConvert('agentID', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$InstantsearchToJson(Instantsearch instance) {
  final val = <String, dynamic>{
    'eventName': instance.eventName,
    'eventType': instance.eventType.toJson(),
    'userToken': instance.userToken,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('authenticatedUserToken', instance.authenticatedUserToken);
  writeNotNull('timestamp', instance.timestamp);
  writeNotNull('agentID', instance.agentID);
  return val;
}

const _$InstantsearchEventEnumMap = {
  InstantsearchEvent.instantsearch: 'instantsearch',
};
