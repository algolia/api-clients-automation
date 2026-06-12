// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'number_param.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

NumberParam _$NumberParamFromJson(Map<String, dynamic> json) => $checkedCreate(
      'NumberParam',
      json,
      ($checkedConvert) {
        final val = NumberParam(
          exposed: $checkedConvert('exposed', (v) => v as bool),
          default_: $checkedConvert('default', (v) => (v as num?)?.toInt()),
          constraint: $checkedConvert(
              'constraint',
              (v) => v == null
                  ? null
                  : NumberParamConstraint.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
      fieldKeyMap: const {'default_': 'default'},
    );

Map<String, dynamic> _$NumberParamToJson(NumberParam instance) {
  final val = <String, dynamic>{
    'exposed': instance.exposed,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('default', instance.default_);
  writeNotNull('constraint', instance.constraint?.toJson());
  return val;
}
