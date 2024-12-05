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
          params: $checkedConvert(
              'params',
              (v) => v == null
                  ? null
                  : ConsequenceParams.fromJson(v as Map<String, dynamic>)),
          promote: $checkedConvert('promote', (v) => v as List<dynamic>?),
          filterPromotes: $checkedConvert('filterPromotes', (v) => v as bool?),
          hide: $checkedConvert(
              'hide',
              (v) => (v as List<dynamic>?)
                  ?.map((e) =>
                      ConsequenceHide.fromJson(e as Map<String, dynamic>))
                  .toList()),
          userData: $checkedConvert('userData', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$ConsequenceToJson(Consequence instance) =>
    <String, dynamic>{
      if (instance.params?.toJson() case final value?) 'params': value,
      if (instance.promote?.toList() case final value?) 'promote': value,
      if (instance.filterPromotes case final value?) 'filterPromotes': value,
      if (instance.hide?.map((e) => e.toJson()).toList() case final value?)
        'hide': value,
      if (instance.userData case final value?) 'userData': value,
    };
