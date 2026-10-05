// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'injection_main_search.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

InjectionMainSearch _$InjectionMainSearchFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'InjectionMainSearch',
      json,
      ($checkedConvert) {
        final val = InjectionMainSearch(
          index: $checkedConvert('index', (v) => v as String),
          params: $checkedConvert(
              'params',
              (v) => v == null
                  ? null
                  : MainInjectionQueryParameters.fromJson(
                      v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$InjectionMainSearchToJson(InjectionMainSearch instance) {
  final val = <String, dynamic>{
    'index': instance.index,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('params', instance.params?.toJson());
  return val;
}
