// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'composition_behavior.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CompositionBehavior _$CompositionBehaviorFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'CompositionBehavior',
      json,
      ($checkedConvert) {
        final val = CompositionBehavior(
          injection: $checkedConvert('injection',
              (v) => Injection.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$CompositionBehaviorToJson(
        CompositionBehavior instance) =>
    <String, dynamic>{
      'injection': instance.injection.toJson(),
    };
