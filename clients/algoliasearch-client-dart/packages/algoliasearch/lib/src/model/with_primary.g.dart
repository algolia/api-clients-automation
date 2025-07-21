// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'with_primary.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

WithPrimary _$WithPrimaryFromJson(Map<String, dynamic> json) => $checkedCreate(
      'WithPrimary',
      json,
      ($checkedConvert) {
        final val = WithPrimary(
          primary: $checkedConvert('primary', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$WithPrimaryToJson(WithPrimary instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('primary', instance.primary);
  return val;
}
