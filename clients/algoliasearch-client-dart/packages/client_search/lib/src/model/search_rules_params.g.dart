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

Map<String, dynamic> _$SearchRulesParamsToJson(SearchRulesParams instance) =>
    <String, dynamic>{
      if (instance.query case final value?) 'query': value,
      if (instance.anchoring?.toJson() case final value?) 'anchoring': value,
      if (instance.context case final value?) 'context': value,
      if (instance.page case final value?) 'page': value,
      if (instance.hitsPerPage case final value?) 'hitsPerPage': value,
      if (instance.enabled case final value?) 'enabled': value,
    };

const _$AnchoringEnumMap = {
  Anchoring.is_: 'is',
  Anchoring.startsWith: 'startsWith',
  Anchoring.endsWith: 'endsWith',
  Anchoring.contains: 'contains',
};
