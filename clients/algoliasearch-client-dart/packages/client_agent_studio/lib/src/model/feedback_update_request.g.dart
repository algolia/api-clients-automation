// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'feedback_update_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

FeedbackUpdateRequest _$FeedbackUpdateRequestFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'FeedbackUpdateRequest',
      json,
      ($checkedConvert) {
        final val = FeedbackUpdateRequest(
          messageId: $checkedConvert('messageId', (v) => v as String),
          agentId: $checkedConvert('agentId', (v) => v as String),
          vote: $checkedConvert(
              'vote', (v) => $enumDecodeNullable(_$OneOfEnumEnumMap, v)),
          tags: $checkedConvert('tags',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          notes: $checkedConvert('notes', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$FeedbackUpdateRequestToJson(
    FeedbackUpdateRequest instance) {
  final val = <String, dynamic>{
    'messageId': instance.messageId,
    'agentId': instance.agentId,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('vote', instance.vote?.toJson());
  writeNotNull('tags', instance.tags);
  writeNotNull('notes', instance.notes);
  return val;
}

const _$OneOfEnumEnumMap = {
  OneOfEnum.downvote: 0,
  OneOfEnum.upvote: 1,
};
