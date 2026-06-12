// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'string_array_param_constraint.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

StringArrayParamConstraint _$StringArrayParamConstraintFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'StringArrayParamConstraint',
      json,
      ($checkedConvert) {
        final val = StringArrayParamConstraint(
          values: $checkedConvert('values',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$StringArrayParamConstraintToJson(
    StringArrayParamConstraint instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('values', instance.values);
  return val;
}
