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

Map<String, dynamic> _$ConsequenceToJson(Consequence instance) =>
    <String, dynamic>{
      if (instance.hide?.map((e) => e.toJson()).toList() case final value?)
        'hide': value,
      if (instance.promote?.map((e) => e.toJson()).toList() case final value?)
        'promote': value,
      if (instance.params?.toJson() case final value?) 'params': value,
    };
