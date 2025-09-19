// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_source.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchSource _$SearchSourceFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchSource',
      json,
      ($checkedConvert) {
        final val = SearchSource(
          search: $checkedConvert(
              'search', (v) => Search.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchSourceToJson(SearchSource instance) =>
    <String, dynamic>{
      'search': instance.search.toJson(),
    };
