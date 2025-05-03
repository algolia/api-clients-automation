// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'request_body.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RequestBody _$RequestBodyFromJson(Map<String, dynamic> json) => $checkedCreate(
      'RequestBody',
      json,
      ($checkedConvert) {
        final val = RequestBody(
          params: $checkedConvert(
              'params',
              (v) => v == null
                  ? null
                  : Params.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$RequestBodyToJson(RequestBody instance) =>
    <String, dynamic>{
      if (instance.params?.toJson() case final value?) 'params': value,
    };
