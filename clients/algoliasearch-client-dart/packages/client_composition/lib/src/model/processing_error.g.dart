// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'processing_error.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ProcessingError _$ProcessingErrorFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ProcessingError',
      json,
      ($checkedConvert) {
        final val = ProcessingError(
          message: $checkedConvert('message', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$ProcessingErrorToJson(ProcessingError instance) =>
    <String, dynamic>{
      'message': instance.message,
    };
