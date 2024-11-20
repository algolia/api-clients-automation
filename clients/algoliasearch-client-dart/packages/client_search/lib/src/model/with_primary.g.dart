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

Map<String, dynamic> _$WithPrimaryToJson(WithPrimary instance) =>
    <String, dynamic>{
      if (instance.primary case final value?) 'primary': value,
    };
