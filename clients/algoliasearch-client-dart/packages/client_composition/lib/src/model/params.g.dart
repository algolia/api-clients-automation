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
          analytics: $checkedConvert('analytics', (v) => v as bool?),
          analyticsTags: $checkedConvert('analyticsTags',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          aroundLatLng: $checkedConvert('aroundLatLng', (v) => v as String?),
          aroundLatLngViaIP:
              $checkedConvert('aroundLatLngViaIP', (v) => v as bool?),
          aroundRadius: $checkedConvert('aroundRadius', (v) => v),
          aroundPrecision: $checkedConvert('aroundPrecision', (v) => v),
          clickAnalytics: $checkedConvert('clickAnalytics', (v) => v as bool?),
          enableABTest: $checkedConvert('enableABTest', (v) => v as bool?),
          enablePersonalization:
              $checkedConvert('enablePersonalization', (v) => v as bool?),
          enableReRanking:
              $checkedConvert('enableReRanking', (v) => v as bool?),
          enableRules: $checkedConvert('enableRules', (v) => v as bool?),
          facetFilters: $checkedConvert('facetFilters', (v) => v),
          facets: $checkedConvert('facets',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          filters: $checkedConvert('filters', (v) => v as String?),
          getRankingInfo: $checkedConvert('getRankingInfo', (v) => v as bool?),
          hitsPerPage:
              $checkedConvert('hitsPerPage', (v) => (v as num?)?.toInt()),
          injectedItems: $checkedConvert(
              'injectedItems',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(
                        k,
                        ExternalInjectedItem.fromJson(
                            e as Map<String, dynamic>)),
                  )),
          insideBoundingBox: $checkedConvert('insideBoundingBox', (v) => v),
          insidePolygon: $checkedConvert(
              'insidePolygon',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => (e as List<dynamic>)
                      .map((e) => (e as num).toDouble())
                      .toList())
                  .toList()),
          minimumAroundRadius: $checkedConvert(
              'minimumAroundRadius', (v) => (v as num?)?.toInt()),
          naturalLanguages: $checkedConvert(
              'naturalLanguages',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => $enumDecode(_$SupportedLanguageEnumMap, e))
                  .toList()),
          numericFilters: $checkedConvert('numericFilters', (v) => v),
          optionalFilters: $checkedConvert('optionalFilters', (v) => v),
          page: $checkedConvert('page', (v) => (v as num?)?.toInt()),
          query: $checkedConvert('query', (v) => v as String?),
          queryLanguages: $checkedConvert(
              'queryLanguages',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => $enumDecode(_$SupportedLanguageEnumMap, e))
                  .toList()),
          relevancyStrictness: $checkedConvert(
              'relevancyStrictness', (v) => (v as num?)?.toInt()),
          ruleContexts: $checkedConvert('ruleContexts',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          sortBy: $checkedConvert('sortBy', (v) => v as String?),
          userToken: $checkedConvert('userToken', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$ParamsToJson(Params instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('analytics', instance.analytics);
  writeNotNull('analyticsTags', instance.analyticsTags);
  writeNotNull('aroundLatLng', instance.aroundLatLng);
  writeNotNull('aroundLatLngViaIP', instance.aroundLatLngViaIP);
  writeNotNull('aroundRadius', instance.aroundRadius);
  writeNotNull('aroundPrecision', instance.aroundPrecision);
  writeNotNull('clickAnalytics', instance.clickAnalytics);
  writeNotNull('enableABTest', instance.enableABTest);
  writeNotNull('enablePersonalization', instance.enablePersonalization);
  writeNotNull('enableReRanking', instance.enableReRanking);
  writeNotNull('enableRules', instance.enableRules);
  writeNotNull('facetFilters', instance.facetFilters);
  writeNotNull('facets', instance.facets);
  writeNotNull('filters', instance.filters);
  writeNotNull('getRankingInfo', instance.getRankingInfo);
  writeNotNull('hitsPerPage', instance.hitsPerPage);
  writeNotNull('injectedItems',
      instance.injectedItems?.map((k, e) => MapEntry(k, e.toJson())));
  writeNotNull('insideBoundingBox', instance.insideBoundingBox);
  writeNotNull('insidePolygon', instance.insidePolygon);
  writeNotNull('minimumAroundRadius', instance.minimumAroundRadius);
  writeNotNull('naturalLanguages',
      instance.naturalLanguages?.map((e) => e.toJson()).toList());
  writeNotNull('numericFilters', instance.numericFilters);
  writeNotNull('optionalFilters', instance.optionalFilters);
  writeNotNull('page', instance.page);
  writeNotNull('query', instance.query);
  writeNotNull('queryLanguages',
      instance.queryLanguages?.map((e) => e.toJson()).toList());
  writeNotNull('relevancyStrictness', instance.relevancyStrictness);
  writeNotNull('ruleContexts', instance.ruleContexts);
  writeNotNull('sortBy', instance.sortBy);
  writeNotNull('userToken', instance.userToken);
  return val;
}

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
