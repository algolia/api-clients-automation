// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'managed_provider_response_input.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ManagedProviderResponseInput _$ManagedProviderResponseInputFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ManagedProviderResponseInput',
      json,
      ($checkedConvert) {
        final val = ManagedProviderResponseInput(
          defaultModel: $checkedConvert('defaultModel', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$ManagedProviderResponseInputToJson(
    ManagedProviderResponseInput instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('defaultModel', instance.defaultModel);
  return val;
}
