// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'composition_base_search_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CompositionBaseSearchResponse _$CompositionBaseSearchResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'CompositionBaseSearchResponse',
      json,
      ($checkedConvert) {
        final val = CompositionBaseSearchResponse(
          compositions: $checkedConvert(
              'compositions',
              (v) => v == null
                  ? null
                  : CompositionsSearchResponse.fromJson(
                      v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$CompositionBaseSearchResponseToJson(
    CompositionBaseSearchResponse instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('compositions', instance.compositions?.toJson());
  return val;
}
