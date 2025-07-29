// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'estimate_ab_test_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

EstimateABTestResponse _$EstimateABTestResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'EstimateABTestResponse',
      json,
      ($checkedConvert) {
        final val = EstimateABTestResponse(
          durationDays: $checkedConvert('durationDays', (v) => v as int?),
          sampleSizes: $checkedConvert('sampleSizes',
              (v) => (v as List<dynamic>?)?.map((e) => e as int).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$EstimateABTestResponseToJson(
    EstimateABTestResponse instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('durationDays', instance.durationDays);
  writeNotNull('sampleSizes', instance.sampleSizes);
  return val;
}
