// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'query_categorization.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

QueryCategorization _$QueryCategorizationFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'QueryCategorization',
      json,
      ($checkedConvert) {
        final val = QueryCategorization(
          normalizedQuery:
              $checkedConvert('normalizedQuery', (v) => v as String?),
          type: $checkedConvert('type',
              (v) => $enumDecodeNullable(_$QueryCategorizationTypeEnumMap, v)),
          categories: $checkedConvert(
              'categories',
              (v) => (v as List<dynamic>?)
                  ?.map((e) =>
                      CategoryPrediction.fromJson(e as Map<String, dynamic>))
                  .toList()),
          autofiltering: $checkedConvert(
              'autofiltering',
              (v) => v == null
                  ? null
                  : AutoFilteringResult.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$QueryCategorizationToJson(QueryCategorization instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('normalizedQuery', instance.normalizedQuery);
  writeNotNull('type', instance.type?.toJson());
  writeNotNull(
      'categories', instance.categories?.map((e) => e.toJson()).toList());
  writeNotNull('autofiltering', instance.autofiltering?.toJson());
  return val;
}

const _$QueryCategorizationTypeEnumMap = {
  QueryCategorizationType.narrow: 'narrow',
  QueryCategorizationType.broad: 'broad',
  QueryCategorizationType.ambiguous: 'ambiguous',
  QueryCategorizationType.none: 'none',
};
