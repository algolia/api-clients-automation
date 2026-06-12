// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'user_data_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

UserDataResponse _$UserDataResponseFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'UserDataResponse',
      json,
      ($checkedConvert) {
        final val = UserDataResponse(
          conversations: $checkedConvert(
              'conversations',
              (v) => (v as List<dynamic>)
                  .map((e) => ConversationFullResponse.fromJson(
                      e as Map<String, dynamic>))
                  .toList()),
          memories: $checkedConvert(
              'memories',
              (v) => (v as List<dynamic>)
                  .map((e) => MemoryRecord.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$UserDataResponseToJson(UserDataResponse instance) =>
    <String, dynamic>{
      'conversations': instance.conversations.map((e) => e.toJson()).toList(),
      'memories': instance.memories.map((e) => e.toJson()).toList(),
    };
