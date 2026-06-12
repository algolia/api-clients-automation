// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'memory_record.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MemoryRecord _$MemoryRecordFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'MemoryRecord',
      json,
      ($checkedConvert) {
        final val = MemoryRecord(
          memoryType: $checkedConvert(
              'memoryType', (v) => $enumDecodeNullable(_$MemoryTypeEnumMap, v)),
          episode: $checkedConvert(
              'episode',
              (v) => v == null
                  ? null
                  : Episode.fromJson(v as Map<String, dynamic>)),
          text: $checkedConvert('text', (v) => v as String),
          rawExtract: $checkedConvert('rawExtract', (v) => v as String),
          keywords: $checkedConvert('keywords',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          topics: $checkedConvert('topics',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          tags: $checkedConvert('_tags',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          recallTriggers: $checkedConvert('recallTriggers',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          objectID: $checkedConvert('objectID', (v) => v as String?),
          appId: $checkedConvert('appId', (v) => v as String?),
          agentIDs: $checkedConvert('agentIDs',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          userID: $checkedConvert('userID', (v) => v as String?),
          createdAt: $checkedConvert('createdAt', (v) => (v as num?)?.toInt()),
          updatedAt: $checkedConvert('updatedAt', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
      fieldKeyMap: const {'tags': '_tags'},
    );

Map<String, dynamic> _$MemoryRecordToJson(MemoryRecord instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('memoryType', instance.memoryType?.toJson());
  writeNotNull('episode', instance.episode?.toJson());
  val['text'] = instance.text;
  val['rawExtract'] = instance.rawExtract;
  writeNotNull('keywords', instance.keywords);
  writeNotNull('topics', instance.topics);
  writeNotNull('_tags', instance.tags);
  writeNotNull('recallTriggers', instance.recallTriggers);
  writeNotNull('objectID', instance.objectID);
  writeNotNull('appId', instance.appId);
  writeNotNull('agentIDs', instance.agentIDs);
  writeNotNull('userID', instance.userID);
  writeNotNull('createdAt', instance.createdAt);
  writeNotNull('updatedAt', instance.updatedAt);
  return val;
}

const _$MemoryTypeEnumMap = {
  MemoryType.semantic: 'semantic',
  MemoryType.episodic: 'episodic',
};
