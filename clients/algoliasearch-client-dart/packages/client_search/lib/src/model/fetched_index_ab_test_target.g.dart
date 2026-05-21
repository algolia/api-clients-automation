// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'fetched_index_ab_test_target.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

FetchedIndexAbTestTarget _$FetchedIndexAbTestTargetFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'FetchedIndexAbTestTarget',
      json,
      ($checkedConvert) {
        final val = FetchedIndexAbTestTarget(
          indexName: $checkedConvert('indexName', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$FetchedIndexAbTestTargetToJson(
        FetchedIndexAbTestTarget instance) =>
    <String, dynamic>{
      'indexName': instance.indexName,
    };
