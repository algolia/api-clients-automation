// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'consequence_redirect.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ConsequenceRedirect _$ConsequenceRedirectFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ConsequenceRedirect',
      json,
      ($checkedConvert) {
        final val = ConsequenceRedirect(
          indexName: $checkedConvert('indexName', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$ConsequenceRedirectToJson(
        ConsequenceRedirect instance) =>
    <String, dynamic>{
      'indexName': instance.indexName,
    };
