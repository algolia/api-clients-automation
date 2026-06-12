// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'unknown_tool_config.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

UnknownToolConfig _$UnknownToolConfigFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'UnknownToolConfig',
      json,
      ($checkedConvert) {
        final val = UnknownToolConfig(
          name: $checkedConvert('name', (v) => v as String),
          type: $checkedConvert('type', (v) => v as String),
        );
        return val;
      },
    );

const _$UnknownToolConfigFieldMap = <String, String>{
  'name': 'name',
  'type': 'type',
};

Map<String, dynamic> _$UnknownToolConfigToJson(UnknownToolConfig instance) =>
    <String, dynamic>{
      'name': instance.name,
      'type': instance.type,
    };
