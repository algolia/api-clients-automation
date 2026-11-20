// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'conversation_usage_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ConversationUsageResponse _$ConversationUsageResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ConversationUsageResponse',
      json,
      ($checkedConvert) {
        final val = ConversationUsageResponse(
          liveConversations:
              $checkedConvert('liveConversations', (v) => (v as num).toInt()),
          limit: $checkedConvert('limit', (v) => (v as num).toInt()),
          atLimit: $checkedConvert('atLimit', (v) => v as bool),
        );
        return val;
      },
    );

Map<String, dynamic> _$ConversationUsageResponseToJson(
        ConversationUsageResponse instance) =>
    <String, dynamic>{
      'liveConversations': instance.liveConversations,
      'limit': instance.limit,
      'atLimit': instance.atLimit,
    };
