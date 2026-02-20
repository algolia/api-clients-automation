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
          feedID: $checkedConvert('feedID', (v) => v as String?),
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
    ResultsCompositionsResponse instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('feedID', instance.feedID);
  val['compositions'] =
      instance.compositions.map((k, e) => MapEntry(k, e.toJson()));
  return val;
}
