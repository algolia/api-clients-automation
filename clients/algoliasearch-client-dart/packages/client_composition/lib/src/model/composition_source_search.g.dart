// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'composition_source_search.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CompositionSourceSearch _$CompositionSourceSearchFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'CompositionSourceSearch',
      json,
      ($checkedConvert) {
        final val = CompositionSourceSearch(
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

Map<String, dynamic> _$CompositionSourceSearchToJson(
    CompositionSourceSearch instance) {
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
