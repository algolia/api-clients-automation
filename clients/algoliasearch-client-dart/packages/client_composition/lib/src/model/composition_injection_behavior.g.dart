// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'composition_injection_behavior.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CompositionInjectionBehavior _$CompositionInjectionBehaviorFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'CompositionInjectionBehavior',
      json,
      ($checkedConvert) {
        final val = CompositionInjectionBehavior(
          injection: $checkedConvert('injection',
              (v) => Injection.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$CompositionInjectionBehaviorToJson(
        CompositionInjectionBehavior instance) =>
    <String, dynamic>{
      'injection': instance.injection.toJson(),
    };
