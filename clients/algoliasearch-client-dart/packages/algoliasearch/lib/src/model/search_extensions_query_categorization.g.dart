// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_extensions_query_categorization.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchExtensionsQueryCategorization
    _$SearchExtensionsQueryCategorizationFromJson(Map<String, dynamic> json) =>
        $checkedCreate(
          'SearchExtensionsQueryCategorization',
          json,
          ($checkedConvert) {
            final val = SearchExtensionsQueryCategorization(
              enableCategoriesRetrieval: $checkedConvert(
                  'enableCategoriesRetrieval', (v) => v as bool?),
              enableAutoFiltering:
                  $checkedConvert('enableAutoFiltering', (v) => v as bool?),
            );
            return val;
          },
        );

Map<String, dynamic> _$SearchExtensionsQueryCategorizationToJson(
    SearchExtensionsQueryCategorization instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('enableCategoriesRetrieval', instance.enableCategoriesRetrieval);
  writeNotNull('enableAutoFiltering', instance.enableAutoFiltering);
  return val;
}
