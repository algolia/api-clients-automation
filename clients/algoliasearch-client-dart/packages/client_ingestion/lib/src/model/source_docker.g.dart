// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'source_docker.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SourceDocker _$SourceDockerFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SourceDocker',
      json,
      ($checkedConvert) {
        final val = SourceDocker(
          image: $checkedConvert('image', (v) => v as String),
          configuration: $checkedConvert('configuration', (v) => v as Object),
        );
        return val;
      },
    );

Map<String, dynamic> _$SourceDockerToJson(SourceDocker instance) =>
    <String, dynamic>{
      'image': instance.image,
      'configuration': instance.configuration,
    };
