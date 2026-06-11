// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'message_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MessageResponse _$MessageResponseFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'MessageResponse',
      json,
      ($checkedConvert) {
        final val = MessageResponse(
          id: $checkedConvert('id', (v) => v as String),
          conversationId: $checkedConvert('conversationId', (v) => v as String),
          role: $checkedConvert(
              'role', (v) => $enumDecode(_$MessageRoleEnumMap, v)),
          parts: $checkedConvert('parts', (v) => v as List<dynamic>),
          createdAt: $checkedConvert('createdAt', (v) => v as String),
          updatedAt: $checkedConvert('updatedAt', (v) => v as String),
          model: $checkedConvert('model', (v) => v as String?),
          inputTokens:
              $checkedConvert('inputTokens', (v) => (v as num?)?.toInt()),
          outputTokens:
              $checkedConvert('outputTokens', (v) => (v as num?)?.toInt()),
          turnContext: $checkedConvert(
              'turnContext',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as String),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$MessageResponseToJson(MessageResponse instance) {
  final val = <String, dynamic>{
    'id': instance.id,
    'conversationId': instance.conversationId,
    'role': instance.role.toJson(),
    'parts': instance.parts.toList(),
    'createdAt': instance.createdAt,
    'updatedAt': instance.updatedAt,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('model', instance.model);
  writeNotNull('inputTokens', instance.inputTokens);
  writeNotNull('outputTokens', instance.outputTokens);
  writeNotNull('turnContext', instance.turnContext);
  return val;
}

const _$MessageRoleEnumMap = {
  MessageRole.user: 'user',
  MessageRole.assistant: 'assistant',
};
