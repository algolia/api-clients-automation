// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'rule_metadata.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RuleMetadata _$RuleMetadataFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'RuleMetadata',
      json,
      ($checkedConvert) {
        final val = RuleMetadata(
          lastUpdate: $checkedConvert('lastUpdate', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$RuleMetadataToJson(RuleMetadata instance) =>
    <String, dynamic>{
      if (instance.lastUpdate case final value?) 'lastUpdate': value,
    };
