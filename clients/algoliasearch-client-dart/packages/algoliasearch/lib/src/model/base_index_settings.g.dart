// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'base_index_settings.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BaseIndexSettings _$BaseIndexSettingsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'BaseIndexSettings',
      json,
      ($checkedConvert) {
        final val = BaseIndexSettings(
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
        );
        return val;
      },
    );

Map<String, dynamic> _$BaseIndexSettingsToJson(BaseIndexSettings instance) =>
    <String, dynamic>{
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
      if (instance.keepDiacriticsOnCharacters case final value?)
        'keepDiacriticsOnCharacters': value,
      if (instance.customRanking case final value?) 'customRanking': value,
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
