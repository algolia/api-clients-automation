// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'save_settings_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SaveSettingsRequest _$SaveSettingsRequestFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SaveSettingsRequest',
      json,
      ($checkedConvert) {
        final val = SaveSettingsRequest(
          saveFeaturesSettings:
              $checkedConvert('saveFeaturesSettings', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$SaveSettingsRequestToJson(SaveSettingsRequest instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('saveFeaturesSettings', instance.saveFeaturesSettings);
  return val;
}
