// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'results_compositions_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ResultsCompositionsResponse _$ResultsCompositionsResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ResultsCompositionsResponse',
      json,
      ($checkedConvert) {
        final val = ResultsCompositionsResponse(
          compositions: $checkedConvert(
              'compositions',
              (v) => (v as Map<String, dynamic>).map(
                    (k, e) => MapEntry(
                        k,
                        ResultsCompositionInfoResponse.fromJson(
                            e as Map<String, dynamic>)),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$ResultsCompositionsResponseToJson(
        ResultsCompositionsResponse instance) =>
    <String, dynamic>{
      'compositions':
          instance.compositions.map((k, e) => MapEntry(k, e.toJson())),
    };
