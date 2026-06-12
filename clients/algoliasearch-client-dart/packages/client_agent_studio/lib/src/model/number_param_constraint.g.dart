// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'number_param_constraint.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

NumberParamConstraint _$NumberParamConstraintFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'NumberParamConstraint',
      json,
      ($checkedConvert) {
        final val = NumberParamConstraint(
          min: $checkedConvert('min', (v) => (v as num?)?.toInt()),
          max: $checkedConvert('max', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$NumberParamConstraintToJson(
    NumberParamConstraint instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('min', instance.min);
  writeNotNull('max', instance.max);
  return val;
}
