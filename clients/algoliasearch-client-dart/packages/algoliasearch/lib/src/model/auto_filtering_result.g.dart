// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'auto_filtering_result.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AutoFilteringResult _$AutoFilteringResultFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'AutoFilteringResult',
      json,
      ($checkedConvert) {
        final val = AutoFilteringResult(
          enabled: $checkedConvert('enabled', (v) => v as bool?),
          maxDepth: $checkedConvert('maxDepth', (v) => (v as num?)?.toInt()),
          facetFilters:
              $checkedConvert('facetFilters', (v) => v as List<dynamic>?),
          optionalFilters:
              $checkedConvert('optionalFilters', (v) => v as List<dynamic>?),
        );
        return val;
      },
    );

Map<String, dynamic> _$AutoFilteringResultToJson(AutoFilteringResult instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('enabled', instance.enabled);
  writeNotNull('maxDepth', instance.maxDepth);
  writeNotNull('facetFilters', instance.facetFilters?.toList());
  writeNotNull('optionalFilters', instance.optionalFilters?.toList());
  return val;
}
