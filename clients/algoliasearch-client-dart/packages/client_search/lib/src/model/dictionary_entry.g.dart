// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'dictionary_entry.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

DictionaryEntry _$DictionaryEntryFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'DictionaryEntry',
      json,
      ($checkedConvert) {
        final val = DictionaryEntry(
          objectID: $checkedConvert('objectID', (v) => v as String),
          language: $checkedConvert('language',
              (v) => $enumDecodeNullable(_$SupportedLanguageEnumMap, v)),
          word: $checkedConvert('word', (v) => v as String?),
          words: $checkedConvert('words',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          decomposition: $checkedConvert('decomposition',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          state: $checkedConvert('state',
              (v) => $enumDecodeNullable(_$DictionaryEntryStateEnumMap, v)),
          type: $checkedConvert('type',
              (v) => $enumDecodeNullable(_$DictionaryEntryTypeEnumMap, v)),
        );
        return val;
      },
    );

const _$DictionaryEntryFieldMap = <String, String>{
  'objectID': 'objectID',
  'language': 'language',
  'word': 'word',
  'words': 'words',
  'decomposition': 'decomposition',
  'state': 'state',
  'type': 'type',
};

Map<String, dynamic> _$DictionaryEntryToJson(DictionaryEntry instance) {
  final val = <String, dynamic>{
    'objectID': instance.objectID,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('language', instance.language?.toJson());
  writeNotNull('word', instance.word);
  writeNotNull('words', instance.words);
  writeNotNull('decomposition', instance.decomposition);
  writeNotNull('state', instance.state?.toJson());
  writeNotNull('type', instance.type?.toJson());
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

const _$DictionaryEntryStateEnumMap = {
  DictionaryEntryState.enabled: 'enabled',
  DictionaryEntryState.disabled: 'disabled',
};

const _$DictionaryEntryTypeEnumMap = {
  DictionaryEntryType.custom: 'custom',
  DictionaryEntryType.standard: 'standard',
};
