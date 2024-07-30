// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'redirect_rule_index_data.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RedirectRuleIndexData _$RedirectRuleIndexDataFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'RedirectRuleIndexData',
      json,
      ($checkedConvert) {
        final val = RedirectRuleIndexData(
          ruleObjectID: $checkedConvert('ruleObjectID', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$RedirectRuleIndexDataToJson(
        RedirectRuleIndexData instance) =>
    <String, dynamic>{
      'ruleObjectID': instance.ruleObjectID,
    };
