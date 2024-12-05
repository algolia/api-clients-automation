// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'clicked_filters.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ClickedFilters _$ClickedFiltersFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ClickedFilters',
      json,
      ($checkedConvert) {
        final val = ClickedFilters(
          eventName: $checkedConvert('eventName', (v) => v as String),
          eventType: $checkedConvert(
              'eventType', (v) => $enumDecode(_$ClickEventEnumMap, v)),
          index: $checkedConvert('index', (v) => v as String),
          filters: $checkedConvert('filters',
              (v) => (v as List<dynamic>).map((e) => e as String).toList()),
          userToken: $checkedConvert('userToken', (v) => v as String),
          authenticatedUserToken:
              $checkedConvert('authenticatedUserToken', (v) => v as String?),
          timestamp: $checkedConvert('timestamp', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$ClickedFiltersToJson(ClickedFilters instance) =>
    <String, dynamic>{
      'eventName': instance.eventName,
      'eventType': instance.eventType.toJson(),
      'index': instance.index,
      'filters': instance.filters,
      'userToken': instance.userToken,
      if (instance.authenticatedUserToken case final value?)
        'authenticatedUserToken': value,
      if (instance.timestamp case final value?) 'timestamp': value,
    };

const _$ClickEventEnumMap = {
  ClickEvent.click: 'click',
};
