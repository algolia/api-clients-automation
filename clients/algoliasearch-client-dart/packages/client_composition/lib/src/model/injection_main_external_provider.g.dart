// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'injection_main_external_provider.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

InjectionMainExternalProvider _$InjectionMainExternalProviderFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'InjectionMainExternalProvider',
      json,
      ($checkedConvert) {
        final val = InjectionMainExternalProvider(
          index: $checkedConvert('index', (v) => v as String),
          configurationID:
              $checkedConvert('configurationID', (v) => v as String),
          configurationParams: $checkedConvert(
              'configurationParams',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
          ordering: $checkedConvert('ordering',
              (v) => $enumDecodeNullable(_$ExternalProviderOrderingEnumMap, v)),
          params: $checkedConvert(
              'params',
              (v) => v == null
                  ? null
                  : MainInjectionQueryParameters.fromJson(
                      v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$InjectionMainExternalProviderToJson(
    InjectionMainExternalProvider instance) {
  final val = <String, dynamic>{
    'index': instance.index,
    'configurationID': instance.configurationID,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('configurationParams', instance.configurationParams);
  writeNotNull('ordering', instance.ordering?.toJson());
  writeNotNull('params', instance.params?.toJson());
  return val;
}

const _$ExternalProviderOrderingEnumMap = {
  ExternalProviderOrdering.default_: 'default',
  ExternalProviderOrdering.providerDefined: 'providerDefined',
};
