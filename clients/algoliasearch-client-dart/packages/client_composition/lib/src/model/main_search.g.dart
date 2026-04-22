// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'main_search.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MainSearch _$MainSearchFromJson(Map<String, dynamic> json) => $checkedCreate(
      'MainSearch',
      json,
      ($checkedConvert) {
        final val = MainSearch(
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

Map<String, dynamic> _$MainSearchToJson(MainSearch instance) {
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
