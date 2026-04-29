// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_extensions.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchExtensions _$SearchExtensionsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchExtensions',
      json,
      ($checkedConvert) {
        final val = SearchExtensions(
          queryCategorization: $checkedConvert(
              'queryCategorization',
              (v) => v == null
                  ? null
                  : SearchExtensionsQueryCategorization.fromJson(
                      v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchExtensionsToJson(SearchExtensions instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('queryCategorization', instance.queryCategorization?.toJson());
  return val;
}
