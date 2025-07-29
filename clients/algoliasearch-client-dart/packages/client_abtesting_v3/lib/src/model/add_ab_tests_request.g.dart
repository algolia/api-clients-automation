// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'add_ab_tests_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AddABTestsRequest _$AddABTestsRequestFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'AddABTestsRequest',
      json,
      ($checkedConvert) {
        final val = AddABTestsRequest(
          name: $checkedConvert('name', (v) => v as String),
          variants: $checkedConvert('variants', (v) => v as List<dynamic>),
          metrics: $checkedConvert(
              'metrics',
              (v) => (v as List<dynamic>)
                  .map((e) => CreateMetric.fromJson(e as Map<String, dynamic>))
                  .toList()),
          configuration: $checkedConvert(
              'configuration',
              (v) => v == null
                  ? null
                  : ABTestConfiguration.fromJson(v as Map<String, dynamic>)),
          endAt: $checkedConvert('endAt', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$AddABTestsRequestToJson(AddABTestsRequest instance) {
  final val = <String, dynamic>{
    'name': instance.name,
    'variants': instance.variants.toList(),
    'metrics': instance.metrics.map((e) => e.toJson()).toList(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('configuration', instance.configuration?.toJson());
  val['endAt'] = instance.endAt;
  return val;
}
