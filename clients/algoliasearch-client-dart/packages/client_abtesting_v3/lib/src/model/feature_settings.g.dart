// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'feature_settings.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

FeatureSettings _$FeatureSettingsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'FeatureSettings',
      json,
      ($checkedConvert) {
        final val = FeatureSettings(
          name: $checkedConvert('name', (v) => v as String),
          settings: $checkedConvert('settings', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$FeatureSettingsToJson(FeatureSettings instance) {
  final val = <String, dynamic>{
    'name': instance.name,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('settings', instance.settings);
  return val;
}
