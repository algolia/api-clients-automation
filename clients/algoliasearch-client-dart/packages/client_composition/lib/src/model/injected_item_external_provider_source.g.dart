// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'injected_item_external_provider_source.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

InjectedItemExternalProviderSource _$InjectedItemExternalProviderSourceFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'InjectedItemExternalProviderSource',
      json,
      ($checkedConvert) {
        final val = InjectedItemExternalProviderSource(
          externalProvider: $checkedConvert(
              'externalProvider',
              (v) => InjectedItemExternalProvider.fromJson(
                  v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$InjectedItemExternalProviderSourceToJson(
        InjectedItemExternalProviderSource instance) =>
    <String, dynamic>{
      'externalProvider': instance.externalProvider.toJson(),
    };
