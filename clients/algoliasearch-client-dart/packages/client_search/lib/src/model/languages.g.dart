// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'languages.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Languages _$LanguagesFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Languages',
      json,
      ($checkedConvert) {
        final val = Languages(
          plurals: $checkedConvert(
              'plurals',
              (v) => v == null
                  ? null
                  : DictionaryLanguage.fromJson(v as Map<String, dynamic>)),
          stopwords: $checkedConvert(
              'stopwords',
              (v) => v == null
                  ? null
                  : DictionaryLanguage.fromJson(v as Map<String, dynamic>)),
          compounds: $checkedConvert(
              'compounds',
              (v) => v == null
                  ? null
                  : DictionaryLanguage.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$LanguagesToJson(Languages instance) => <String, dynamic>{
      if (instance.plurals?.toJson() case final value?) 'plurals': value,
      if (instance.stopwords?.toJson() case final value?) 'stopwords': value,
      if (instance.compounds?.toJson() case final value?) 'compounds': value,
    };
