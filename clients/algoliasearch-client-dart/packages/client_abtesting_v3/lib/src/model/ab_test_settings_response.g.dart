// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'ab_test_settings_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ABTestSettingsResponse _$ABTestSettingsResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ABTestSettingsResponse',
      json,
      ($checkedConvert) {
        final val = ABTestSettingsResponse(
          abtestSettings: $checkedConvert(
              'abtestSettings',
              (v) => (v as List<dynamic>)
                  .map((e) =>
                      VariantSettings.fromJson(e as Map<String, dynamic>))
                  .toList()),
          controlIndexInUse:
              $checkedConvert('controlIndexInUse', (v) => v as bool),
        );
        return val;
      },
    );

Map<String, dynamic> _$ABTestSettingsResponseToJson(
        ABTestSettingsResponse instance) =>
    <String, dynamic>{
      'abtestSettings': instance.abtestSettings.map((e) => e.toJson()).toList(),
      'controlIndexInUse': instance.controlIndexInUse,
    };
