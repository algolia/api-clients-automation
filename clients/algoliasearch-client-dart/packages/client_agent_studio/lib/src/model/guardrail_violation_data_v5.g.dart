// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'guardrail_violation_data_v5.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

GuardrailViolationDataV5 _$GuardrailViolationDataV5FromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'GuardrailViolationDataV5',
      json,
      ($checkedConvert) {
        final val = GuardrailViolationDataV5(
          category: $checkedConvert('category', (v) => v as String),
          guardrailType: $checkedConvert('guardrailType', (v) => v as String?),
          fallbackResponse:
              $checkedConvert('fallbackResponse', (v) => v as String?),
        );
        return val;
      },
    );

const _$GuardrailViolationDataV5FieldMap = <String, String>{
  'category': 'category',
  'guardrailType': 'guardrailType',
  'fallbackResponse': 'fallbackResponse',
};

Map<String, dynamic> _$GuardrailViolationDataV5ToJson(
    GuardrailViolationDataV5 instance) {
  final val = <String, dynamic>{
    'category': instance.category,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('guardrailType', instance.guardrailType);
  writeNotNull('fallbackResponse', instance.fallbackResponse);
  return val;
}
