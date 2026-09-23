// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'injected_item_external_provider.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

InjectedItemExternalProvider _$InjectedItemExternalProviderFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'InjectedItemExternalProvider',
      json,
      ($checkedConvert) {
        final val = InjectedItemExternalProvider(
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
                  : BaseInjectionQueryParameters.fromJson(
                      v as Map<String, dynamic>)),
          ordering: $checkedConvert('ordering',
              (v) => $enumDecodeNullable(_$ExternalProviderOrderingEnumMap, v)),
        );
        return val;
      },
    );

Map<String, dynamic> _$InjectedItemExternalProviderToJson(
    InjectedItemExternalProvider instance) {
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
