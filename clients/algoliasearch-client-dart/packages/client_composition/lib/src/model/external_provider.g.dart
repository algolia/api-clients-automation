// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'external_provider.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ExternalProvider _$ExternalProviderFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ExternalProvider',
      json,
      ($checkedConvert) {
        final val = ExternalProvider(
          configurationParams: $checkedConvert(
              'configurationParams',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$ExternalProviderToJson(ExternalProvider instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('configurationParams', instance.configurationParams);
  return val;
}
