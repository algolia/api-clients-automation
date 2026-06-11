// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'string_array_param.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

StringArrayParam _$StringArrayParamFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'StringArrayParam',
      json,
      ($checkedConvert) {
        final val = StringArrayParam(
          exposed: $checkedConvert('exposed', (v) => v as bool),
          default_: $checkedConvert('default',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          constraint: $checkedConvert(
              'constraint',
              (v) => v == null
                  ? null
                  : StringArrayParamConstraint.fromJson(
                      v as Map<String, dynamic>)),
          merge: $checkedConvert('merge', (v) => v as bool?),
        );
        return val;
      },
      fieldKeyMap: const {'default_': 'default'},
    );

Map<String, dynamic> _$StringArrayParamToJson(StringArrayParam instance) {
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
  writeNotNull('merge', instance.merge);
  return val;
}
