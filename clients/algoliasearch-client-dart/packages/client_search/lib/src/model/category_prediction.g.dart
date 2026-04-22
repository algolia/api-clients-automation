// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'category_prediction.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CategoryPrediction _$CategoryPredictionFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'CategoryPrediction',
      json,
      ($checkedConvert) {
        final val = CategoryPrediction(
          bin: $checkedConvert('bin',
              (v) => $enumDecodeNullable(_$CategoryPredictionBinEnumMap, v)),
          hierarchyPath: $checkedConvert(
              'hierarchyPath',
              (v) => (v as List<dynamic>?)
                  ?.map((e) =>
                      HierarchyPathEntry.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$CategoryPredictionToJson(CategoryPrediction instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('bin', instance.bin?.toJson());
  writeNotNull(
      'hierarchyPath', instance.hierarchyPath?.map((e) => e.toJson()).toList());
  return val;
}

const _$CategoryPredictionBinEnumMap = {
  CategoryPredictionBin.certain: 'certain',
  CategoryPredictionBin.veryHigh: 'very high',
  CategoryPredictionBin.high: 'high',
  CategoryPredictionBin.low: 'low',
  CategoryPredictionBin.veryLow: 'very low',
};
