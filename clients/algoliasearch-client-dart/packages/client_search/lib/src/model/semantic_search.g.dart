// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'semantic_search.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SemanticSearch _$SemanticSearchFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SemanticSearch',
      json,
      ($checkedConvert) {
        final val = SemanticSearch(
          eventSources: $checkedConvert('eventSources',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$SemanticSearchToJson(SemanticSearch instance) =>
    <String, dynamic>{
      if (instance.eventSources case final value?) 'eventSources': value,
    };
