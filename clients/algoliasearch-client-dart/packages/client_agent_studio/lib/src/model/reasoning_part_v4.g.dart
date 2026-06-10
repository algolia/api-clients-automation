// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'reasoning_part_v4.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ReasoningPartV4 _$ReasoningPartV4FromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ReasoningPartV4',
      json,
      ($checkedConvert) {
        final val = ReasoningPartV4(
          type: $checkedConvert('type', (v) => v as String?),
          reasoning: $checkedConvert('reasoning', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$ReasoningPartV4ToJson(ReasoningPartV4 instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('type', instance.type);
  val['reasoning'] = instance.reasoning;
  return val;
}
