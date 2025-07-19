// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_for_facet_values_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchForFacetValuesRequest _$SearchForFacetValuesRequestFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchForFacetValuesRequest',
      json,
      ($checkedConvert) {
        final val = SearchForFacetValuesRequest(
          params: $checkedConvert(
              'params',
              (v) => v == null
                  ? null
                  : SearchForFacetValuesParams.fromJson(
                      v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchForFacetValuesRequestToJson(
    SearchForFacetValuesRequest instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('params', instance.params?.toJson());
  return val;
}
