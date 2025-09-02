// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'purchased_object_ids.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PurchasedObjectIDs _$PurchasedObjectIDsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'PurchasedObjectIDs',
      json,
      ($checkedConvert) {
        final val = PurchasedObjectIDs(
          eventName: $checkedConvert('eventName', (v) => v as String),
          eventType: $checkedConvert(
              'eventType', (v) => $enumDecode(_$ConversionEventEnumMap, v)),
          eventSubtype: $checkedConvert(
              'eventSubtype', (v) => $enumDecode(_$PurchaseEventEnumMap, v)),
          index: $checkedConvert('index', (v) => v as String),
          objectIDs: $checkedConvert('objectIDs',
              (v) => (v as List<dynamic>).map((e) => e as String).toList()),
          userToken: $checkedConvert('userToken', (v) => v as String),
          authenticatedUserToken:
              $checkedConvert('authenticatedUserToken', (v) => v as String?),
          currency: $checkedConvert('currency', (v) => v as String?),
          objectData: $checkedConvert(
              'objectData',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => ObjectData.fromJson(e as Map<String, dynamic>))
                  .toList()),
          timestamp: $checkedConvert('timestamp', (v) => (v as num?)?.toInt()),
          value: $checkedConvert('value', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$PurchasedObjectIDsToJson(PurchasedObjectIDs instance) {
  final val = <String, dynamic>{
    'eventName': instance.eventName,
    'eventType': instance.eventType.toJson(),
    'eventSubtype': instance.eventSubtype.toJson(),
    'index': instance.index,
    'objectIDs': instance.objectIDs,
    'userToken': instance.userToken,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('authenticatedUserToken', instance.authenticatedUserToken);
  writeNotNull('currency', instance.currency);
  writeNotNull(
      'objectData', instance.objectData?.map((e) => e.toJson()).toList());
  writeNotNull('timestamp', instance.timestamp);
  writeNotNull('value', instance.value);
  return val;
}

const _$ConversionEventEnumMap = {
  ConversionEvent.conversion: 'conversion',
};

const _$PurchaseEventEnumMap = {
  PurchaseEvent.purchase: 'purchase',
};
