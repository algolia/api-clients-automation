// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'delete_composition_rule_action.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

DeleteCompositionRuleAction _$DeleteCompositionRuleActionFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'DeleteCompositionRuleAction',
      json,
      ($checkedConvert) {
        final val = DeleteCompositionRuleAction(
          objectID: $checkedConvert('objectID', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$DeleteCompositionRuleActionToJson(
        DeleteCompositionRuleAction instance) =>
    <String, dynamic>{
      'objectID': instance.objectID,
    };
