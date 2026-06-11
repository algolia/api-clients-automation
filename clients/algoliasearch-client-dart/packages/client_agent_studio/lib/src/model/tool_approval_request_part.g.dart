// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'tool_approval_request_part.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ToolApprovalRequestPart _$ToolApprovalRequestPartFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ToolApprovalRequestPart',
      json,
      ($checkedConvert) {
        final val = ToolApprovalRequestPart(
          type: $checkedConvert('type', (v) => v as String),
          toolCallId: $checkedConvert('toolCallId', (v) => v as String),
          toolName: $checkedConvert('toolName', (v) => v as String),
          args: $checkedConvert('args', (v) => v),
          description: $checkedConvert('description', (v) => v as String?),
          providerOptions: $checkedConvert(
              'providerOptions',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
          argsHash: $checkedConvert('argsHash', (v) => v as String?),
          appId: $checkedConvert('appId', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$ToolApprovalRequestPartToJson(
    ToolApprovalRequestPart instance) {
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
  writeNotNull('description', instance.description);
  writeNotNull('providerOptions', instance.providerOptions);
  writeNotNull('argsHash', instance.argsHash);
  writeNotNull('appId', instance.appId);
  return val;
}
