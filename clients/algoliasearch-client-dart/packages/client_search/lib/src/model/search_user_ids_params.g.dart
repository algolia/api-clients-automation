// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_user_ids_params.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchUserIdsParams _$SearchUserIdsParamsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchUserIdsParams',
      json,
      ($checkedConvert) {
        final val = SearchUserIdsParams(
          query: $checkedConvert('query', (v) => v as String),
          clusterName: $checkedConvert('clusterName', (v) => v as String?),
          page: $checkedConvert('page', (v) => (v as num?)?.toInt()),
          hitsPerPage:
              $checkedConvert('hitsPerPage', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchUserIdsParamsToJson(
        SearchUserIdsParams instance) =>
    <String, dynamic>{
      'query': instance.query,
      if (instance.clusterName case final value?) 'clusterName': value,
      if (instance.page case final value?) 'page': value,
      if (instance.hitsPerPage case final value?) 'hitsPerPage': value,
    };
