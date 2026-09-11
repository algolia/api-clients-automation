// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'function_call_agui.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

FunctionCallAGUI _$FunctionCallAGUIFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'FunctionCallAGUI',
      json,
      ($checkedConvert) {
        final val = FunctionCallAGUI(
          name: $checkedConvert('name', (v) => v as String),
          arguments: $checkedConvert('arguments', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$FunctionCallAGUIToJson(FunctionCallAGUI instance) =>
    <String, dynamic>{
      'name': instance.name,
      'arguments': instance.arguments,
    };
