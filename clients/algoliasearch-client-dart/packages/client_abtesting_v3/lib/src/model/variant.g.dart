// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'variant.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Variant _$VariantFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Variant',
      json,
      ($checkedConvert) {
        final val = Variant(
          description: $checkedConvert('description', (v) => v as String),
          estimatedSampleSize: $checkedConvert(
              'estimatedSampleSize', (v) => (v as num?)?.toInt()),
          index: $checkedConvert('index', (v) => v as String),
          trafficPercentage:
              $checkedConvert('trafficPercentage', (v) => (v as num).toInt()),
          metrics: $checkedConvert(
              'metrics',
              (v) => (v as List<dynamic>)
                  .map((e) => MetricResult.fromJson(e as Map<String, dynamic>))
                  .toList()),
          metadata: $checkedConvert(
              'metadata',
              (v) => v == null
                  ? null
                  : VariantMetadata.fromJson(v as Map<String, dynamic>)),
          customSearchParameters:
              $checkedConvert('customSearchParameters', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$VariantToJson(Variant instance) {
  final val = <String, dynamic>{
    'description': instance.description,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('estimatedSampleSize', instance.estimatedSampleSize);
  val['index'] = instance.index;
  val['trafficPercentage'] = instance.trafficPercentage;
  val['metrics'] = instance.metrics.map((e) => e.toJson()).toList();
  writeNotNull('metadata', instance.metadata?.toJson());
  writeNotNull('customSearchParameters', instance.customSearchParameters);
  return val;
}
