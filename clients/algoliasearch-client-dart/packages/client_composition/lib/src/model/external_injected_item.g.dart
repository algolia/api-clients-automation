// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'external_injected_item.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ExternalInjectedItem _$ExternalInjectedItemFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ExternalInjectedItem',
      json,
      ($checkedConvert) {
        final val = ExternalInjectedItem(
          items: $checkedConvert(
              'items',
              (v) => (v as List<dynamic>)
                  .map((e) =>
                      ExternalInjection.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$ExternalInjectedItemToJson(
        ExternalInjectedItem instance) =>
    <String, dynamic>{
      'items': instance.items.map((e) => e.toJson()).toList(),
    };
