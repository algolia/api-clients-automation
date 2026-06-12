// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'agent_config_create.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AgentConfigCreate _$AgentConfigCreateFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'AgentConfigCreate',
      json,
      ($checkedConvert) {
        final val = AgentConfigCreate(
          name: $checkedConvert('name', (v) => v as String),
          description: $checkedConvert('description', (v) => v as String?),
          providerId: $checkedConvert('providerId', (v) => v as String?),
          model: $checkedConvert('model', (v) => v as String?),
          instructions: $checkedConvert('instructions', (v) => v as String),
          systemPrompt: $checkedConvert('systemPrompt', (v) => v as String?),
          templateType: $checkedConvert('templateType', (v) => v as String?),
          config: $checkedConvert(
              'config',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
          tools: $checkedConvert('tools', (v) => v as List<dynamic>?),
        );
        return val;
      },
    );

Map<String, dynamic> _$AgentConfigCreateToJson(AgentConfigCreate instance) {
  final val = <String, dynamic>{
    'name': instance.name,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('description', instance.description);
  writeNotNull('providerId', instance.providerId);
  writeNotNull('model', instance.model);
  val['instructions'] = instance.instructions;
  writeNotNull('systemPrompt', instance.systemPrompt);
  writeNotNull('templateType', instance.templateType);
  writeNotNull('config', instance.config);
  writeNotNull('tools', instance.tools?.toList());
  return val;
}
