// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'agent_completion_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AgentCompletionRequest _$AgentCompletionRequestFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AgentCompletionRequest',
      json,
      ($checkedConvert) {
        final val = AgentCompletionRequest(
          configuration: $checkedConvert(
              'configuration',
              (v) => v == null
                  ? null
                  : AgentTestConfiguration.fromJson(v as Map<String, dynamic>)),
          messages: $checkedConvert('messages', (v) => v),
          id: $checkedConvert('id', (v) => v as String?),
          algolia: $checkedConvert(
              'algolia',
              (v) => v == null
                  ? null
                  : AgentCompletionAlgoliaParams.fromJson(
                      v as Map<String, dynamic>)),
          toolApprovals: $checkedConvert('toolApprovals', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$AgentCompletionRequestToJson(
    AgentCompletionRequest instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('configuration', instance.configuration?.toJson());
  writeNotNull('messages', instance.messages);
  writeNotNull('id', instance.id);
  writeNotNull('algolia', instance.algolia?.toJson());
  writeNotNull('toolApprovals', instance.toolApprovals);
  return val;
}
