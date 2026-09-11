// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'data_guardrail_violation_part_v5.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

DataGuardrailViolationPartV5 _$DataGuardrailViolationPartV5FromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'DataGuardrailViolationPartV5',
      json,
      ($checkedConvert) {
        final val = DataGuardrailViolationPartV5(
          type: $checkedConvert('type', (v) => v as String?),
          data: $checkedConvert(
              'data',
              (v) =>
                  GuardrailViolationDataV5.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$DataGuardrailViolationPartV5ToJson(
    DataGuardrailViolationPartV5 instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('type', instance.type);
  val['data'] = instance.data.toJson();
  return val;
}
