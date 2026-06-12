// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'tool_invocation_part_v4.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ToolInvocationPartV4 _$ToolInvocationPartV4FromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ToolInvocationPartV4',
      json,
      ($checkedConvert) {
        final val = ToolInvocationPartV4(
          type: $checkedConvert('type', (v) => v as String?),
          toolInvocation: $checkedConvert('toolInvocation',
              (v) => ToolInvocationV4.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$ToolInvocationPartV4ToJson(
    ToolInvocationPartV4 instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('type', instance.type);
  val['toolInvocation'] = instance.toolInvocation.toJson();
  return val;
}
