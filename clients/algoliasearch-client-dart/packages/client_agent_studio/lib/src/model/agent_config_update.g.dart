// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'agent_config_update.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AgentConfigUpdate _$AgentConfigUpdateFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'AgentConfigUpdate',
      json,
      ($checkedConvert) {
        final val = AgentConfigUpdate(
          name: $checkedConvert('name', (v) => v as String?),
          description: $checkedConvert('description', (v) => v as String?),
          providerId: $checkedConvert('providerId', (v) => v as String?),
          model: $checkedConvert('model', (v) => v as String?),
          instructions: $checkedConvert('instructions', (v) => v as String?),
          systemPrompt: $checkedConvert('systemPrompt', (v) => v as String?),
          config: $checkedConvert(
              'config',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
          tools: $checkedConvert('tools', (v) => v as List<dynamic>?),
          templateType: $checkedConvert('templateType', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$AgentConfigUpdateToJson(AgentConfigUpdate instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('name', instance.name);
  writeNotNull('description', instance.description);
  writeNotNull('providerId', instance.providerId);
  writeNotNull('model', instance.model);
  writeNotNull('instructions', instance.instructions);
  writeNotNull('systemPrompt', instance.systemPrompt);
  writeNotNull('config', instance.config);
  writeNotNull('tools', instance.tools?.toList());
  writeNotNull('templateType', instance.templateType);
  return val;
}
