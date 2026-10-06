// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'tool_approval_agui.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ToolApprovalAGUI _$ToolApprovalAGUIFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ToolApprovalAGUI',
      json,
      ($checkedConvert) {
        final val = ToolApprovalAGUI(
          id: $checkedConvert('id', (v) => v as String),
          needsApproval: $checkedConvert('needsApproval', (v) => v as bool),
          approved: $checkedConvert('approved', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$ToolApprovalAGUIToJson(ToolApprovalAGUI instance) {
  final val = <String, dynamic>{
    'id': instance.id,
    'needsApproval': instance.needsApproval,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('approved', instance.approved);
  return val;
}
