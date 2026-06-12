// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'step_start_part_v5.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

StepStartPartV5 _$StepStartPartV5FromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'StepStartPartV5',
      json,
      ($checkedConvert) {
        final val = StepStartPartV5(
          type: $checkedConvert('type', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$StepStartPartV5ToJson(StepStartPartV5 instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('type', instance.type);
  return val;
}
