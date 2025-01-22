// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'results_injected_item_applied_rules_info_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ResultsInjectedItemAppliedRulesInfoResponse
    _$ResultsInjectedItemAppliedRulesInfoResponseFromJson(
            Map<String, dynamic> json) =>
        $checkedCreate(
          'ResultsInjectedItemAppliedRulesInfoResponse',
          json,
          ($checkedConvert) {
            final val = ResultsInjectedItemAppliedRulesInfoResponse(
              objectID: $checkedConvert('objectID', (v) => v as String),
            );
            return val;
          },
        );

Map<String, dynamic> _$ResultsInjectedItemAppliedRulesInfoResponseToJson(
        ResultsInjectedItemAppliedRulesInfoResponse instance) =>
    <String, dynamic>{
      'objectID': instance.objectID,
    };
