// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'guardrail_outcome.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

GuardrailOutcome _$GuardrailOutcomeFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'GuardrailOutcome',
      json,
      ($checkedConvert) {
        final val = GuardrailOutcome(
          blocked: $checkedConvert('blocked', (v) => v as bool),
          category: $checkedConvert('category', (v) => v as String),
          guardrailType: $checkedConvert('guardrailType',
              (v) => $enumDecodeNullable(_$OneOfEnumEnumMap, v)),
        );
        return val;
      },
    );

Map<String, dynamic> _$GuardrailOutcomeToJson(GuardrailOutcome instance) {
  final val = <String, dynamic>{
    'blocked': instance.blocked,
    'category': instance.category,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('guardrailType', instance.guardrailType?.toJson());
  return val;
}

const _$OneOfEnumEnumMap = {
  OneOfEnum.downvote: 0,
  OneOfEnum.upvote: 1,
};
