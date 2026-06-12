// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'tool_call_part.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ToolCallPart _$ToolCallPartFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ToolCallPart',
      json,
      ($checkedConvert) {
        final val = ToolCallPart(
          type: $checkedConvert('type', (v) => v as String),
          toolCallId: $checkedConvert('toolCallId', (v) => v as String),
          toolName: $checkedConvert('toolName', (v) => v as String),
          args: $checkedConvert('args', (v) => v),
          requiresApproval:
              $checkedConvert('requiresApproval', (v) => v as bool?),
          providerOptions: $checkedConvert(
              'providerOptions',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$ToolCallPartToJson(ToolCallPart instance) {
  final val = <String, dynamic>{
    'type': instance.type,
    'toolCallId': instance.toolCallId,
    'toolName': instance.toolName,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('args', instance.args);
  writeNotNull('requiresApproval', instance.requiresApproval);
  writeNotNull('providerOptions', instance.providerOptions);
  return val;
}
