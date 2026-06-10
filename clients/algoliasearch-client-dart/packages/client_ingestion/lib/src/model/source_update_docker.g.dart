// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'source_update_docker.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SourceUpdateDocker _$SourceUpdateDockerFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SourceUpdateDocker',
      json,
      ($checkedConvert) {
        final val = SourceUpdateDocker(
          configuration: $checkedConvert('configuration', (v) => v as Object),
        );
        return val;
      },
    );

Map<String, dynamic> _$SourceUpdateDockerToJson(SourceUpdateDocker instance) =>
    <String, dynamic>{
      'configuration': instance.configuration,
    };
