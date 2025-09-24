// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'external_source.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ExternalSource _$ExternalSourceFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ExternalSource',
      json,
      ($checkedConvert) {
        final val = ExternalSource(
          external_: $checkedConvert(
              'external', (v) => External.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
      fieldKeyMap: const {'external_': 'external'},
    );

Map<String, dynamic> _$ExternalSourceToJson(ExternalSource instance) =>
    <String, dynamic>{
      'external': instance.external_.toJson(),
    };
