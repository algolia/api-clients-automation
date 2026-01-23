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
          injection: $checkedConvert(
              'injection',
              (v) => v == null
                  ? null
                  : Injection.fromJson(v as Map<String, dynamic>)),
          multifeed: $checkedConvert(
              'multifeed',
              (v) => v == null
                  ? null
                  : Multifeed.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$CompositionBehaviorToJson(CompositionBehavior instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('injection', instance.injection?.toJson());
  writeNotNull('multifeed', instance.multifeed?.toJson());
  return val;
}
