// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'estimate_configuration.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

EstimateConfiguration _$EstimateConfigurationFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'EstimateConfiguration',
      json,
      ($checkedConvert) {
        final val = EstimateConfiguration(
          filters: $checkedConvert(
              'filters',
              (v) => (v as List<dynamic>?)
                  ?.map(
                      (e) => MetricsFilter.fromJson(e as Map<String, dynamic>))
                  .toList()),
          minimumDetectableEffect: $checkedConvert(
              'minimumDetectableEffect',
              (v) =>
                  MinimumDetectableEffect.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$EstimateConfigurationToJson(
    EstimateConfiguration instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('filters', instance.filters?.map((e) => e.toJson()).toList());
  val['minimumDetectableEffect'] = instance.minimumDetectableEffect.toJson();
  return val;
}
