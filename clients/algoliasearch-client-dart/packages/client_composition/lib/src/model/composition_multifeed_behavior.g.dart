// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'composition_multifeed_behavior.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CompositionMultifeedBehavior _$CompositionMultifeedBehaviorFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'CompositionMultifeedBehavior',
      json,
      ($checkedConvert) {
        final val = CompositionMultifeedBehavior(
          multifeed: $checkedConvert('multifeed',
              (v) => Multifeed.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$CompositionMultifeedBehaviorToJson(
        CompositionMultifeedBehavior instance) =>
    <String, dynamic>{
      'multifeed': instance.multifeed.toJson(),
    };
