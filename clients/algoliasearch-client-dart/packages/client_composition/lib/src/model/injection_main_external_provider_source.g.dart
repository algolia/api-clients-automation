// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'injection_main_external_provider_source.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

InjectionMainExternalProviderSource
    _$InjectionMainExternalProviderSourceFromJson(Map<String, dynamic> json) =>
        $checkedCreate(
          'InjectionMainExternalProviderSource',
          json,
          ($checkedConvert) {
            final val = InjectionMainExternalProviderSource(
              externalProvider: $checkedConvert(
                  'externalProvider',
                  (v) =>
                      MainExternalProvider.fromJson(v as Map<String, dynamic>)),
            );
            return val;
          },
        );

Map<String, dynamic> _$InjectionMainExternalProviderSourceToJson(
        InjectionMainExternalProviderSource instance) =>
    <String, dynamic>{
      'externalProvider': instance.externalProvider.toJson(),
    };
