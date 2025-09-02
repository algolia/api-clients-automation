// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'added_to_cart_object_ids_after_search.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AddedToCartObjectIDsAfterSearch _$AddedToCartObjectIDsAfterSearchFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AddedToCartObjectIDsAfterSearch',
      json,
      ($checkedConvert) {
        final val = AddedToCartObjectIDsAfterSearch(
          eventName: $checkedConvert('eventName', (v) => v as String),
          eventType: $checkedConvert(
              'eventType', (v) => $enumDecode(_$ConversionEventEnumMap, v)),
          eventSubtype: $checkedConvert(
              'eventSubtype', (v) => $enumDecode(_$AddToCartEventEnumMap, v)),
          index: $checkedConvert('index', (v) => v as String),
          queryID: $checkedConvert('queryID', (v) => v as String),
          objectIDs: $checkedConvert('objectIDs',
              (v) => (v as List<dynamic>).map((e) => e as String).toList()),
          userToken: $checkedConvert('userToken', (v) => v as String),
          authenticatedUserToken:
              $checkedConvert('authenticatedUserToken', (v) => v as String?),
          currency: $checkedConvert('currency', (v) => v as String?),
          objectData: $checkedConvert(
              'objectData',
              (v) => (v as List<dynamic>?)
                  ?.map((e) =>
                      ObjectDataAfterSearch.fromJson(e as Map<String, dynamic>))
                  .toList()),
          timestamp: $checkedConvert('timestamp', (v) => (v as num?)?.toInt()),
          value: $checkedConvert('value', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$AddedToCartObjectIDsAfterSearchToJson(
    AddedToCartObjectIDsAfterSearch instance) {
  final val = <String, dynamic>{
    'eventName': instance.eventName,
    'eventType': instance.eventType.toJson(),
    'eventSubtype': instance.eventSubtype.toJson(),
    'index': instance.index,
    'queryID': instance.queryID,
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

const _$AddToCartEventEnumMap = {
  AddToCartEvent.addToCart: 'addToCart',
};
