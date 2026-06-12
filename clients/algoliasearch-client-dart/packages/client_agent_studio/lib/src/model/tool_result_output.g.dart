// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'tool_result_output.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ToolResultOutput _$ToolResultOutputFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ToolResultOutput',
      json,
      ($checkedConvert) {
        final val = ToolResultOutput(
          type: $checkedConvert(
              'type', (v) => $enumDecode(_$ToolResultOutputTypeEnumMap, v)),
          value: $checkedConvert('value', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$ToolResultOutputToJson(ToolResultOutput instance) {
  final val = <String, dynamic>{
    'type': instance.type.toJson(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('value', instance.value);
  return val;
}

const _$ToolResultOutputTypeEnumMap = {
  ToolResultOutputType.text: 'text',
  ToolResultOutputType.json: 'json',
  ToolResultOutputType.errorText: 'error-text',
  ToolResultOutputType.errorJson: 'error-json',
  ToolResultOutputType.content: 'content',
};
