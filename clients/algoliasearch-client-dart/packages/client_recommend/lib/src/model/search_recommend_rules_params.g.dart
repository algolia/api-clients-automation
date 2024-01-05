// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_recommend_rules_params.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchRecommendRulesParams _$SearchRecommendRulesParamsFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchRecommendRulesParams',
      json,
      ($checkedConvert) {
        final val = SearchRecommendRulesParams(
          query: $checkedConvert('query', (v) => v as String?),
          context: $checkedConvert('context', (v) => v as String?),
          page: $checkedConvert('page', (v) => v as int?),
          hitsPerPage: $checkedConvert('hitsPerPage', (v) => v as int?),
          enabled: $checkedConvert('enabled', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchRecommendRulesParamsToJson(
    SearchRecommendRulesParams instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('query', instance.query);
  writeNotNull('context', instance.context);
  writeNotNull('page', instance.page);
  writeNotNull('hitsPerPage', instance.hitsPerPage);
  writeNotNull('enabled', instance.enabled);
  return val;
}
