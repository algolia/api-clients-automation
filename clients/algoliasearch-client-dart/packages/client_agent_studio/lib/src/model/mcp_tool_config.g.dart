// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'mcp_tool_config.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

McpToolConfig _$McpToolConfigFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'McpToolConfig',
      json,
      ($checkedConvert) {
        final val = McpToolConfig(
          requiresApproval:
              $checkedConvert('requiresApproval', (v) => v as bool?),
          alias: $checkedConvert('alias', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$McpToolConfigToJson(McpToolConfig instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('requiresApproval', instance.requiresApproval);
  writeNotNull('alias', instance.alias);
  return val;
}
