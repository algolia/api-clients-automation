// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'step_start_part_v4.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

StepStartPartV4 _$StepStartPartV4FromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'StepStartPartV4',
      json,
      ($checkedConvert) {
        final val = StepStartPartV4(
          type: $checkedConvert('type', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$StepStartPartV4ToJson(StepStartPartV4 instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('type', instance.type);
  return val;
}
