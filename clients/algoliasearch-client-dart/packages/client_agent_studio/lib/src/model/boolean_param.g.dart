// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'boolean_param.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BooleanParam _$BooleanParamFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'BooleanParam',
      json,
      ($checkedConvert) {
        final val = BooleanParam(
          exposed: $checkedConvert('exposed', (v) => v as bool),
          default_: $checkedConvert('default', (v) => v as bool?),
        );
        return val;
      },
      fieldKeyMap: const {'default_': 'default'},
    );

Map<String, dynamic> _$BooleanParamToJson(BooleanParam instance) {
  final val = <String, dynamic>{
    'exposed': instance.exposed,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('default', instance.default_);
  return val;
}
