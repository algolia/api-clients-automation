// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'redirect.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Redirect _$RedirectFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Redirect',
      json,
      ($checkedConvert) {
        final val = Redirect(
          index: $checkedConvert(
              'index',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => RedirectRuleIndexMetadata.fromJson(
                      e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$RedirectToJson(Redirect instance) => <String, dynamic>{
      if (instance.index?.map((e) => e.toJson()).toList() case final value?)
        'index': value,
    };
