// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'context_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ContextResponse _$ContextResponseFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ContextResponse',
      json,
      ($checkedConvert) {
        final val = ContextResponse(
          messages: $checkedConvert('messages', (v) => v),
          stats: $checkedConvert(
              'stats', (v) => ContextStats.fromJson(v as Map<String, dynamic>)),
          compaction: $checkedConvert(
              'compaction',
              (v) => v == null
                  ? null
                  : CompactionStats.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$ContextResponseToJson(ContextResponse instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('messages', instance.messages);
  val['stats'] = instance.stats.toJson();
  writeNotNull('compaction', instance.compaction?.toJson());
  return val;
}
