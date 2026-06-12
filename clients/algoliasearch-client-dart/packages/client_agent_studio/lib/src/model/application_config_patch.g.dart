// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'application_config_patch.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ApplicationConfigPatch _$ApplicationConfigPatchFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ApplicationConfigPatch',
      json,
      ($checkedConvert) {
        final val = ApplicationConfigPatch(
          maxRetentionDays:
              $checkedConvert('maxRetentionDays', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$ApplicationConfigPatchToJson(
    ApplicationConfigPatch instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('maxRetentionDays', instance.maxRetentionDays);
  return val;
}
