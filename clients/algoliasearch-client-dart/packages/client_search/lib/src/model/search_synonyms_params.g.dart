// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_synonyms_params.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchSynonymsParams _$SearchSynonymsParamsFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchSynonymsParams',
      json,
      ($checkedConvert) {
        final val = SearchSynonymsParams(
          query: $checkedConvert('query', (v) => v as String?),
          type: $checkedConvert(
              'type', (v) => $enumDecodeNullable(_$SynonymTypeEnumMap, v)),
          page: $checkedConvert('page', (v) => (v as num?)?.toInt()),
          hitsPerPage:
              $checkedConvert('hitsPerPage', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchSynonymsParamsToJson(
    SearchSynonymsParams instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('query', instance.query);
  writeNotNull('type', instance.type?.toJson());
  writeNotNull('page', instance.page);
  writeNotNull('hitsPerPage', instance.hitsPerPage);
  return val;
}

const _$SynonymTypeEnumMap = {
  SynonymType.synonym: 'synonym',
  SynonymType.onewaysynonym: 'onewaysynonym',
  SynonymType.altcorrection1: 'altcorrection1',
  SynonymType.altcorrection2: 'altcorrection2',
  SynonymType.placeholder: 'placeholder',
  SynonymType.oneWaySynonym: 'oneWaySynonym',
  SynonymType.altCorrection1: 'altCorrection1',
  SynonymType.altCorrection2: 'altCorrection2',
};
