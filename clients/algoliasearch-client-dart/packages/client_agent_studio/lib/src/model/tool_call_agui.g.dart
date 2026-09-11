// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'tool_call_agui.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ToolCallAGUI _$ToolCallAGUIFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ToolCallAGUI',
      json,
      ($checkedConvert) {
        final val = ToolCallAGUI(
          id: $checkedConvert('id', (v) => v as String),
          type: $checkedConvert('type', (v) => v as String?),
          function_: $checkedConvert('function',
              (v) => FunctionCallAGUI.fromJson(v as Map<String, dynamic>)),
          encryptedValue:
              $checkedConvert('encryptedValue', (v) => v as String?),
        );
        return val;
      },
      fieldKeyMap: const {'function_': 'function'},
    );

Map<String, dynamic> _$ToolCallAGUIToJson(ToolCallAGUI instance) {
  final val = <String, dynamic>{
    'id': instance.id,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('type', instance.type);
  val['function'] = instance.function_.toJson();
  writeNotNull('encryptedValue', instance.encryptedValue);
  return val;
}
