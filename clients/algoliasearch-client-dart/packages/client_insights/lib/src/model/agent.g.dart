// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'agent.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Agent _$AgentFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Agent',
      json,
      ($checkedConvert) {
        final val = Agent(
          agentID: $checkedConvert('agentID', (v) => v as String?),
          messageID: $checkedConvert('messageID', (v) => v as String),
          toolCallID: $checkedConvert('toolCallID', (v) => v as String?),
          conversationID:
              $checkedConvert('conversationID', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$AgentToJson(Agent instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('agentID', instance.agentID);
  val['messageID'] = instance.messageID;
  writeNotNull('toolCallID', instance.toolCallID);
  writeNotNull('conversationID', instance.conversationID);
  return val;
}
