// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'results_composition_info_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ResultsCompositionInfoResponse _$ResultsCompositionInfoResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ResultsCompositionInfoResponse',
      json,
      ($checkedConvert) {
        final val = ResultsCompositionInfoResponse(
          injectedItems: $checkedConvert(
              'injectedItems',
              (v) => (v as List<dynamic>)
                  .map((e) => ResultsInjectedItemInfoResponse.fromJson(
                      e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$ResultsCompositionInfoResponseToJson(
        ResultsCompositionInfoResponse instance) =>
    <String, dynamic>{
      'injectedItems': instance.injectedItems.map((e) => e.toJson()).toList(),
    };
