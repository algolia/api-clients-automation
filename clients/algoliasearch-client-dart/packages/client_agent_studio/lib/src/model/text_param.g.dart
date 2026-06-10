// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'text_param.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TextParam _$TextParamFromJson(Map<String, dynamic> json) => $checkedCreate(
      'TextParam',
      json,
      ($checkedConvert) {
        final val = TextParam(
          exposed: $checkedConvert('exposed', (v) => v as bool),
          default_: $checkedConvert('default', (v) => v as String?),
        );
        return val;
      },
      fieldKeyMap: const {'default_': 'default'},
    );

Map<String, dynamic> _$TextParamToJson(TextParam instance) {
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
