// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_parameters_overrides.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchParametersOverrides _$SearchParametersOverridesFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchParametersOverrides',
      json,
      ($checkedConvert) {
        final val = SearchParametersOverrides(
          filters: $checkedConvert('filters', (v) => v as String?),
          attributesToRetrieve: $checkedConvert('attributesToRetrieve',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          restrictSearchableAttributes: $checkedConvert(
              'restrictSearchableAttributes',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          distinct: $checkedConvert('distinct', (v) => v),
          userToken: $checkedConvert('userToken', (v) => v as String?),
          enablePersonalization:
              $checkedConvert('enablePersonalization', (v) => v as bool?),
          personalizationImpact: $checkedConvert(
              'personalizationImpact', (v) => (v as num?)?.toInt()),
          optionalFilters: $checkedConvert('optionalFilters', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchParametersOverridesToJson(
    SearchParametersOverrides instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('filters', instance.filters);
  writeNotNull('attributesToRetrieve', instance.attributesToRetrieve);
  writeNotNull(
      'restrictSearchableAttributes', instance.restrictSearchableAttributes);
  writeNotNull('distinct', instance.distinct);
  writeNotNull('userToken', instance.userToken);
  writeNotNull('enablePersonalization', instance.enablePersonalization);
  writeNotNull('personalizationImpact', instance.personalizationImpact);
  writeNotNull('optionalFilters', instance.optionalFilters);
  return val;
}
