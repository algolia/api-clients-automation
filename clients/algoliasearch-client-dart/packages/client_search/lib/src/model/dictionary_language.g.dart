// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'dictionary_language.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

DictionaryLanguage _$DictionaryLanguageFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'DictionaryLanguage',
      json,
      ($checkedConvert) {
        final val = DictionaryLanguage(
          nbCustomEntries:
              $checkedConvert('nbCustomEntries', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$DictionaryLanguageToJson(DictionaryLanguage instance) =>
    <String, dynamic>{
      if (instance.nbCustomEntries case final value?) 'nbCustomEntries': value,
    };
