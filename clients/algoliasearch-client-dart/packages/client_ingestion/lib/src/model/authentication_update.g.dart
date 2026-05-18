// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'authentication_update.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AuthenticationUpdate _$AuthenticationUpdateFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AuthenticationUpdate',
      json,
      ($checkedConvert) {
        final val = AuthenticationUpdate(
          name: $checkedConvert('name', (v) => v as String?),
          input: $checkedConvert('input', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$AuthenticationUpdateToJson(
    AuthenticationUpdate instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('name', instance.name);
  writeNotNull('input', instance.input);
  return val;
}
