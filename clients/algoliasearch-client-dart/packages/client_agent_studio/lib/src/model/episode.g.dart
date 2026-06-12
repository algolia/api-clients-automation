// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'episode.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Episode _$EpisodeFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Episode',
      json,
      ($checkedConvert) {
        final val = Episode(
          observation: $checkedConvert('observation', (v) => v as String),
          thoughts: $checkedConvert('thoughts', (v) => v as String),
          action: $checkedConvert('action', (v) => v as String),
          result: $checkedConvert('result', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$EpisodeToJson(Episode instance) => <String, dynamic>{
      'observation': instance.observation,
      'thoughts': instance.thoughts,
      'action': instance.action,
      'result': instance.result,
    };
