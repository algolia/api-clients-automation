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

Map<String, dynamic> _$ConditionToJson(Condition instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('filters', instance.filters);
  writeNotNull('context', instance.context);
  return val;
}
