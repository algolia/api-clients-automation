// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'provider_authentication_patch.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ProviderAuthenticationPatch _$ProviderAuthenticationPatchFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ProviderAuthenticationPatch',
      json,
      ($checkedConvert) {
        final val = ProviderAuthenticationPatch(
          name: $checkedConvert('name', (v) => v as String?),
          input: $checkedConvert('input', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$ProviderAuthenticationPatchToJson(
    ProviderAuthenticationPatch instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('name', instance.name);
  writeNotNull('input', instance.input);
  return val;
}
