// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'redirect_rule_index_metadata.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RedirectRuleIndexMetadata _$RedirectRuleIndexMetadataFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'RedirectRuleIndexMetadata',
      json,
      ($checkedConvert) {
        final val = RedirectRuleIndexMetadata(
          source: $checkedConvert('source', (v) => v as String),
          dest: $checkedConvert('dest', (v) => v as String),
          reason: $checkedConvert('reason', (v) => v as String),
          succeed: $checkedConvert('succeed', (v) => v as bool),
          data: $checkedConvert('data',
              (v) => RedirectRuleIndexData.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$RedirectRuleIndexMetadataToJson(
        RedirectRuleIndexMetadata instance) =>
    <String, dynamic>{
      'source': instance.source,
      'dest': instance.dest,
      'reason': instance.reason,
      'succeed': instance.succeed,
      'data': instance.data.toJson(),
    };
