// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'index_search_parameters.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

IndexSearchParameters _$IndexSearchParametersFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'IndexSearchParameters',
      json,
      ($checkedConvert) {
        final val = IndexSearchParameters(
          query: $checkedConvert(
              'query',
              (v) => v == null
                  ? null
                  : TextParam.fromJson(v as Map<String, dynamic>)),
          hitsPerPage: $checkedConvert(
              'hitsPerPage',
              (v) => v == null
                  ? null
                  : NumberParam.fromJson(v as Map<String, dynamic>)),
          page: $checkedConvert(
              'page',
              (v) => v == null
                  ? null
                  : NumberParam.fromJson(v as Map<String, dynamic>)),
          attributesToRetrieve: $checkedConvert(
              'attributesToRetrieve',
              (v) => v == null
                  ? null
                  : StringArrayParam.fromJson(v as Map<String, dynamic>)),
          responseFields: $checkedConvert(
              'responseFields',
              (v) => v == null
                  ? null
                  : StringArrayParam.fromJson(v as Map<String, dynamic>)),
          facets: $checkedConvert(
              'facets',
              (v) => v == null
                  ? null
                  : FacetsParam.fromJson(v as Map<String, dynamic>)),
          custom: $checkedConvert(
              'custom',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$IndexSearchParametersToJson(
    IndexSearchParameters instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('query', instance.query?.toJson());
  writeNotNull('hitsPerPage', instance.hitsPerPage?.toJson());
  writeNotNull('page', instance.page?.toJson());
  writeNotNull('attributesToRetrieve', instance.attributesToRetrieve?.toJson());
  writeNotNull('responseFields', instance.responseFields?.toJson());
  writeNotNull('facets', instance.facets?.toJson());
  writeNotNull('custom', instance.custom);
  return val;
}
