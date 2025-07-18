// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'consequence.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Consequence _$ConsequenceFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Consequence',
      json,
      ($checkedConvert) {
        final val = Consequence(
          hide: $checkedConvert(
              'hide',
              (v) => (v as List<dynamic>?)
                  ?.map((e) =>
                      HideConsequenceObject.fromJson(e as Map<String, dynamic>))
                  .toList()),
          promote: $checkedConvert(
              'promote',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => PromoteConsequenceObject.fromJson(
                      e as Map<String, dynamic>))
                  .toList()),
          params: $checkedConvert(
              'params',
              (v) => v == null
                  ? null
                  : ParamsConsequence.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$ConsequenceToJson(Consequence instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('hide', instance.hide?.map((e) => e.toJson()).toList());
  writeNotNull('promote', instance.promote?.map((e) => e.toJson()).toList());
  writeNotNull('params', instance.params?.toJson());
  return val;
}
