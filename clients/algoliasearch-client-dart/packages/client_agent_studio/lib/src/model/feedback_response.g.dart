// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'feedback_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

FeedbackResponse _$FeedbackResponseFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'FeedbackResponse',
      json,
      ($checkedConvert) {
        final val = FeedbackResponse(
          id: $checkedConvert('id', (v) => v as String),
          agentId: $checkedConvert('agentId', (v) => v as String),
          messageId: $checkedConvert('messageId', (v) => v as String),
          vote: $checkedConvert('vote', (v) => (v as num).toInt()),
          tags: $checkedConvert('tags',
              (v) => (v as List<dynamic>).map((e) => e as String).toList()),
          notes: $checkedConvert('notes', (v) => v as String?),
          model: $checkedConvert('model', (v) => v as String?),
          createdAt: $checkedConvert('createdAt', (v) => v as String),
          updatedAt: $checkedConvert('updatedAt', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$FeedbackResponseToJson(FeedbackResponse instance) {
  final val = <String, dynamic>{
    'id': instance.id,
    'agentId': instance.agentId,
    'messageId': instance.messageId,
    'vote': instance.vote,
    'tags': instance.tags,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('notes', instance.notes);
  writeNotNull('model', instance.model);
  val['createdAt'] = instance.createdAt;
  val['updatedAt'] = instance.updatedAt;
  return val;
}
