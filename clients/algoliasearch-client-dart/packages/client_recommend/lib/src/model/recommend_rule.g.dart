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

Map<String, dynamic> _$RecommendRuleToJson(RecommendRule instance) =>
    <String, dynamic>{
      if (instance.metadata?.toJson() case final value?) '_metadata': value,
      if (instance.objectID case final value?) 'objectID': value,
      if (instance.condition?.toJson() case final value?) 'condition': value,
      if (instance.consequence?.toJson() case final value?)
        'consequence': value,
      if (instance.description case final value?) 'description': value,
      if (instance.enabled case final value?) 'enabled': value,
      if (instance.validity?.map((e) => e.toJson()).toList() case final value?)
        'validity': value,
    };
