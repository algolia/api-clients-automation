// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'docker_streams.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

DockerStreams _$DockerStreamsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'DockerStreams',
      json,
      ($checkedConvert) {
        final val = DockerStreams(
          name: $checkedConvert('name', (v) => v as String),
          properties: $checkedConvert('properties',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          syncMode: $checkedConvert('syncMode',
              (v) => $enumDecode(_$DockerStreamsSyncModeEnumMap, v)),
        );
        return val;
      },
    );

Map<String, dynamic> _$DockerStreamsToJson(DockerStreams instance) {
  final val = <String, dynamic>{
    'name': instance.name,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('properties', instance.properties);
  val['syncMode'] = instance.syncMode.toJson();
  return val;
}

const _$DockerStreamsSyncModeEnumMap = {
  DockerStreamsSyncMode.incremental: 'incremental',
  DockerStreamsSyncMode.fullTable: 'fullTable',
};
