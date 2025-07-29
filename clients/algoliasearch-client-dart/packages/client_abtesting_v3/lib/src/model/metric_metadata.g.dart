// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'metric_metadata.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MetricMetadata _$MetricMetadataFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'MetricMetadata',
      json,
      ($checkedConvert) {
        final val = MetricMetadata(
          winsorizedValue: $checkedConvert(
              'winsorizedValue', (v) => (v as num?)?.toDouble()),
          mean: $checkedConvert('mean', (v) => (v as num?)?.toDouble()),
        );
        return val;
      },
    );

Map<String, dynamic> _$MetricMetadataToJson(MetricMetadata instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('winsorizedValue', instance.winsorizedValue);
  writeNotNull('mean', instance.mean);
  return val;
}
