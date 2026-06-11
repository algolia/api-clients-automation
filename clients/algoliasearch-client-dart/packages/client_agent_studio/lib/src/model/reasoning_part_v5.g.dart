// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'reasoning_part_v5.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ReasoningPartV5 _$ReasoningPartV5FromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ReasoningPartV5',
      json,
      ($checkedConvert) {
        final val = ReasoningPartV5(
          type: $checkedConvert('type', (v) => v as String?),
          text: $checkedConvert('text', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$ReasoningPartV5ToJson(ReasoningPartV5 instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('type', instance.type);
  val['text'] = instance.text;
  return val;
}
