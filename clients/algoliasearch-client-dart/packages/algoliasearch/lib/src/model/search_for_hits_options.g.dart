// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_for_hits_options.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchForHitsOptions _$SearchForHitsOptionsFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchForHitsOptions',
      json,
      ($checkedConvert) {
        final val = SearchForHitsOptions(
          indexName: $checkedConvert('indexName', (v) => v as String),
          type: $checkedConvert('type',
              (v) => $enumDecodeNullable(_$SearchTypeDefaultEnumMap, v)),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchForHitsOptionsToJson(
        SearchForHitsOptions instance) =>
    <String, dynamic>{
      'indexName': instance.indexName,
      if (instance.type?.toJson() case final value?) 'type': value,
    };

const _$SearchTypeDefaultEnumMap = {
  SearchTypeDefault.default_: 'default',
};
