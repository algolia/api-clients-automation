// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'recommend_rule.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RecommendRule _$RecommendRuleFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'RecommendRule',
      json,
      ($checkedConvert) {
        final val = RecommendRule(
          metadata: $checkedConvert(
              '_metadata',
              (v) => v == null
                  ? null
                  : RuleMetadata.fromJson(v as Map<String, dynamic>)),
          objectID: $checkedConvert('objectID', (v) => v as String?),
          condition: $checkedConvert(
              'condition',
              (v) => v == null
                  ? null
                  : Condition.fromJson(v as Map<String, dynamic>)),
          consequence: $checkedConvert(
              'consequence',
              (v) => v == null
                  ? null
                  : Consequence.fromJson(v as Map<String, dynamic>)),
          description: $checkedConvert('description', (v) => v as String?),
          enabled: $checkedConvert('enabled', (v) => v as bool?),
          validity: $checkedConvert(
              'validity',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => TimeRange.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
      fieldKeyMap: const {'metadata': '_metadata'},
    );

Map<String, dynamic> _$RecommendRuleToJson(RecommendRule instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('_metadata', instance.metadata?.toJson());
  writeNotNull('objectID', instance.objectID);
  writeNotNull('condition', instance.condition?.toJson());
  writeNotNull('consequence', instance.consequence?.toJson());
  writeNotNull('description', instance.description);
  writeNotNull('enabled', instance.enabled);
  writeNotNull('validity', instance.validity?.map((e) => e.toJson()).toList());
  return val;
}
