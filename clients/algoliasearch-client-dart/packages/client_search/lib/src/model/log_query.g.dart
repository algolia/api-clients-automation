// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'log_query.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

LogQuery _$LogQueryFromJson(Map<String, dynamic> json) => $checkedCreate(
      'LogQuery',
      json,
      ($checkedConvert) {
        final val = LogQuery(
          indexName: $checkedConvert('index_name', (v) => v as String?),
          userToken: $checkedConvert('user_token', (v) => v as String?),
          queryId: $checkedConvert('query_id', (v) => v as String?),
        );
        return val;
      },
      fieldKeyMap: const {
        'indexName': 'index_name',
        'userToken': 'user_token',
        'queryId': 'query_id'
      },
    );

Map<String, dynamic> _$LogQueryToJson(LogQuery instance) => <String, dynamic>{
      if (instance.indexName case final value?) 'index_name': value,
      if (instance.userToken case final value?) 'user_token': value,
      if (instance.queryId case final value?) 'query_id': value,
    };
