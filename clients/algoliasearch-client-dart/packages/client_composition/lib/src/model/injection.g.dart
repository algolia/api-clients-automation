// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'injection.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Injection _$InjectionFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Injection',
      json,
      ($checkedConvert) {
        final val = Injection(
          main: $checkedConvert(
              'main', (v) => Main.fromJson(v as Map<String, dynamic>)),
          injectedItems: $checkedConvert(
              'injectedItems',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => InjectedItem.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$InjectionToJson(Injection instance) {
  final val = <String, dynamic>{
    'main': instance.main.toJson(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull(
      'injectedItems', instance.injectedItems?.map((e) => e.toJson()).toList());
  return val;
}
