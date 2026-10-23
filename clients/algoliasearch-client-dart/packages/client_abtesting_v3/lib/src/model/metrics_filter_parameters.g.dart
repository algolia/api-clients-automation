// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'metrics_filter_parameters.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MetricsFilterParameters _$MetricsFilterParametersFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'MetricsFilterParameters',
      json,
      ($checkedConvert) {
        final val = MetricsFilterParameters(
          filterAttribute:
              $checkedConvert('filterAttribute', (v) => v as String?),
          filterValue: $checkedConvert('filterValue', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$MetricsFilterParametersToJson(
    MetricsFilterParameters instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('filterAttribute', instance.filterAttribute);
  writeNotNull('filterValue', instance.filterValue);
  return val;
}
