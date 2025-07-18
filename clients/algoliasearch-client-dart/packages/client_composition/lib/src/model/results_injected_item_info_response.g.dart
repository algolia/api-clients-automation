// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'results_injected_item_info_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ResultsInjectedItemInfoResponse _$ResultsInjectedItemInfoResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ResultsInjectedItemInfoResponse',
      json,
      ($checkedConvert) {
        final val = ResultsInjectedItemInfoResponse(
          key: $checkedConvert('key', (v) => v as String),
          appliedRules: $checkedConvert(
              'appliedRules',
              (v) => (v as List<dynamic>?)
                  ?.map((e) =>
                      ResultsInjectedItemAppliedRulesInfoResponse.fromJson(
                          e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

const _$ResultsInjectedItemInfoResponseFieldMap = <String, String>{
  'key': 'key',
  'appliedRules': 'appliedRules',
};

Map<String, dynamic> _$ResultsInjectedItemInfoResponseToJson(
    ResultsInjectedItemInfoResponse instance) {
  final val = <String, dynamic>{
    'key': instance.key,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull(
      'appliedRules', instance.appliedRules?.map((e) => e.toJson()).toList());
  return val;
}
