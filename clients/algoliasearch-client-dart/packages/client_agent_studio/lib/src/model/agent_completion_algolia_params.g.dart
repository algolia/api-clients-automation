// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'agent_completion_algolia_params.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AgentCompletionAlgoliaParams _$AgentCompletionAlgoliaParamsFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AgentCompletionAlgoliaParams',
      json,
      ($checkedConvert) {
        final val = AgentCompletionAlgoliaParams(
          mcpServers: $checkedConvert(
              'mcpServers',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(
                        k,
                        (e as Map<String, dynamic>).map(
                          (k, e) =>
                              MapEntry(k, Map<String, String>.from(e as Map)),
                        )),
                  )),
          searchParameters: $checkedConvert(
              'searchParameters',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(
                        k,
                        SearchParametersOverrides.fromJson(
                            e as Map<String, dynamic>)),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$AgentCompletionAlgoliaParamsToJson(
    AgentCompletionAlgoliaParams instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('mcpServers', instance.mcpServers);
  writeNotNull('searchParameters',
      instance.searchParameters?.map((k, e) => MapEntry(k, e.toJson())));
  return val;
}
