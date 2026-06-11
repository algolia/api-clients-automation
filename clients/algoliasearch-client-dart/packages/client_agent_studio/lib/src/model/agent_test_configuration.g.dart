// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'agent_test_configuration.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AgentTestConfiguration _$AgentTestConfigurationFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AgentTestConfiguration',
      json,
      ($checkedConvert) {
        final val = AgentTestConfiguration(
          id: $checkedConvert('id', (v) => v as String?),
          providerId: $checkedConvert('providerId', (v) => v as String?),
          model: $checkedConvert('model', (v) => v as String?),
          instructions: $checkedConvert('instructions', (v) => v as String),
          systemPrompt: $checkedConvert('systemPrompt', (v) => v as String?),
          config: $checkedConvert(
              'config',
              (v) => (v as Map<String, dynamic>).map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
          tools: $checkedConvert('tools', (v) => v as List<dynamic>),
        );
        return val;
      },
    );

Map<String, dynamic> _$AgentTestConfigurationToJson(
    AgentTestConfiguration instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('id', instance.id);
  writeNotNull('providerId', instance.providerId);
  writeNotNull('model', instance.model);
  val['instructions'] = instance.instructions;
  writeNotNull('systemPrompt', instance.systemPrompt);
  val['config'] = instance.config;
  val['tools'] = instance.tools.toList();
  return val;
}
