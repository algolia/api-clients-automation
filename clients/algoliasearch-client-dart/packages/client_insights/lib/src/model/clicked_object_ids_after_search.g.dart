// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'clicked_object_ids_after_search.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ClickedObjectIDsAfterSearch _$ClickedObjectIDsAfterSearchFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ClickedObjectIDsAfterSearch',
      json,
      ($checkedConvert) {
        final val = ClickedObjectIDsAfterSearch(
          eventName: $checkedConvert('eventName', (v) => v as String),
          eventType: $checkedConvert(
              'eventType', (v) => $enumDecode(_$ClickEventEnumMap, v)),
          index: $checkedConvert('index', (v) => v as String),
          objectIDs: $checkedConvert('objectIDs',
              (v) => (v as List<dynamic>).map((e) => e as String).toList()),
          positions: $checkedConvert(
              'positions',
              (v) =>
                  (v as List<dynamic>).map((e) => (e as num).toInt()).toList()),
          queryID: $checkedConvert('queryID', (v) => v as String),
          userToken: $checkedConvert('userToken', (v) => v as String),
          authenticatedUserToken:
              $checkedConvert('authenticatedUserToken', (v) => v as String?),
          timestamp: $checkedConvert('timestamp', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$ClickedObjectIDsAfterSearchToJson(
        ClickedObjectIDsAfterSearch instance) =>
    <String, dynamic>{
      'eventName': instance.eventName,
      'eventType': instance.eventType.toJson(),
      'index': instance.index,
      'objectIDs': instance.objectIDs,
      'positions': instance.positions,
      'queryID': instance.queryID,
      'userToken': instance.userToken,
      if (instance.authenticatedUserToken case final value?)
        'authenticatedUserToken': value,
      if (instance.timestamp case final value?) 'timestamp': value,
    };

const _$ClickEventEnumMap = {
  ClickEvent.click: 'click',
};
