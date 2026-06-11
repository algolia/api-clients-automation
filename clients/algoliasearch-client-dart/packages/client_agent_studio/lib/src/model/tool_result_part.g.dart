// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'tool_result_part.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ToolResultPart _$ToolResultPartFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ToolResultPart',
      json,
      ($checkedConvert) {
        final val = ToolResultPart(
          type: $checkedConvert('type', (v) => v as String),
          toolCallId: $checkedConvert('toolCallId', (v) => v as String),
          toolName: $checkedConvert('toolName', (v) => v as String),
          output: $checkedConvert('output',
              (v) => ToolResultOutput.fromJson(v as Map<String, dynamic>)),
          providerOptions: $checkedConvert(
              'providerOptions',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$ToolResultPartToJson(ToolResultPart instance) {
  final val = <String, dynamic>{
    'type': instance.type,
    'toolCallId': instance.toolCallId,
    'toolName': instance.toolName,
    'output': instance.output.toJson(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('providerOptions', instance.providerOptions);
  return val;
}
