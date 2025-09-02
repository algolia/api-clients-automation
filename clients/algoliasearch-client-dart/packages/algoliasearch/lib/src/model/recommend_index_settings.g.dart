// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'recommend_index_settings.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RecommendIndexSettings _$RecommendIndexSettingsFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'RecommendIndexSettings',
      json,
      ($checkedConvert) {
        final val = RecommendIndexSettings(
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
          keepDiacriticsOnCharacters: $checkedConvert(
              'keepDiacriticsOnCharacters', (v) => v as String?),
          customRanking: $checkedConvert('customRanking',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
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

Map<String, dynamic> _$RecommendIndexSettingsToJson(
    RecommendIndexSettings instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('attributesForFaceting', instance.attributesForFaceting);
  writeNotNull('replicas', instance.replicas);
  writeNotNull('paginationLimitedTo', instance.paginationLimitedTo);
  writeNotNull('unretrievableAttributes', instance.unretrievableAttributes);
  writeNotNull(
      'disableTypoToleranceOnWords', instance.disableTypoToleranceOnWords);
  writeNotNull('attributesToTransliterate', instance.attributesToTransliterate);
  writeNotNull('camelCaseAttributes', instance.camelCaseAttributes);
  writeNotNull('decompoundedAttributes', instance.decompoundedAttributes);
  writeNotNull('indexLanguages',
      instance.indexLanguages?.map((e) => e.toJson()).toList());
  writeNotNull('disablePrefixOnAttributes', instance.disablePrefixOnAttributes);
  writeNotNull('allowCompressionOfIntegerArray',
      instance.allowCompressionOfIntegerArray);
  writeNotNull(
      'numericAttributesForFiltering', instance.numericAttributesForFiltering);
  writeNotNull('separatorsToIndex', instance.separatorsToIndex);
  writeNotNull('searchableAttributes', instance.searchableAttributes);
  writeNotNull('userData', instance.userData);
  writeNotNull('customNormalization', instance.customNormalization);
  writeNotNull('attributeForDistinct', instance.attributeForDistinct);
  writeNotNull('maxFacetHits', instance.maxFacetHits);
  writeNotNull(
      'keepDiacriticsOnCharacters', instance.keepDiacriticsOnCharacters);
  writeNotNull('customRanking', instance.customRanking);
  writeNotNull('attributesToRetrieve', instance.attributesToRetrieve);
  writeNotNull('ranking', instance.ranking);
  writeNotNull('relevancyStrictness', instance.relevancyStrictness);
  writeNotNull('attributesToHighlight', instance.attributesToHighlight);
  writeNotNull('attributesToSnippet', instance.attributesToSnippet);
  writeNotNull('highlightPreTag', instance.highlightPreTag);
  writeNotNull('highlightPostTag', instance.highlightPostTag);
  writeNotNull('snippetEllipsisText', instance.snippetEllipsisText);
  writeNotNull('restrictHighlightAndSnippetArrays',
      instance.restrictHighlightAndSnippetArrays);
  writeNotNull('minWordSizefor1Typo', instance.minWordSizefor1Typo);
  writeNotNull('minWordSizefor2Typos', instance.minWordSizefor2Typos);
  writeNotNull('typoTolerance', instance.typoTolerance);
  writeNotNull('allowTyposOnNumericTokens', instance.allowTyposOnNumericTokens);
  writeNotNull('disableTypoToleranceOnAttributes',
      instance.disableTypoToleranceOnAttributes);
  writeNotNull('ignorePlurals', instance.ignorePlurals);
  writeNotNull('removeStopWords', instance.removeStopWords);
  writeNotNull('queryLanguages',
      instance.queryLanguages?.map((e) => e.toJson()).toList());
  writeNotNull('decompoundQuery', instance.decompoundQuery);
  writeNotNull('enableRules', instance.enableRules);
  writeNotNull('enablePersonalization', instance.enablePersonalization);
  writeNotNull('queryType', instance.queryType?.toJson());
  writeNotNull(
      'removeWordsIfNoResults', instance.removeWordsIfNoResults?.toJson());
  writeNotNull('advancedSyntax', instance.advancedSyntax);
  writeNotNull('optionalWords', instance.optionalWords);
  writeNotNull('disableExactOnAttributes', instance.disableExactOnAttributes);
  writeNotNull(
      'exactOnSingleWordQuery', instance.exactOnSingleWordQuery?.toJson());
  writeNotNull('alternativesAsExact',
      instance.alternativesAsExact?.map((e) => e.toJson()).toList());
  writeNotNull('advancedSyntaxFeatures',
      instance.advancedSyntaxFeatures?.map((e) => e.toJson()).toList());
  writeNotNull('distinct', instance.distinct);
  writeNotNull(
      'replaceSynonymsInHighlight', instance.replaceSynonymsInHighlight);
  writeNotNull('minProximity', instance.minProximity);
  writeNotNull('responseFields', instance.responseFields);
  writeNotNull('maxValuesPerFacet', instance.maxValuesPerFacet);
  writeNotNull('sortFacetValuesBy', instance.sortFacetValuesBy);
  writeNotNull('attributeCriteriaComputedByMinProximity',
      instance.attributeCriteriaComputedByMinProximity);
  writeNotNull('renderingContent', instance.renderingContent?.toJson());
  writeNotNull('enableReRanking', instance.enableReRanking);
  writeNotNull('reRankingApplyFilter', instance.reRankingApplyFilter);
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
  AlternativesAsExact.ignoreConjugations: 'ignoreConjugations',
};

const _$AdvancedSyntaxFeaturesEnumMap = {
  AdvancedSyntaxFeatures.exactPhrase: 'exactPhrase',
  AdvancedSyntaxFeatures.excludeWords: 'excludeWords',
};
