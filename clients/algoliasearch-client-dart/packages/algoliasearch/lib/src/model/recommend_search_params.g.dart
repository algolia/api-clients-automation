// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'recommend_search_params.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RecommendSearchParams _$RecommendSearchParamsFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'RecommendSearchParams',
      json,
      ($checkedConvert) {
        final val = RecommendSearchParams(
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
          query: $checkedConvert('query', (v) => v as String?),
          attributesForFaceting: $checkedConvert('attributesForFaceting',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          replicas: $checkedConvert('replicas',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          paginationLimitedTo: $checkedConvert(
              'paginationLimitedTo', (v) => (v as num?)?.toInt()),
          unretrievableAttributes: $checkedConvert('unretrievableAttributes',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          disableTypoToleranceOnWords: $checkedConvert(
              'disableTypoToleranceOnWords',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          attributesToTransliterate: $checkedConvert(
              'attributesToTransliterate',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          camelCaseAttributes: $checkedConvert('camelCaseAttributes',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          decompoundedAttributes:
              $checkedConvert('decompoundedAttributes', (v) => v),
          indexLanguages: $checkedConvert(
              'indexLanguages',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => $enumDecode(_$SupportedLanguageEnumMap, e))
                  .toList()),
          disablePrefixOnAttributes: $checkedConvert(
              'disablePrefixOnAttributes',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          allowCompressionOfIntegerArray: $checkedConvert(
              'allowCompressionOfIntegerArray', (v) => v as bool?),
          numericAttributesForFiltering: $checkedConvert(
              'numericAttributesForFiltering',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          separatorsToIndex:
              $checkedConvert('separatorsToIndex', (v) => v as String?),
          searchableAttributes: $checkedConvert('searchableAttributes',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          userData: $checkedConvert('userData', (v) => v),
          customNormalization: $checkedConvert(
              'customNormalization',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, Map<String, String>.from(e as Map)),
                  )),
          attributeForDistinct:
              $checkedConvert('attributeForDistinct', (v) => v as String?),
          maxFacetHits:
              $checkedConvert('maxFacetHits', (v) => (v as num?)?.toInt()),
          attributesToRetrieve: $checkedConvert('attributesToRetrieve',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          ranking: $checkedConvert('ranking',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          relevancyStrictness: $checkedConvert(
              'relevancyStrictness', (v) => (v as num?)?.toInt()),
          attributesToHighlight: $checkedConvert('attributesToHighlight',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          attributesToSnippet: $checkedConvert('attributesToSnippet',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          highlightPreTag:
              $checkedConvert('highlightPreTag', (v) => v as String?),
          highlightPostTag:
              $checkedConvert('highlightPostTag', (v) => v as String?),
          snippetEllipsisText:
              $checkedConvert('snippetEllipsisText', (v) => v as String?),
          restrictHighlightAndSnippetArrays: $checkedConvert(
              'restrictHighlightAndSnippetArrays', (v) => v as bool?),
          minWordSizefor1Typo: $checkedConvert(
              'minWordSizefor1Typo', (v) => (v as num?)?.toInt()),
          minWordSizefor2Typos: $checkedConvert(
              'minWordSizefor2Typos', (v) => (v as num?)?.toInt()),
          typoTolerance: $checkedConvert('typoTolerance', (v) => v),
          allowTyposOnNumericTokens:
              $checkedConvert('allowTyposOnNumericTokens', (v) => v as bool?),
          disableTypoToleranceOnAttributes: $checkedConvert(
              'disableTypoToleranceOnAttributes',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          ignorePlurals: $checkedConvert('ignorePlurals', (v) => v),
          removeStopWords: $checkedConvert('removeStopWords', (v) => v),
          queryLanguages: $checkedConvert(
              'queryLanguages',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => $enumDecode(_$SupportedLanguageEnumMap, e))
                  .toList()),
          decompoundQuery:
              $checkedConvert('decompoundQuery', (v) => v as bool?),
          enableRules: $checkedConvert('enableRules', (v) => v as bool?),
          enablePersonalization:
              $checkedConvert('enablePersonalization', (v) => v as bool?),
          queryType: $checkedConvert(
              'queryType', (v) => $enumDecodeNullable(_$QueryTypeEnumMap, v)),
          removeWordsIfNoResults: $checkedConvert('removeWordsIfNoResults',
              (v) => $enumDecodeNullable(_$RemoveWordsIfNoResultsEnumMap, v)),
          advancedSyntax: $checkedConvert('advancedSyntax', (v) => v as bool?),
          optionalWords: $checkedConvert('optionalWords', (v) => v),
          disableExactOnAttributes: $checkedConvert('disableExactOnAttributes',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          exactOnSingleWordQuery: $checkedConvert('exactOnSingleWordQuery',
              (v) => $enumDecodeNullable(_$ExactOnSingleWordQueryEnumMap, v)),
          alternativesAsExact: $checkedConvert(
              'alternativesAsExact',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => $enumDecode(_$AlternativesAsExactEnumMap, e))
                  .toList()),
          advancedSyntaxFeatures: $checkedConvert(
              'advancedSyntaxFeatures',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => $enumDecode(_$AdvancedSyntaxFeaturesEnumMap, e))
                  .toList()),
          distinct: $checkedConvert('distinct', (v) => v),
          replaceSynonymsInHighlight:
              $checkedConvert('replaceSynonymsInHighlight', (v) => v as bool?),
          minProximity:
              $checkedConvert('minProximity', (v) => (v as num?)?.toInt()),
          responseFields: $checkedConvert('responseFields',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          maxValuesPerFacet:
              $checkedConvert('maxValuesPerFacet', (v) => (v as num?)?.toInt()),
          sortFacetValuesBy:
              $checkedConvert('sortFacetValuesBy', (v) => v as String?),
          attributeCriteriaComputedByMinProximity: $checkedConvert(
              'attributeCriteriaComputedByMinProximity', (v) => v as bool?),
          renderingContent: $checkedConvert(
              'renderingContent',
              (v) => v == null
                  ? null
                  : RenderingContent.fromJson(v as Map<String, dynamic>)),
          enableReRanking:
              $checkedConvert('enableReRanking', (v) => v as bool?),
          reRankingApplyFilter:
              $checkedConvert('reRankingApplyFilter', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$RecommendSearchParamsToJson(
        RecommendSearchParams instance) =>
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
      if (instance.query case final value?) 'query': value,
      if (instance.attributesForFaceting case final value?)
        'attributesForFaceting': value,
      if (instance.replicas case final value?) 'replicas': value,
      if (instance.paginationLimitedTo case final value?)
        'paginationLimitedTo': value,
      if (instance.unretrievableAttributes case final value?)
        'unretrievableAttributes': value,
      if (instance.disableTypoToleranceOnWords case final value?)
        'disableTypoToleranceOnWords': value,
      if (instance.attributesToTransliterate case final value?)
        'attributesToTransliterate': value,
      if (instance.camelCaseAttributes case final value?)
        'camelCaseAttributes': value,
      if (instance.decompoundedAttributes case final value?)
        'decompoundedAttributes': value,
      if (instance.indexLanguages?.map((e) => e.toJson()).toList()
          case final value?)
        'indexLanguages': value,
      if (instance.disablePrefixOnAttributes case final value?)
        'disablePrefixOnAttributes': value,
      if (instance.allowCompressionOfIntegerArray case final value?)
        'allowCompressionOfIntegerArray': value,
      if (instance.numericAttributesForFiltering case final value?)
        'numericAttributesForFiltering': value,
      if (instance.separatorsToIndex case final value?)
        'separatorsToIndex': value,
      if (instance.searchableAttributes case final value?)
        'searchableAttributes': value,
      if (instance.userData case final value?) 'userData': value,
      if (instance.customNormalization case final value?)
        'customNormalization': value,
      if (instance.attributeForDistinct case final value?)
        'attributeForDistinct': value,
      if (instance.maxFacetHits case final value?) 'maxFacetHits': value,
      if (instance.attributesToRetrieve case final value?)
        'attributesToRetrieve': value,
      if (instance.ranking case final value?) 'ranking': value,
      if (instance.relevancyStrictness case final value?)
        'relevancyStrictness': value,
      if (instance.attributesToHighlight case final value?)
        'attributesToHighlight': value,
      if (instance.attributesToSnippet case final value?)
        'attributesToSnippet': value,
      if (instance.highlightPreTag case final value?) 'highlightPreTag': value,
      if (instance.highlightPostTag case final value?)
        'highlightPostTag': value,
      if (instance.snippetEllipsisText case final value?)
        'snippetEllipsisText': value,
      if (instance.restrictHighlightAndSnippetArrays case final value?)
        'restrictHighlightAndSnippetArrays': value,
      if (instance.minWordSizefor1Typo case final value?)
        'minWordSizefor1Typo': value,
      if (instance.minWordSizefor2Typos case final value?)
        'minWordSizefor2Typos': value,
      if (instance.typoTolerance case final value?) 'typoTolerance': value,
      if (instance.allowTyposOnNumericTokens case final value?)
        'allowTyposOnNumericTokens': value,
      if (instance.disableTypoToleranceOnAttributes case final value?)
        'disableTypoToleranceOnAttributes': value,
      if (instance.ignorePlurals case final value?) 'ignorePlurals': value,
      if (instance.removeStopWords case final value?) 'removeStopWords': value,
      if (instance.queryLanguages?.map((e) => e.toJson()).toList()
          case final value?)
        'queryLanguages': value,
      if (instance.decompoundQuery case final value?) 'decompoundQuery': value,
      if (instance.enableRules case final value?) 'enableRules': value,
      if (instance.enablePersonalization case final value?)
        'enablePersonalization': value,
      if (instance.queryType?.toJson() case final value?) 'queryType': value,
      if (instance.removeWordsIfNoResults?.toJson() case final value?)
        'removeWordsIfNoResults': value,
      if (instance.advancedSyntax case final value?) 'advancedSyntax': value,
      if (instance.optionalWords case final value?) 'optionalWords': value,
      if (instance.disableExactOnAttributes case final value?)
        'disableExactOnAttributes': value,
      if (instance.exactOnSingleWordQuery?.toJson() case final value?)
        'exactOnSingleWordQuery': value,
      if (instance.alternativesAsExact?.map((e) => e.toJson()).toList()
          case final value?)
        'alternativesAsExact': value,
      if (instance.advancedSyntaxFeatures?.map((e) => e.toJson()).toList()
          case final value?)
        'advancedSyntaxFeatures': value,
      if (instance.distinct case final value?) 'distinct': value,
      if (instance.replaceSynonymsInHighlight case final value?)
        'replaceSynonymsInHighlight': value,
      if (instance.minProximity case final value?) 'minProximity': value,
      if (instance.responseFields case final value?) 'responseFields': value,
      if (instance.maxValuesPerFacet case final value?)
        'maxValuesPerFacet': value,
      if (instance.sortFacetValuesBy case final value?)
        'sortFacetValuesBy': value,
      if (instance.attributeCriteriaComputedByMinProximity case final value?)
        'attributeCriteriaComputedByMinProximity': value,
      if (instance.renderingContent?.toJson() case final value?)
        'renderingContent': value,
      if (instance.enableReRanking case final value?) 'enableReRanking': value,
      if (instance.reRankingApplyFilter case final value?)
        'reRankingApplyFilter': value,
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

const _$ExactOnSingleWordQueryEnumMap = {
  ExactOnSingleWordQuery.attribute: 'attribute',
  ExactOnSingleWordQuery.none: 'none',
  ExactOnSingleWordQuery.word: 'word',
};

const _$AlternativesAsExactEnumMap = {
  AlternativesAsExact.ignorePlurals: 'ignorePlurals',
  AlternativesAsExact.singleWordSynonym: 'singleWordSynonym',
  AlternativesAsExact.multiWordsSynonym: 'multiWordsSynonym',
};

const _$AdvancedSyntaxFeaturesEnumMap = {
  AdvancedSyntaxFeatures.exactPhrase: 'exactPhrase',
  AdvancedSyntaxFeatures.excludeWords: 'excludeWords',
};
