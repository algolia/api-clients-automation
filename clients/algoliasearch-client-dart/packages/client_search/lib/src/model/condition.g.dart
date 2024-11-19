// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'condition.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Condition _$ConditionFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Condition',
      json,
      ($checkedConvert) {
        final val = Condition(
          pattern: $checkedConvert('pattern', (v) => v as String?),
          anchoring: $checkedConvert(
              'anchoring', (v) => $enumDecodeNullable(_$AnchoringEnumMap, v)),
          alternatives: $checkedConvert('alternatives', (v) => v as bool?),
          context: $checkedConvert('context', (v) => v as String?),
          filters: $checkedConvert('filters', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$ConditionToJson(Condition instance) => <String, dynamic>{
      if (instance.pattern case final value?) 'pattern': value,
      if (instance.anchoring?.toJson() case final value?) 'anchoring': value,
      if (instance.alternatives case final value?) 'alternatives': value,
      if (instance.context case final value?) 'context': value,
      if (instance.filters case final value?) 'filters': value,
    };

const _$AnchoringEnumMap = {
  Anchoring.is_: 'is',
  Anchoring.startsWith: 'startsWith',
  Anchoring.endsWith: 'endsWith',
  Anchoring.contains: 'contains',
};
