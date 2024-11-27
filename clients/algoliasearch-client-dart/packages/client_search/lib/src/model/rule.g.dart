// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'rule.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Rule _$RuleFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Rule',
      json,
      ($checkedConvert) {
        final val = Rule(
          objectID: $checkedConvert('objectID', (v) => v as String),
          conditions: $checkedConvert(
              'conditions',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => Condition.fromJson(e as Map<String, dynamic>))
                  .toList()),
          consequence: $checkedConvert('consequence',
              (v) => Consequence.fromJson(v as Map<String, dynamic>)),
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
    );

Map<String, dynamic> _$RuleToJson(Rule instance) => <String, dynamic>{
      'objectID': instance.objectID,
      if (instance.conditions?.map((e) => e.toJson()).toList()
          case final value?)
        'conditions': value,
      'consequence': instance.consequence.toJson(),
      if (instance.description case final value?) 'description': value,
      if (instance.enabled case final value?) 'enabled': value,
      if (instance.validity?.map((e) => e.toJson()).toList() case final value?)
        'validity': value,
    };
