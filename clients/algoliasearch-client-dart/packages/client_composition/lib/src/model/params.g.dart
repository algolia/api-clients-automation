// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'params.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Params _$ParamsFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Params',
      json,
      ($checkedConvert) {
        final val = Params(
          query: $checkedConvert('query', (v) => v as String?),
          filters: $checkedConvert('filters', (v) => v as String?),
          page: $checkedConvert('page', (v) => (v as num?)?.toInt()),
          getRankingInfo: $checkedConvert('getRankingInfo', (v) => v as bool?),
          relevancyStrictness: $checkedConvert(
              'relevancyStrictness', (v) => (v as num?)?.toInt()),
          facetFilters: $checkedConvert('facetFilters', (v) => v),
          optionalFilters: $checkedConvert('optionalFilters', (v) => v),
          numericFilters: $checkedConvert('numericFilters', (v) => v),
          hitsPerPage:
              $checkedConvert('hitsPerPage', (v) => (v as num?)?.toInt()),
          aroundLatLng: $checkedConvert('aroundLatLng', (v) => v as String?),
          aroundLatLngViaIP:
              $checkedConvert('aroundLatLngViaIP', (v) => v as bool?),
          aroundRadius: $checkedConvert('aroundRadius', (v) => v),
          aroundPrecision: $checkedConvert('aroundPrecision', (v) => v),
          minimumAroundRadius: $checkedConvert(
              'minimumAroundRadius', (v) => (v as num?)?.toInt()),
          insideBoundingBox: $checkedConvert('insideBoundingBox', (v) => v),
          insidePolygon: $checkedConvert(
              'insidePolygon',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => (e as List<dynamic>)
                      .map((e) => (e as num).toDouble())
                      .toList())
                  .toList()),
          queryLanguages: $checkedConvert(
              'queryLanguages',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => $enumDecode(_$SupportedLanguageEnumMap, e))
                  .toList()),
          naturalLanguages: $checkedConvert(
              'naturalLanguages',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => $enumDecode(_$SupportedLanguageEnumMap, e))
                  .toList()),
          enableRules: $checkedConvert('enableRules', (v) => v as bool?),
          ruleContexts: $checkedConvert('ruleContexts',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          userToken: $checkedConvert('userToken', (v) => v as String?),
          clickAnalytics: $checkedConvert('clickAnalytics', (v) => v as bool?),
          analytics: $checkedConvert('analytics', (v) => v as bool?),
          analyticsTags: $checkedConvert('analyticsTags',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          enableABTest: $checkedConvert('enableABTest', (v) => v as bool?),
          enableReRanking:
              $checkedConvert('enableReRanking', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$ParamsToJson(Params instance) => <String, dynamic>{
      if (instance.query case final value?) 'query': value,
      if (instance.filters case final value?) 'filters': value,
      if (instance.page case final value?) 'page': value,
      if (instance.getRankingInfo case final value?) 'getRankingInfo': value,
      if (instance.relevancyStrictness case final value?)
        'relevancyStrictness': value,
      if (instance.facetFilters case final value?) 'facetFilters': value,
      if (instance.optionalFilters case final value?) 'optionalFilters': value,
      if (instance.numericFilters case final value?) 'numericFilters': value,
      if (instance.hitsPerPage case final value?) 'hitsPerPage': value,
      if (instance.aroundLatLng case final value?) 'aroundLatLng': value,
      if (instance.aroundLatLngViaIP case final value?)
        'aroundLatLngViaIP': value,
      if (instance.aroundRadius case final value?) 'aroundRadius': value,
      if (instance.aroundPrecision case final value?) 'aroundPrecision': value,
      if (instance.minimumAroundRadius case final value?)
        'minimumAroundRadius': value,
      if (instance.insideBoundingBox case final value?)
        'insideBoundingBox': value,
      if (instance.insidePolygon case final value?) 'insidePolygon': value,
      if (instance.queryLanguages?.map((e) => e.toJson()).toList()
          case final value?)
        'queryLanguages': value,
      if (instance.naturalLanguages?.map((e) => e.toJson()).toList()
          case final value?)
        'naturalLanguages': value,
      if (instance.enableRules case final value?) 'enableRules': value,
      if (instance.ruleContexts case final value?) 'ruleContexts': value,
      if (instance.userToken case final value?) 'userToken': value,
      if (instance.clickAnalytics case final value?) 'clickAnalytics': value,
      if (instance.analytics case final value?) 'analytics': value,
      if (instance.analyticsTags case final value?) 'analyticsTags': value,
      if (instance.enableABTest case final value?) 'enableABTest': value,
      if (instance.enableReRanking case final value?) 'enableReRanking': value,
    };

const _$SupportedLanguageEnumMap = {
  SupportedLanguage.af: 'af',
  SupportedLanguage.ar: 'ar',
  SupportedLanguage.az: 'az',
  SupportedLanguage.bg: 'bg',
  SupportedLanguage.bn: 'bn',
  SupportedLanguage.ca: 'ca',
  SupportedLanguage.cs: 'cs',
  SupportedLanguage.cy: 'cy',
  SupportedLanguage.da: 'da',
  SupportedLanguage.de: 'de',
  SupportedLanguage.el: 'el',
  SupportedLanguage.en: 'en',
  SupportedLanguage.eo: 'eo',
  SupportedLanguage.es: 'es',
  SupportedLanguage.et: 'et',
  SupportedLanguage.eu: 'eu',
  SupportedLanguage.fa: 'fa',
  SupportedLanguage.fi: 'fi',
  SupportedLanguage.fo: 'fo',
  SupportedLanguage.fr: 'fr',
  SupportedLanguage.ga: 'ga',
  SupportedLanguage.gl: 'gl',
  SupportedLanguage.he: 'he',
  SupportedLanguage.hi: 'hi',
  SupportedLanguage.hu: 'hu',
  SupportedLanguage.hy: 'hy',
  SupportedLanguage.id: 'id',
  SupportedLanguage.is_: 'is',
  SupportedLanguage.it: 'it',
  SupportedLanguage.ja: 'ja',
  SupportedLanguage.ka: 'ka',
  SupportedLanguage.kk: 'kk',
  SupportedLanguage.ko: 'ko',
  SupportedLanguage.ku: 'ku',
  SupportedLanguage.ky: 'ky',
  SupportedLanguage.lt: 'lt',
  SupportedLanguage.lv: 'lv',
  SupportedLanguage.mi: 'mi',
  SupportedLanguage.mn: 'mn',
  SupportedLanguage.mr: 'mr',
  SupportedLanguage.ms: 'ms',
  SupportedLanguage.mt: 'mt',
  SupportedLanguage.nb: 'nb',
  SupportedLanguage.nl: 'nl',
  SupportedLanguage.no: 'no',
  SupportedLanguage.ns: 'ns',
  SupportedLanguage.pl: 'pl',
  SupportedLanguage.ps: 'ps',
  SupportedLanguage.pt: 'pt',
  SupportedLanguage.ptBr: 'pt-br',
  SupportedLanguage.qu: 'qu',
  SupportedLanguage.ro: 'ro',
  SupportedLanguage.ru: 'ru',
  SupportedLanguage.sk: 'sk',
  SupportedLanguage.sq: 'sq',
  SupportedLanguage.sv: 'sv',
  SupportedLanguage.sw: 'sw',
  SupportedLanguage.ta: 'ta',
  SupportedLanguage.te: 'te',
  SupportedLanguage.th: 'th',
  SupportedLanguage.tl: 'tl',
  SupportedLanguage.tn: 'tn',
  SupportedLanguage.tr: 'tr',
  SupportedLanguage.tt: 'tt',
  SupportedLanguage.uk: 'uk',
  SupportedLanguage.ur: 'ur',
  SupportedLanguage.uz: 'uz',
  SupportedLanguage.zh: 'zh',
};
