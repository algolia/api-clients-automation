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
          filters: $checkedConvert('filters', (v) => v as String?),
          context: $checkedConvert('context', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$ConditionToJson(Condition instance) => <String, dynamic>{
      if (instance.filters case final value?) 'filters': value,
      if (instance.context case final value?) 'context': value,
    };
