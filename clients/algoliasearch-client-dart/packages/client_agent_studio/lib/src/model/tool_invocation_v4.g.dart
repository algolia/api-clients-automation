// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'tool_invocation_v4.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ToolInvocationV4 _$ToolInvocationV4FromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ToolInvocationV4',
      json,
      ($checkedConvert) {
        final val = ToolInvocationV4(
          toolCallId: $checkedConvert('toolCallId', (v) => v as String),
          toolName: $checkedConvert('toolName', (v) => v as String),
          args: $checkedConvert(
              'args',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
          result: $checkedConvert(
              'result',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
          step: $checkedConvert('step', (v) => (v as num?)?.toInt()),
          state: $checkedConvert('state', (v) => v as String?),
          providerOptions: $checkedConvert(
              'providerOptions',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
          requiresApproval:
              $checkedConvert('requiresApproval', (v) => v as bool?),
          description: $checkedConvert('description', (v) => v as String?),
          argsHash: $checkedConvert('argsHash', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$ToolInvocationV4ToJson(ToolInvocationV4 instance) {
  final val = <String, dynamic>{
    'toolCallId': instance.toolCallId,
    'toolName': instance.toolName,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('args', instance.args);
  writeNotNull('result', instance.result);
  writeNotNull('step', instance.step);
  writeNotNull('state', instance.state);
  writeNotNull('providerOptions', instance.providerOptions);
  writeNotNull('requiresApproval', instance.requiresApproval);
  writeNotNull('description', instance.description);
  writeNotNull('argsHash', instance.argsHash);
  return val;
}
