// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'standard_entries.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

StandardEntries _$StandardEntriesFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'StandardEntries',
      json,
      ($checkedConvert) {
        final val = StandardEntries(
          plurals: $checkedConvert(
              'plurals',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as bool),
                  )),
          stopwords: $checkedConvert(
              'stopwords',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as bool),
                  )),
          compounds: $checkedConvert(
              'compounds',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as bool),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$StandardEntriesToJson(StandardEntries instance) =>
    <String, dynamic>{
      if (instance.plurals case final value?) 'plurals': value,
      if (instance.stopwords case final value?) 'stopwords': value,
      if (instance.compounds case final value?) 'compounds': value,
    };
