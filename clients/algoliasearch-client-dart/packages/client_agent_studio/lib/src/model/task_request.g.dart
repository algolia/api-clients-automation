// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'task_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TaskRequest _$TaskRequestFromJson(Map<String, dynamic> json) => $checkedCreate(
      'TaskRequest',
      json,
      ($checkedConvert) {
        final val = TaskRequest(
          task: $checkedConvert('task', (v) => v as String?),
          kind: $checkedConvert(
              'kind', (v) => $enumDecodeNullable(_$TaskKindEnumMap, v)),
          input: $checkedConvert(
              'input',
              (v) => (v as Map<String, dynamic>).map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
          configuration: $checkedConvert(
              'configuration',
              (v) => v == null
                  ? null
                  : AgentTestConfiguration.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$TaskRequestToJson(TaskRequest instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('task', instance.task);
  writeNotNull('kind', instance.kind?.toJson());
  val['input'] = instance.input;
  writeNotNull('configuration', instance.configuration?.toJson());
  return val;
}

const _$TaskKindEnumMap = {
  TaskKind.promptSuggestions: 'prompt_suggestions',
};
