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
          context: $checkedConvert('context', (v) => v as String?),
          filters: $checkedConvert('filters', (v) => v as String?),
          sortBy: $checkedConvert('sortBy', (v) => v as String?),
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

  writeNotNull('pattern', instance.pattern);
  writeNotNull('anchoring', instance.anchoring?.toJson());
  writeNotNull('context', instance.context);
  writeNotNull('filters', instance.filters);
  writeNotNull('sortBy', instance.sortBy);
  return val;
}

const _$AnchoringEnumMap = {
  Anchoring.is_: 'is',
  Anchoring.startsWith: 'startsWith',
  Anchoring.endsWith: 'endsWith',
  Anchoring.contains: 'contains',
};
