// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'conversation_full_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ConversationFullResponse _$ConversationFullResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ConversationFullResponse',
      json,
      ($checkedConvert) {
        final val = ConversationFullResponse(
          id: $checkedConvert('id', (v) => v as String),
          agentId: $checkedConvert('agentId', (v) => v as String),
          title: $checkedConvert('title', (v) => v as String?),
          createdAt: $checkedConvert('createdAt', (v) => v as String),
          updatedAt: $checkedConvert('updatedAt', (v) => v as String),
          lastActivityAt:
              $checkedConvert('lastActivityAt', (v) => v as String?),
          userToken: $checkedConvert('userToken', (v) => v as String?),
          isFromDashboard:
              $checkedConvert('isFromDashboard', (v) => v as bool?),
          messageCount:
              $checkedConvert('messageCount', (v) => (v as num?)?.toInt()),
          totalInputTokens:
              $checkedConvert('totalInputTokens', (v) => (v as num?)?.toInt()),
          totalOutputTokens:
              $checkedConvert('totalOutputTokens', (v) => (v as num?)?.toInt()),
          totalTokens:
              $checkedConvert('totalTokens', (v) => (v as num?)?.toInt()),
          conversationMetadata: $checkedConvert(
              'conversationMetadata',
              (v) => v == null
                  ? null
                  : ConversationMetadata.fromJson(v as Map<String, dynamic>)),
          feedback: $checkedConvert(
              'feedback',
              (v) => (v as List<dynamic>?)
                  ?.map((e) =>
                      FeedbackResponse.fromJson(e as Map<String, dynamic>))
                  .toList()),
          messages: $checkedConvert(
              'messages',
              (v) => (v as List<dynamic>)
                  .map((e) =>
                      MessageResponse.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$ConversationFullResponseToJson(
    ConversationFullResponse instance) {
  final val = <String, dynamic>{
    'id': instance.id,
    'agentId': instance.agentId,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('title', instance.title);
  val['createdAt'] = instance.createdAt;
  val['updatedAt'] = instance.updatedAt;
  writeNotNull('lastActivityAt', instance.lastActivityAt);
  writeNotNull('userToken', instance.userToken);
  writeNotNull('isFromDashboard', instance.isFromDashboard);
  writeNotNull('messageCount', instance.messageCount);
  writeNotNull('totalInputTokens', instance.totalInputTokens);
  writeNotNull('totalOutputTokens', instance.totalOutputTokens);
  writeNotNull('totalTokens', instance.totalTokens);
  writeNotNull('conversationMetadata', instance.conversationMetadata?.toJson());
  writeNotNull('feedback', instance.feedback?.map((e) => e.toJson()).toList());
  val['messages'] = instance.messages.map((e) => e.toJson()).toList();
  return val;
}
