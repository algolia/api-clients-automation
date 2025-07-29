// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'filter_effects.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

FilterEffects _$FilterEffectsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'FilterEffects',
      json,
      ($checkedConvert) {
        final val = FilterEffects(
          outliers: $checkedConvert(
              'outliers',
              (v) => v == null
                  ? null
                  : OutliersFilter.fromJson(v as Map<String, dynamic>)),
          emptySearch: $checkedConvert(
              'emptySearch',
              (v) => v == null
                  ? null
                  : EmptySearchFilter.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$FilterEffectsToJson(FilterEffects instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('outliers', instance.outliers?.toJson());
  writeNotNull('emptySearch', instance.emptySearch?.toJson());
  return val;
}
