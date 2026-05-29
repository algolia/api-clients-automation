// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'injected_item_external_source.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

InjectedItemExternalSource _$InjectedItemExternalSourceFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'InjectedItemExternalSource',
      json,
      ($checkedConvert) {
        final val = InjectedItemExternalSource(
          external_: $checkedConvert('external',
              (v) => InjectedItemExternal.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
      fieldKeyMap: const {'external_': 'external'},
    );

Map<String, dynamic> _$InjectedItemExternalSourceToJson(
        InjectedItemExternalSource instance) =>
    <String, dynamic>{
      'external': instance.external_.toJson(),
    };
