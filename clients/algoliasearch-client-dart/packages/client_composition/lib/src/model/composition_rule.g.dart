// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'composition_rule.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CompositionRule _$CompositionRuleFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'CompositionRule',
      json,
      ($checkedConvert) {
        final val = CompositionRule(
          objectID: $checkedConvert('objectID', (v) => v as String),
          conditions: $checkedConvert(
              'conditions',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => Condition.fromJson(e as Map<String, dynamic>))
                  .toList()),
          consequence: $checkedConvert(
              'consequence',
              (v) => CompositionRuleConsequence.fromJson(
                  v as Map<String, dynamic>)),
          description: $checkedConvert('description', (v) => v as String?),
          enabled: $checkedConvert('enabled', (v) => v as bool?),
          validity: $checkedConvert(
              'validity',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => TimeRange.fromJson(e as Map<String, dynamic>))
                  .toList()),
          tags: $checkedConvert('tags',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$CompositionRuleToJson(CompositionRule instance) {
  final val = <String, dynamic>{
    'objectID': instance.objectID,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull(
      'conditions', instance.conditions?.map((e) => e.toJson()).toList());
  val['consequence'] = instance.consequence.toJson();
  writeNotNull('description', instance.description);
  writeNotNull('enabled', instance.enabled);
  writeNotNull('validity', instance.validity?.map((e) => e.toJson()).toList());
  writeNotNull('tags', instance.tags);
  return val;
}
