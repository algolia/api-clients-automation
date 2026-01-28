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
          behavior: $checkedConvert('behavior', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$CompositionRuleConsequenceToJson(
    CompositionRuleConsequence instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('behavior', instance.behavior);
  return val;
}
