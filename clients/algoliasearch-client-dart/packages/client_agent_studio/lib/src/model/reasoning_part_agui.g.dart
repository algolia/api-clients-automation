// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'reasoning_part_agui.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ReasoningPartAGUI _$ReasoningPartAGUIFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ReasoningPartAGUI',
      json,
      ($checkedConvert) {
        final val = ReasoningPartAGUI(
          type: $checkedConvert('type', (v) => v as String),
          content: $checkedConvert('content', (v) => v as String),
          stepId: $checkedConvert('stepId', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$ReasoningPartAGUIToJson(ReasoningPartAGUI instance) {
  final val = <String, dynamic>{
    'type': instance.type,
    'content': instance.content,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('stepId', instance.stepId);
  return val;
}
