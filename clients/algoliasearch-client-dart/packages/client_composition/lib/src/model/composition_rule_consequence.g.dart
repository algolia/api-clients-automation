// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'composition_rule_consequence.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CompositionRuleConsequence _$CompositionRuleConsequenceFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'CompositionRuleConsequence',
      json,
      ($checkedConvert) {
        final val = CompositionRuleConsequence(
          behavior: $checkedConvert('behavior',
              (v) => CompositionBehavior.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$CompositionRuleConsequenceToJson(
        CompositionRuleConsequence instance) =>
    <String, dynamic>{
      'behavior': instance.behavior.toJson(),
    };
