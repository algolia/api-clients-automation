// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'tool_part_v5.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ToolPartV5 _$ToolPartV5FromJson(Map<String, dynamic> json) => $checkedCreate(
      'ToolPartV5',
      json,
      ($checkedConvert) {
        final val = ToolPartV5(
          type: $checkedConvert('type', (v) => v as String),
          toolCallId: $checkedConvert('toolCallId', (v) => v as String),
          state: $checkedConvert(
              'state', (v) => $enumDecodeNullable(_$ToolStateEnumMap, v)),
          input: $checkedConvert(
              'input',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
          output: $checkedConvert(
              'output',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
          errorText: $checkedConvert('errorText', (v) => v as String?),
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

Map<String, dynamic> _$ToolPartV5ToJson(ToolPartV5 instance) {
  final val = <String, dynamic>{
    'type': instance.type,
    'toolCallId': instance.toolCallId,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('state', instance.state?.toJson());
  writeNotNull('input', instance.input);
  writeNotNull('output', instance.output);
  writeNotNull('errorText', instance.errorText);
  writeNotNull('providerOptions', instance.providerOptions);
  writeNotNull('requiresApproval', instance.requiresApproval);
  writeNotNull('description', instance.description);
  writeNotNull('argsHash', instance.argsHash);
  return val;
}

const _$ToolStateEnumMap = {
  ToolState.inputStreaming: 'input-streaming',
  ToolState.inputAvailable: 'input-available',
  ToolState.outputAvailable: 'output-available',
  ToolState.outputError: 'output-error',
};
