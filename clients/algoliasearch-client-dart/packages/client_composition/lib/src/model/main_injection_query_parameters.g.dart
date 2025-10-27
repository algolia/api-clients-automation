// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'main_injection_query_parameters.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MainInjectionQueryParameters _$MainInjectionQueryParametersFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'MainInjectionQueryParameters',
      json,
      ($checkedConvert) {
        final val = MainInjectionQueryParameters(
          advancedSyntax: $checkedConvert('advancedSyntax', (v) => v as bool?),
          advancedSyntaxFeatures: $checkedConvert(
              'advancedSyntaxFeatures',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => $enumDecode(_$AdvancedSyntaxFeaturesEnumMap, e))
                  .toList()),
          allowTyposOnNumericTokens:
              $checkedConvert('allowTyposOnNumericTokens', (v) => v as bool?),
          alternativesAsExact: $checkedConvert(
              'alternativesAsExact',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => $enumDecode(_$AlternativesAsExactEnumMap, e))
                  .toList()),
          analytics: $checkedConvert('analytics', (v) => v as bool?),
          attributeCriteriaComputedByMinProximity: $checkedConvert(
              'attributeCriteriaComputedByMinProximity', (v) => v as bool?),
          attributesToHighlight: $checkedConvert('attributesToHighlight',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          attributesToRetrieve: $checkedConvert('attributesToRetrieve',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          attributesToSnippet: $checkedConvert('attributesToSnippet',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          clickAnalytics: $checkedConvert('clickAnalytics', (v) => v as bool?),
          decompoundQuery:
              $checkedConvert('decompoundQuery', (v) => v as bool?),
          disableExactOnAttributes: $checkedConvert('disableExactOnAttributes',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          disableTypoToleranceOnAttributes: $checkedConvert(
              'disableTypoToleranceOnAttributes',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          distinct: $checkedConvert('distinct', (v) => v),
          enableABTest: $checkedConvert('enableABTest', (v) => v as bool?),
          enablePersonalization:
              $checkedConvert('enablePersonalization', (v) => v as bool?),
          enableReRanking:
              $checkedConvert('enableReRanking', (v) => v as bool?),
          enableRules: $checkedConvert('enableRules', (v) => v as bool?),
          exactOnSingleWordQuery: $checkedConvert('exactOnSingleWordQuery',
              (v) => $enumDecodeNullable(_$ExactOnSingleWordQueryEnumMap, v)),
          facetFilters: $checkedConvert('facetFilters', (v) => v),
          filters: $checkedConvert('filters', (v) => v as String?),
          getRankingInfo: $checkedConvert('getRankingInfo', (v) => v as bool?),
          highlightPostTag:
              $checkedConvert('highlightPostTag', (v) => v as String?),
          highlightPreTag:
              $checkedConvert('highlightPreTag', (v) => v as String?),
          ignorePlurals: $checkedConvert('ignorePlurals', (v) => v),
          maxFacetHits:
              $checkedConvert('maxFacetHits', (v) => (v as num?)?.toInt()),
          minProximity:
              $checkedConvert('minProximity', (v) => (v as num?)?.toInt()),
          minWordSizefor1Typo: $checkedConvert(
              'minWordSizefor1Typo', (v) => (v as num?)?.toInt()),
          minWordSizefor2Typos: $checkedConvert(
              'minWordSizefor2Typos', (v) => (v as num?)?.toInt()),
          naturalLanguages: $checkedConvert(
              'naturalLanguages',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => $enumDecode(_$SupportedLanguageEnumMap, e))
                  .toList()),
          numericFilters: $checkedConvert('numericFilters', (v) => v),
          optionalFilters: $checkedConvert('optionalFilters', (v) => v),
          optionalWords: $checkedConvert('optionalWords', (v) => v),
          percentileComputation:
              $checkedConvert('percentileComputation', (v) => v as bool?),
          personalizationImpact: $checkedConvert(
              'personalizationImpact', (v) => (v as num?)?.toInt()),
          queryLanguages: $checkedConvert(
              'queryLanguages',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => $enumDecode(_$SupportedLanguageEnumMap, e))
                  .toList()),
          queryType: $checkedConvert(
              'queryType', (v) => $enumDecodeNullable(_$QueryTypeEnumMap, v)),
          removeStopWords: $checkedConvert('removeStopWords', (v) => v),
          removeWordsIfNoResults: $checkedConvert('removeWordsIfNoResults',
              (v) => $enumDecodeNullable(_$RemoveWordsIfNoResultsEnumMap, v)),
          replaceSynonymsInHighlight:
              $checkedConvert('replaceSynonymsInHighlight', (v) => v as bool?),
          responseFields: $checkedConvert('responseFields',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          restrictHighlightAndSnippetArrays: $checkedConvert(
              'restrictHighlightAndSnippetArrays', (v) => v as bool?),
          restrictSearchableAttributes: $checkedConvert(
              'restrictSearchableAttributes',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          ruleContexts: $checkedConvert('ruleContexts',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          snippetEllipsisText:
              $checkedConvert('snippetEllipsisText', (v) => v as String?),
          synonyms: $checkedConvert('synonyms', (v) => v as bool?),
          typoTolerance: $checkedConvert('typoTolerance', (v) => v),
          facetingAfterDistinct:
              $checkedConvert('facetingAfterDistinct', (v) => v as bool?),
          facets: $checkedConvert('facets',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          hitsPerPage:
              $checkedConvert('hitsPerPage', (v) => (v as num?)?.toInt()),
          maxValuesPerFacet:
              $checkedConvert('maxValuesPerFacet', (v) => (v as num?)?.toInt()),
          renderingContent: $checkedConvert(
              'renderingContent',
              (v) => v == null
                  ? null
                  : RenderingContent.fromJson(v as Map<String, dynamic>)),
          sortFacetValuesBy:
              $checkedConvert('sortFacetValuesBy', (v) => v as String?),
          sumOrFiltersScores:
              $checkedConvert('sumOrFiltersScores', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$MainInjectionQueryParametersToJson(
    MainInjectionQueryParameters instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('advancedSyntax', instance.advancedSyntax);
  writeNotNull('advancedSyntaxFeatures',
      instance.advancedSyntaxFeatures?.map((e) => e.toJson()).toList());
  writeNotNull('allowTyposOnNumericTokens', instance.allowTyposOnNumericTokens);
  writeNotNull('alternativesAsExact',
      instance.alternativesAsExact?.map((e) => e.toJson()).toList());
  writeNotNull('analytics', instance.analytics);
  writeNotNull('attributeCriteriaComputedByMinProximity',
      instance.attributeCriteriaComputedByMinProximity);
  writeNotNull('attributesToHighlight', instance.attributesToHighlight);
  writeNotNull('attributesToRetrieve', instance.attributesToRetrieve);
  writeNotNull('attributesToSnippet', instance.attributesToSnippet);
  writeNotNull('clickAnalytics', instance.clickAnalytics);
  writeNotNull('decompoundQuery', instance.decompoundQuery);
  writeNotNull('disableExactOnAttributes', instance.disableExactOnAttributes);
  writeNotNull('disableTypoToleranceOnAttributes',
      instance.disableTypoToleranceOnAttributes);
  writeNotNull('distinct', instance.distinct);
  writeNotNull('enableABTest', instance.enableABTest);
  writeNotNull('enablePersonalization', instance.enablePersonalization);
  writeNotNull('enableReRanking', instance.enableReRanking);
  writeNotNull('enableRules', instance.enableRules);
  writeNotNull(
      'exactOnSingleWordQuery', instance.exactOnSingleWordQuery?.toJson());
  writeNotNull('facetFilters', instance.facetFilters);
  writeNotNull('filters', instance.filters);
  writeNotNull('getRankingInfo', instance.getRankingInfo);
  writeNotNull('highlightPostTag', instance.highlightPostTag);
  writeNotNull('highlightPreTag', instance.highlightPreTag);
  writeNotNull('ignorePlurals', instance.ignorePlurals);
  writeNotNull('maxFacetHits', instance.maxFacetHits);
  writeNotNull('minProximity', instance.minProximity);
  writeNotNull('minWordSizefor1Typo', instance.minWordSizefor1Typo);
  writeNotNull('minWordSizefor2Typos', instance.minWordSizefor2Typos);
  writeNotNull('naturalLanguages',
      instance.naturalLanguages?.map((e) => e.toJson()).toList());
  writeNotNull('numericFilters', instance.numericFilters);
  writeNotNull('optionalFilters', instance.optionalFilters);
  writeNotNull('optionalWords', instance.optionalWords);
  writeNotNull('percentileComputation', instance.percentileComputation);
  writeNotNull('personalizationImpact', instance.personalizationImpact);
  writeNotNull('queryLanguages',
      instance.queryLanguages?.map((e) => e.toJson()).toList());
  writeNotNull('queryType', instance.queryType?.toJson());
  writeNotNull('removeStopWords', instance.removeStopWords);
  writeNotNull(
      'removeWordsIfNoResults', instance.removeWordsIfNoResults?.toJson());
  writeNotNull(
      'replaceSynonymsInHighlight', instance.replaceSynonymsInHighlight);
  writeNotNull('responseFields', instance.responseFields);
  writeNotNull('restrictHighlightAndSnippetArrays',
      instance.restrictHighlightAndSnippetArrays);
  writeNotNull(
      'restrictSearchableAttributes', instance.restrictSearchableAttributes);
  writeNotNull('ruleContexts', instance.ruleContexts);
  writeNotNull('snippetEllipsisText', instance.snippetEllipsisText);
  writeNotNull('synonyms', instance.synonyms);
  writeNotNull('typoTolerance', instance.typoTolerance);
  writeNotNull('facetingAfterDistinct', instance.facetingAfterDistinct);
  writeNotNull('facets', instance.facets);
  writeNotNull('hitsPerPage', instance.hitsPerPage);
  writeNotNull('maxValuesPerFacet', instance.maxValuesPerFacet);
  writeNotNull('renderingContent', instance.renderingContent?.toJson());
  writeNotNull('sortFacetValuesBy', instance.sortFacetValuesBy);
  writeNotNull('sumOrFiltersScores', instance.sumOrFiltersScores);
  return val;
}

const _$AdvancedSyntaxFeaturesEnumMap = {
  AdvancedSyntaxFeatures.exactPhrase: 'exactPhrase',
  AdvancedSyntaxFeatures.excludeWords: 'excludeWords',
};

const _$AlternativesAsExactEnumMap = {
  AlternativesAsExact.ignorePlurals: 'ignorePlurals',
  AlternativesAsExact.singleWordSynonym: 'singleWordSynonym',
  AlternativesAsExact.multiWordsSynonym: 'multiWordsSynonym',
  AlternativesAsExact.ignoreConjugations: 'ignoreConjugations',
};

const _$ExactOnSingleWordQueryEnumMap = {
  ExactOnSingleWordQuery.attribute: 'attribute',
  ExactOnSingleWordQuery.none: 'none',
  ExactOnSingleWordQuery.word: 'word',
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

const _$QueryTypeEnumMap = {
  QueryType.prefixLast: 'prefixLast',
  QueryType.prefixAll: 'prefixAll',
  QueryType.prefixNone: 'prefixNone',
};

const _$RemoveWordsIfNoResultsEnumMap = {
  RemoveWordsIfNoResults.none: 'none',
  RemoveWordsIfNoResults.lastWords: 'lastWords',
  RemoveWordsIfNoResults.firstWords: 'firstWords',
  RemoveWordsIfNoResults.allOptional: 'allOptional',
};
