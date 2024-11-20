// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'base_recommend_search_params.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BaseRecommendSearchParams _$BaseRecommendSearchParamsFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'BaseRecommendSearchParams',
      json,
      ($checkedConvert) {
        final val = BaseRecommendSearchParams(
          similarQuery: $checkedConvert('similarQuery', (v) => v as String?),
          filters: $checkedConvert('filters', (v) => v as String?),
          facetFilters: $checkedConvert('facetFilters', (v) => v),
          optionalFilters: $checkedConvert('optionalFilters', (v) => v),
          numericFilters: $checkedConvert('numericFilters', (v) => v),
          tagFilters: $checkedConvert('tagFilters', (v) => v),
          sumOrFiltersScores:
              $checkedConvert('sumOrFiltersScores', (v) => v as bool?),
          restrictSearchableAttributes: $checkedConvert(
              'restrictSearchableAttributes',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          facets: $checkedConvert('facets',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          facetingAfterDistinct:
              $checkedConvert('facetingAfterDistinct', (v) => v as bool?),
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
          naturalLanguages: $checkedConvert(
              'naturalLanguages',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => $enumDecode(_$SupportedLanguageEnumMap, e))
                  .toList()),
          ruleContexts: $checkedConvert('ruleContexts',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          personalizationImpact: $checkedConvert(
              'personalizationImpact', (v) => (v as num?)?.toInt()),
          userToken: $checkedConvert('userToken', (v) => v as String?),
          getRankingInfo: $checkedConvert('getRankingInfo', (v) => v as bool?),
          synonyms: $checkedConvert('synonyms', (v) => v as bool?),
          clickAnalytics: $checkedConvert('clickAnalytics', (v) => v as bool?),
          analytics: $checkedConvert('analytics', (v) => v as bool?),
          analyticsTags: $checkedConvert('analyticsTags',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          percentileComputation:
              $checkedConvert('percentileComputation', (v) => v as bool?),
          enableABTest: $checkedConvert('enableABTest', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$BaseRecommendSearchParamsToJson(
        BaseRecommendSearchParams instance) =>
    <String, dynamic>{
      if (instance.similarQuery case final value?) 'similarQuery': value,
      if (instance.filters case final value?) 'filters': value,
      if (instance.facetFilters case final value?) 'facetFilters': value,
      if (instance.optionalFilters case final value?) 'optionalFilters': value,
      if (instance.numericFilters case final value?) 'numericFilters': value,
      if (instance.tagFilters case final value?) 'tagFilters': value,
      if (instance.sumOrFiltersScores case final value?)
        'sumOrFiltersScores': value,
      if (instance.restrictSearchableAttributes case final value?)
        'restrictSearchableAttributes': value,
      if (instance.facets case final value?) 'facets': value,
      if (instance.facetingAfterDistinct case final value?)
        'facetingAfterDistinct': value,
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
      if (instance.naturalLanguages?.map((e) => e.toJson()).toList()
          case final value?)
        'naturalLanguages': value,
      if (instance.ruleContexts case final value?) 'ruleContexts': value,
      if (instance.personalizationImpact case final value?)
        'personalizationImpact': value,
      if (instance.userToken case final value?) 'userToken': value,
      if (instance.getRankingInfo case final value?) 'getRankingInfo': value,
      if (instance.synonyms case final value?) 'synonyms': value,
      if (instance.clickAnalytics case final value?) 'clickAnalytics': value,
      if (instance.analytics case final value?) 'analytics': value,
      if (instance.analyticsTags case final value?) 'analyticsTags': value,
      if (instance.percentileComputation case final value?)
        'percentileComputation': value,
      if (instance.enableABTest case final value?) 'enableABTest': value,
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
