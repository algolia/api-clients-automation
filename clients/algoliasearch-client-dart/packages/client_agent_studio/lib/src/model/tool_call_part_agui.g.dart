// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'tool_call_part_agui.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ToolCallPartAGUI _$ToolCallPartAGUIFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ToolCallPartAGUI',
      json,
      ($checkedConvert) {
        final val = ToolCallPartAGUI(
          id: $checkedConvert('id', (v) => v as String),
          type: $checkedConvert('type', (v) => v as String),
          name: $checkedConvert('name', (v) => v as String),
          arguments: $checkedConvert('arguments', (v) => v as String),
          state: $checkedConvert('state', (v) => v as String),
          output: $checkedConvert(
              'output',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
          approval: $checkedConvert(
              'approval',
              (v) => v == null
                  ? null
                  : ToolApprovalAGUI.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$ToolCallPartAGUIToJson(ToolCallPartAGUI instance) {
  final val = <String, dynamic>{
    'id': instance.id,
    'type': instance.type,
    'name': instance.name,
    'arguments': instance.arguments,
    'state': instance.state,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('output', instance.output);
  writeNotNull('approval', instance.approval?.toJson());
  return val;
}
