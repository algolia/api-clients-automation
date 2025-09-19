// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'composition_rules_batch_params.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CompositionRulesBatchParams _$CompositionRulesBatchParamsFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'CompositionRulesBatchParams',
      json,
      ($checkedConvert) {
        final val = CompositionRulesBatchParams(
          requests: $checkedConvert(
              'requests',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => RulesMultipleBatchRequest.fromJson(
                      e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$CompositionRulesBatchParamsToJson(
    CompositionRulesBatchParams instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('requests', instance.requests?.map((e) => e.toJson()).toList());
  return val;
}
