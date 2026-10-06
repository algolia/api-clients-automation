// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'result_card.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ResultCard _$ResultCardFromJson(Map<String, dynamic> json) => $checkedCreate(
      'ResultCard',
      json,
      ($checkedConvert) {
        final val = ResultCard(
          enabled: $checkedConvert('enabled', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$ResultCardToJson(ResultCard instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('enabled', instance.enabled);
  return val;
}
