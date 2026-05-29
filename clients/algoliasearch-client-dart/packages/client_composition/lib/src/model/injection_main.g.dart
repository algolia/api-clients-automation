// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'injection_main.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

InjectionMain _$InjectionMainFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'InjectionMain',
      json,
      ($checkedConvert) {
        final val = InjectionMain(
          source: $checkedConvert('source', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$InjectionMainToJson(InjectionMain instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('source', instance.source);
  return val;
}
