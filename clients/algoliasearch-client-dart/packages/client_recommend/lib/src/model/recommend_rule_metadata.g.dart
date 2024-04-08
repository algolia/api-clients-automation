// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'recommend_rule_metadata.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RecommendRuleMetadata _$RecommendRuleMetadataFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'RecommendRuleMetadata',
      json,
      ($checkedConvert) {
        final val = RecommendRuleMetadata(
          lastUpdate: $checkedConvert('lastUpdate', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$RecommendRuleMetadataToJson(
    RecommendRuleMetadata instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('lastUpdate', instance.lastUpdate);
  return val;
}
