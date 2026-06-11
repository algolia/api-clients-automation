// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'application_config_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ApplicationConfigResponse _$ApplicationConfigResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ApplicationConfigResponse',
      json,
      ($checkedConvert) {
        final val = ApplicationConfigResponse(
          maxRetentionDays:
              $checkedConvert('maxRetentionDays', (v) => (v as num).toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$ApplicationConfigResponseToJson(
        ApplicationConfigResponse instance) =>
    <String, dynamic>{
      'maxRetentionDays': instance.maxRetentionDays,
    };
