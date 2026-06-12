// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'client_side_tool_config.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ClientSideToolConfig _$ClientSideToolConfigFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ClientSideToolConfig',
      json,
      ($checkedConvert) {
        final val = ClientSideToolConfig(
          name: $checkedConvert('name', (v) => v as String),
          type: $checkedConvert('type', (v) => v as String),
          description: $checkedConvert('description', (v) => v as String),
          inputSchema: $checkedConvert('inputSchema',
              (v) => ClientToolsArgsSchema.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$ClientSideToolConfigToJson(
        ClientSideToolConfig instance) =>
    <String, dynamic>{
      'name': instance.name,
      'type': instance.type,
      'description': instance.description,
      'inputSchema': instance.inputSchema.toJson(),
    };
