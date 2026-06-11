// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'agent_with_version_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AgentWithVersionResponse _$AgentWithVersionResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AgentWithVersionResponse',
      json,
      ($checkedConvert) {
        final val = AgentWithVersionResponse(
          id: $checkedConvert('id', (v) => v as String),
          name: $checkedConvert('name', (v) => v as String),
          description: $checkedConvert('description', (v) => v as String?),
          status: $checkedConvert(
              'status', (v) => $enumDecode(_$AgentStatusEnumMap, v)),
          providerId: $checkedConvert('providerId', (v) => v as String?),
          model: $checkedConvert('model', (v) => v as String?),
          instructions: $checkedConvert('instructions', (v) => v as String),
          systemPrompt: $checkedConvert('systemPrompt', (v) => v as String?),
          config: $checkedConvert(
              'config',
              (v) => (v as Map<String, dynamic>).map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
          tools: $checkedConvert('tools', (v) => v as List<dynamic>?),
          templateType: $checkedConvert('templateType', (v) => v as String?),
          createdAt: $checkedConvert('createdAt', (v) => v as String),
          updatedAt: $checkedConvert('updatedAt', (v) => v as String?),
          lastUsedAt: $checkedConvert('lastUsedAt', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$AgentWithVersionResponseToJson(
    AgentWithVersionResponse instance) {
  final val = <String, dynamic>{
    'id': instance.id,
    'name': instance.name,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('description', instance.description);
  val['status'] = instance.status.toJson();
  writeNotNull('providerId', instance.providerId);
  writeNotNull('model', instance.model);
  val['instructions'] = instance.instructions;
  writeNotNull('systemPrompt', instance.systemPrompt);
  val['config'] = instance.config;
  writeNotNull('tools', instance.tools?.toList());
  writeNotNull('templateType', instance.templateType);
  val['createdAt'] = instance.createdAt;
  writeNotNull('updatedAt', instance.updatedAt);
  writeNotNull('lastUsedAt', instance.lastUsedAt);
  return val;
}

const _$AgentStatusEnumMap = {
  AgentStatus.draft: 'draft',
  AgentStatus.published: 'published',
};
