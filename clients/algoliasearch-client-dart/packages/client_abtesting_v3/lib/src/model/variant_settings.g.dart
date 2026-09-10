// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'variant_settings.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

VariantSettings _$VariantSettingsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'VariantSettings',
      json,
      ($checkedConvert) {
        final val = VariantSettings(
          variantId: $checkedConvert('variantId', (v) => (v as num).toInt()),
          applied: $checkedConvert('applied', (v) => v as bool),
          featuresSettings: $checkedConvert(
              'featuresSettings',
              (v) => (v as List<dynamic>?)
                  ?.map((e) =>
                      FeatureSettings.fromJson(e as Map<String, dynamic>))
                  .toList()),
          indexSettings: $checkedConvert('indexSettings', (v) => v),
          applyTimestamp:
              $checkedConvert('applyTimestamp', (v) => v as String?),
          revertTimestamp:
              $checkedConvert('revertTimestamp', (v) => v as String?),
          declaredTimestamp:
              $checkedConvert('declaredTimestamp', (v) => v as String?),
          expiredTimestamp:
              $checkedConvert('expiredTimestamp', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$VariantSettingsToJson(VariantSettings instance) {
  final val = <String, dynamic>{
    'variantId': instance.variantId,
    'applied': instance.applied,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('featuresSettings',
      instance.featuresSettings?.map((e) => e.toJson()).toList());
  writeNotNull('indexSettings', instance.indexSettings);
  writeNotNull('applyTimestamp', instance.applyTimestamp);
  writeNotNull('revertTimestamp', instance.revertTimestamp);
  writeNotNull('declaredTimestamp', instance.declaredTimestamp);
  writeNotNull('expiredTimestamp', instance.expiredTimestamp);
  return val;
}
