// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'mcp_server_tool_config.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

McpServerToolConfig _$McpServerToolConfigFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'McpServerToolConfig',
      json,
      ($checkedConvert) {
        final val = McpServerToolConfig(
          url: $checkedConvert('url', (v) => v as String),
          transport: $checkedConvert('transport', (v) => v as String?),
          headers: $checkedConvert(
              'headers', (v) => Map<String, String>.from(v as Map)),
          name: $checkedConvert('name', (v) => v as String),
          type: $checkedConvert('type', (v) => v as String),
          id: $checkedConvert('id', (v) => v as String?),
          allowedTools: $checkedConvert(
              'allowedTools', (v) => v as Map<String, dynamic>?),
        );
        return val;
      },
    );

Map<String, dynamic> _$McpServerToolConfigToJson(McpServerToolConfig instance) {
  final val = <String, dynamic>{
    'url': instance.url,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('transport', instance.transport);
  val['headers'] = instance.headers;
  val['name'] = instance.name;
  val['type'] = instance.type;
  writeNotNull('id', instance.id);
  writeNotNull('allowedTools', instance.allowedTools);
  return val;
}
