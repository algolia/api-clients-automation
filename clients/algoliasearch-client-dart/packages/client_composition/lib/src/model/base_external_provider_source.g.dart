// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'base_external_provider_source.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BaseExternalProviderSource _$BaseExternalProviderSourceFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'BaseExternalProviderSource',
      json,
      ($checkedConvert) {
        final val = BaseExternalProviderSource(
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
        );
        return val;
      },
    );

Map<String, dynamic> _$BaseExternalProviderSourceToJson(
    BaseExternalProviderSource instance) {
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
  return val;
}

const _$ExternalProviderOrderingEnumMap = {
  ExternalProviderOrdering.default_: 'default',
  ExternalProviderOrdering.providerDefined: 'providerDefined',
};
