// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'estimate_ab_test_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

EstimateABTestRequest _$EstimateABTestRequestFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'EstimateABTestRequest',
      json,
      ($checkedConvert) {
        final val = EstimateABTestRequest(
          configuration: $checkedConvert('configuration',
              (v) => EstimateConfiguration.fromJson(v as Map<String, dynamic>)),
          variants: $checkedConvert('variants', (v) => v as List<dynamic>),
        );
        return val;
      },
    );

Map<String, dynamic> _$EstimateABTestRequestToJson(
        EstimateABTestRequest instance) =>
    <String, dynamic>{
      'configuration': instance.configuration.toJson(),
      'variants': instance.variants.toList(),
    };
