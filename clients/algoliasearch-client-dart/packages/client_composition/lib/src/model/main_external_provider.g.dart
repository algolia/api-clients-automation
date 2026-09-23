// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'main_external_provider.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MainExternalProvider _$MainExternalProviderFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'MainExternalProvider',
      json,
      ($checkedConvert) {
        final val = MainExternalProvider(
          index: $checkedConvert('index', (v) => v as String),
          configurationID:
              $checkedConvert('configurationID', (v) => v as String),
          configurationParams: $checkedConvert(
              'configurationParams',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
          params: $checkedConvert(
              'params',
              (v) => v == null
                  ? null
                  : MainInjectionQueryParameters.fromJson(
                      v as Map<String, dynamic>)),
          ordering: $checkedConvert('ordering',
              (v) => $enumDecodeNullable(_$ExternalProviderOrderingEnumMap, v)),
        );
        return val;
      },
    );

Map<String, dynamic> _$MainExternalProviderToJson(
    MainExternalProvider instance) {
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
  writeNotNull('params', instance.params?.toJson());
  writeNotNull('ordering', instance.ordering?.toJson());
  return val;
}

const _$ExternalProviderOrderingEnumMap = {
  ExternalProviderOrdering.default_: 'default',
  ExternalProviderOrdering.providerDefined: 'providerDefined',
};
