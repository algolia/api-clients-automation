// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'composition_run_applied_rules.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CompositionRunAppliedRules _$CompositionRunAppliedRulesFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'CompositionRunAppliedRules',
      json,
      ($checkedConvert) {
        final val = CompositionRunAppliedRules(
          objectID: $checkedConvert('objectID', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$CompositionRunAppliedRulesToJson(
        CompositionRunAppliedRules instance) =>
    <String, dynamic>{
      'objectID': instance.objectID,
    };
