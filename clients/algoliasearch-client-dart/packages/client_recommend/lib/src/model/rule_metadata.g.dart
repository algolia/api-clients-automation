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

Map<String, dynamic> _$RuleMetadataToJson(RuleMetadata instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('lastUpdate', instance.lastUpdate);
  return val;
}
