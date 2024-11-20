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
        AddedToCartObjectIDsAfterSearch instance) =>
    <String, dynamic>{
      'eventName': instance.eventName,
      'eventType': instance.eventType.toJson(),
      'eventSubtype': instance.eventSubtype.toJson(),
      'index': instance.index,
      'queryID': instance.queryID,
      'objectIDs': instance.objectIDs,
      'userToken': instance.userToken,
      if (instance.authenticatedUserToken case final value?)
        'authenticatedUserToken': value,
      if (instance.currency case final value?) 'currency': value,
      if (instance.objectData?.map((e) => e.toJson()).toList()
          case final value?)
        'objectData': value,
      if (instance.timestamp case final value?) 'timestamp': value,
      if (instance.value case final value?) 'value': value,
    };

const _$ConversionEventEnumMap = {
  ConversionEvent.conversion: 'conversion',
};

const _$AddToCartEventEnumMap = {
  AddToCartEvent.addToCart: 'addToCart',
};
