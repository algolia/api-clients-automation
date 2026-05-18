// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'docker_streams_input.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

DockerStreamsInput _$DockerStreamsInputFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'DockerStreamsInput',
      json,
      ($checkedConvert) {
        final val = DockerStreamsInput(
          streams: $checkedConvert(
              'streams',
              (v) => (v as List<dynamic>)
                  .map((e) => DockerStreams.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$DockerStreamsInputToJson(DockerStreamsInput instance) =>
    <String, dynamic>{
      'streams': instance.streams.map((e) => e.toJson()).toList(),
    };
