// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'feedback_creation_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

FeedbackCreationRequest _$FeedbackCreationRequestFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'FeedbackCreationRequest',
      json,
      ($checkedConvert) {
        final val = FeedbackCreationRequest(
          messageId: $checkedConvert('messageId', (v) => v as String),
          agentId: $checkedConvert('agentId', (v) => v as String),
          vote:
              $checkedConvert('vote', (v) => $enumDecode(_$VoteEnumEnumMap, v)),
          tags: $checkedConvert('tags',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          notes: $checkedConvert('notes', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$FeedbackCreationRequestToJson(
    FeedbackCreationRequest instance) {
  final val = <String, dynamic>{
    'messageId': instance.messageId,
    'agentId': instance.agentId,
    'vote': instance.vote.toJson(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('tags', instance.tags);
  writeNotNull('notes', instance.notes);
  return val;
}

const _$VoteEnumEnumMap = {
  VoteEnum.downvote: 0,
  VoteEnum.upvote: 1,
};
