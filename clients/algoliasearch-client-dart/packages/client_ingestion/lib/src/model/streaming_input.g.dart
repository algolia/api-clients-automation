// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'streaming_input.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

StreamingInput _$StreamingInputFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'StreamingInput',
      json,
      ($checkedConvert) {
        final val = StreamingInput(
          mapping: $checkedConvert('mapping',
              (v) => MappingInput.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$StreamingInputToJson(StreamingInput instance) =>
    <String, dynamic>{
      'mapping': instance.mapping.toJson(),
    };
