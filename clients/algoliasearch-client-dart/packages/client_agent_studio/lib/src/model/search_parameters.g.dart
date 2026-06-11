// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_parameters.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchParameters _$SearchParametersFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchParameters',
      json,
      ($checkedConvert) {
        final val = SearchParameters(
          queryType: $checkedConvert(
              'queryType', (v) => $enumDecodeNullable(_$QueryTypeEnumMap, v)),
          similarQuery: $checkedConvert('similarQuery', (v) => v as String?),
          queryLanguages: $checkedConvert(
              'queryLanguages',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => $enumDecode(_$SupportedLanguageEnumMap, e))
                  .toList()),
          advancedSyntax: $checkedConvert('advancedSyntax', (v) => v as bool?),
          advancedSyntaxFeatures: $checkedConvert(
              'advancedSyntaxFeatures',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => $enumDecode(_$AdvancedSyntaxFeaturesEnumMap, e))
                  .toList()),
          alternativesAsExact: $checkedConvert(
              'alternativesAsExact',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => $enumDecode(_$AlternativesAsExactEnumMap, e))
                  .toList()),
          decompoundQuery:
              $checkedConvert('decompoundQuery', (v) => v as bool?),
          typoTolerance: $checkedConvert('typoTolerance', (v) => v),
          allowTyposOnNumericTokens:
              $checkedConvert('allowTyposOnNumericTokens', (v) => v as bool?),
          minWordSizeFor1Typo: $checkedConvert(
              'minWordSizeFor1Typo', (v) => (v as num?)?.toInt()),
          minWordSizeFor2Typos: $checkedConvert(
              'minWordSizeFor2Typos', (v) => (v as num?)?.toInt()),
          disableTypoToleranceOnAttributes: $checkedConvert(
              'disableTypoToleranceOnAttributes',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          filters: $checkedConvert('filters', (v) => v as String?),
          facetFilters: $checkedConvert('facetFilters', (v) => v),
          facets: $checkedConvert('facets', (v) => v),
          maxValuesPerFacet:
              $checkedConvert('maxValuesPerFacet', (v) => (v as num?)?.toInt()),
          maxFacetHits:
              $checkedConvert('maxFacetHits', (v) => (v as num?)?.toInt()),
          facetingAfterDistinct:
              $checkedConvert('facetingAfterDistinct', (v) => v as bool?),
          sortFacetValuesBy:
              $checkedConvert('sortFacetValuesBy', (v) => v as String?),
          numericFilters: $checkedConvert('numericFilters', (v) => v),
          tagFilters: $checkedConvert('tagFilters', (v) => v),
          sumOrFiltersScores:
              $checkedConvert('sumOrFiltersScores', (v) => v as bool?),
          aroundLatLng: $checkedConvert('aroundLatLng', (v) => v as String?),
          aroundLatLngViaIp:
              $checkedConvert('aroundLatLngViaIp', (v) => v as bool?),
          aroundRadius: $checkedConvert('aroundRadius', (v) => v),
          aroundPrecision: $checkedConvert('aroundPrecision', (v) => v),
          minimumAroundRadius: $checkedConvert(
              'minimumAroundRadius', (v) => (v as num?)?.toInt()),
          insideBoundingBox: $checkedConvert('insideBoundingBox', (v) => v),
          insidePolygon: $checkedConvert('insidePolygon', (v) => v),
          attributesToRetrieve: $checkedConvert('attributesToRetrieve',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          attributesToSnippet: $checkedConvert('attributesToSnippet',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          snippetEllipsisText:
              $checkedConvert('snippetEllipsisText', (v) => v as String?),
          restrictHighlightAndSnippetArrays: $checkedConvert(
              'restrictHighlightAndSnippetArrays', (v) => v as bool?),
          page: $checkedConvert('page', (v) => (v as num?)?.toInt()),
          offset: $checkedConvert('offset', (v) => (v as num?)?.toInt()),
          hitsPerPage:
              $checkedConvert('hitsPerPage', (v) => (v as num?)?.toInt()),
          length: $checkedConvert('length', (v) => (v as num?)?.toInt()),
          getRankingInfo: $checkedConvert('getRankingInfo', (v) => v as bool?),
          relevancyStrictness: $checkedConvert(
              'relevancyStrictness', (v) => (v as num?)?.toInt()),
          minProximity:
              $checkedConvert('minProximity', (v) => (v as num?)?.toInt()),
          attributeCriteriaComputedByMinProximity: $checkedConvert(
              'attributeCriteriaComputedByMinProximity', (v) => v as bool?),
          distinct: $checkedConvert('distinct', (v) => v),
          enableRules: $checkedConvert('enableRules', (v) => v as bool?),
          enablePersonalization:
              $checkedConvert('enablePersonalization', (v) => v as bool?),
          personalizationImpact: $checkedConvert(
              'personalizationImpact', (v) => (v as num?)?.toInt()),
          enableAbTest: $checkedConvert('enableAbTest', (v) => v as bool?),
          enableReRanking:
              $checkedConvert('enableReRanking', (v) => v as bool?),
          reRankingApplyFilter:
              $checkedConvert('reRankingApplyFilter', (v) => v),
          ruleContexts: $checkedConvert('ruleContexts',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          removeStopWords: $checkedConvert('removeStopWords', (v) => v),
          ignorePlurals: $checkedConvert('ignorePlurals', (v) => v),
          removeWordsIfNoResults: $checkedConvert('removeWordsIfNoResults',
              (v) => $enumDecodeNullable(_$RemoveWordsIfNoResultsEnumMap, v)),
          optionalWords: $checkedConvert('optionalWords', (v) => v),
          optionalFilters: $checkedConvert('optionalFilters', (v) => v),
          synonyms: $checkedConvert('synonyms', (v) => v as bool?),
          replaceSynonymsInHighlight:
              $checkedConvert('replaceSynonymsInHighlight', (v) => v as bool?),
          analytics: $checkedConvert('analytics', (v) => v as bool?),
          analyticsTags: $checkedConvert('analyticsTags',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          clickAnalytics: $checkedConvert('clickAnalytics', (v) => v as bool?),
          userToken: $checkedConvert('userToken', (v) => v as String?),
          restrictSearchableAttributes: $checkedConvert(
              'restrictSearchableAttributes',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          disableExactOnAttributes: $checkedConvert('disableExactOnAttributes',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          exactOnSingleWordQuery: $checkedConvert('exactOnSingleWordQuery',
              (v) => $enumDecodeNullable(_$ExactOnSingleWordQueryEnumMap, v)),
          naturalLanguages: $checkedConvert(
              'naturalLanguages',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => $enumDecode(_$SupportedLanguageEnumMap, e))
                  .toList()),
          percentileComputation:
              $checkedConvert('percentileComputation', (v) => v as bool?),
          explain: $checkedConvert('explain',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchParametersToJson(SearchParameters instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('queryType', instance.queryType?.toJson());
  writeNotNull('similarQuery', instance.similarQuery);
  writeNotNull('queryLanguages',
      instance.queryLanguages?.map((e) => e.toJson()).toList());
  writeNotNull('advancedSyntax', instance.advancedSyntax);
  writeNotNull('advancedSyntaxFeatures',
      instance.advancedSyntaxFeatures?.map((e) => e.toJson()).toList());
  writeNotNull('alternativesAsExact',
      instance.alternativesAsExact?.map((e) => e.toJson()).toList());
  writeNotNull('decompoundQuery', instance.decompoundQuery);
  writeNotNull('typoTolerance', instance.typoTolerance);
  writeNotNull('allowTyposOnNumericTokens', instance.allowTyposOnNumericTokens);
  writeNotNull('minWordSizeFor1Typo', instance.minWordSizeFor1Typo);
  writeNotNull('minWordSizeFor2Typos', instance.minWordSizeFor2Typos);
  writeNotNull('disableTypoToleranceOnAttributes',
      instance.disableTypoToleranceOnAttributes);
  writeNotNull('filters', instance.filters);
  writeNotNull('facetFilters', instance.facetFilters);
  writeNotNull('facets', instance.facets);
  writeNotNull('maxValuesPerFacet', instance.maxValuesPerFacet);
  writeNotNull('maxFacetHits', instance.maxFacetHits);
  writeNotNull('facetingAfterDistinct', instance.facetingAfterDistinct);
  writeNotNull('sortFacetValuesBy', instance.sortFacetValuesBy);
  writeNotNull('numericFilters', instance.numericFilters);
  writeNotNull('tagFilters', instance.tagFilters);
  writeNotNull('sumOrFiltersScores', instance.sumOrFiltersScores);
  writeNotNull('aroundLatLng', instance.aroundLatLng);
  writeNotNull('aroundLatLngViaIp', instance.aroundLatLngViaIp);
  writeNotNull('aroundRadius', instance.aroundRadius);
  writeNotNull('aroundPrecision', instance.aroundPrecision);
  writeNotNull('minimumAroundRadius', instance.minimumAroundRadius);
  writeNotNull('insideBoundingBox', instance.insideBoundingBox);
  writeNotNull('insidePolygon', instance.insidePolygon);
  writeNotNull('attributesToRetrieve', instance.attributesToRetrieve);
  writeNotNull('attributesToSnippet', instance.attributesToSnippet);
  writeNotNull('snippetEllipsisText', instance.snippetEllipsisText);
  writeNotNull('restrictHighlightAndSnippetArrays',
      instance.restrictHighlightAndSnippetArrays);
  writeNotNull('page', instance.page);
  writeNotNull('offset', instance.offset);
  writeNotNull('hitsPerPage', instance.hitsPerPage);
  writeNotNull('length', instance.length);
  writeNotNull('getRankingInfo', instance.getRankingInfo);
  writeNotNull('relevancyStrictness', instance.relevancyStrictness);
  writeNotNull('minProximity', instance.minProximity);
  writeNotNull('attributeCriteriaComputedByMinProximity',
      instance.attributeCriteriaComputedByMinProximity);
  writeNotNull('distinct', instance.distinct);
  writeNotNull('enableRules', instance.enableRules);
  writeNotNull('enablePersonalization', instance.enablePersonalization);
  writeNotNull('personalizationImpact', instance.personalizationImpact);
  writeNotNull('enableAbTest', instance.enableAbTest);
  writeNotNull('enableReRanking', instance.enableReRanking);
  writeNotNull('reRankingApplyFilter', instance.reRankingApplyFilter);
  writeNotNull('ruleContexts', instance.ruleContexts);
  writeNotNull('removeStopWords', instance.removeStopWords);
  writeNotNull('ignorePlurals', instance.ignorePlurals);
  writeNotNull(
      'removeWordsIfNoResults', instance.removeWordsIfNoResults?.toJson());
  writeNotNull('optionalWords', instance.optionalWords);
  writeNotNull('optionalFilters', instance.optionalFilters);
  writeNotNull('synonyms', instance.synonyms);
  writeNotNull(
      'replaceSynonymsInHighlight', instance.replaceSynonymsInHighlight);
  writeNotNull('analytics', instance.analytics);
  writeNotNull('analyticsTags', instance.analyticsTags);
  writeNotNull('clickAnalytics', instance.clickAnalytics);
  writeNotNull('userToken', instance.userToken);
  writeNotNull(
      'restrictSearchableAttributes', instance.restrictSearchableAttributes);
  writeNotNull('disableExactOnAttributes', instance.disableExactOnAttributes);
  writeNotNull(
      'exactOnSingleWordQuery', instance.exactOnSingleWordQuery?.toJson());
  writeNotNull('naturalLanguages',
      instance.naturalLanguages?.map((e) => e.toJson()).toList());
  writeNotNull('percentileComputation', instance.percentileComputation);
  writeNotNull('explain', instance.explain);
  return val;
}

const _$QueryTypeEnumMap = {
  QueryType.prefixLast: 'prefixLast',
  QueryType.prefixAll: 'prefixAll',
  QueryType.prefixNone: 'prefixNone',
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

const _$RemoveWordsIfNoResultsEnumMap = {
  RemoveWordsIfNoResults.none: 'none',
  RemoveWordsIfNoResults.lastWords: 'lastWords',
  RemoveWordsIfNoResults.firstWords: 'firstWords',
  RemoveWordsIfNoResults.allOptional: 'allOptional',
};

const _$ExactOnSingleWordQueryEnumMap = {
  ExactOnSingleWordQuery.attribute: 'attribute',
  ExactOnSingleWordQuery.none: 'none',
  ExactOnSingleWordQuery.word: 'word',
};
