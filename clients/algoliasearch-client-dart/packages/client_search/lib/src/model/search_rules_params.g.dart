// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_rules_params.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchRulesParams _$SearchRulesParamsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchRulesParams',
      json,
      ($checkedConvert) {
        final val = SearchRulesParams(
          query: $checkedConvert('query', (v) => v as String?),
          anchoring: $checkedConvert(
              'anchoring', (v) => $enumDecodeNullable(_$AnchoringEnumMap, v)),
          context: $checkedConvert('context', (v) => v as String?),
          page: $checkedConvert('page', (v) => (v as num?)?.toInt()),
          hitsPerPage:
              $checkedConvert('hitsPerPage', (v) => (v as num?)?.toInt()),
          enabled: $checkedConvert('enabled', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchRulesParamsToJson(SearchRulesParams instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('query', instance.query);
  writeNotNull('anchoring', instance.anchoring?.toJson());
  writeNotNull('context', instance.context);
  writeNotNull('page', instance.page);
  writeNotNull('hitsPerPage', instance.hitsPerPage);
  writeNotNull('enabled', instance.enabled);
  return val;
}

const _$AnchoringEnumMap = {
  Anchoring.is_: 'is',
  Anchoring.startsWith: 'startsWith',
  Anchoring.endsWith: 'endsWith',
  Anchoring.contains: 'contains',
};
