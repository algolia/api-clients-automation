// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'conflict_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ConflictResponse _$ConflictResponseFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ConflictResponse',
      json,
      ($checkedConvert) {
        final val = ConflictResponse(
          status: $checkedConvert('status', (v) => (v as num).toInt()),
          message: $checkedConvert('message', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$ConflictResponseToJson(ConflictResponse instance) =>
    <String, dynamic>{
      'status': instance.status,
      'message': instance.message,
    };
