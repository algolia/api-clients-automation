// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'validation_error.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ValidationError _$ValidationErrorFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ValidationError',
      json,
      ($checkedConvert) {
        final val = ValidationError(
          loc: $checkedConvert('loc', (v) => v as List<dynamic>),
          msg: $checkedConvert('msg', (v) => v as String),
          type: $checkedConvert('type', (v) => v as String),
          input: $checkedConvert('input', (v) => v),
          ctx: $checkedConvert('ctx', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$ValidationErrorToJson(ValidationError instance) {
  final val = <String, dynamic>{
    'loc': instance.loc.toList(),
    'msg': instance.msg,
    'type': instance.type,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('input', instance.input);
  writeNotNull('ctx', instance.ctx);
  return val;
}
