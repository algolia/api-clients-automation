// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'base_search_source.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BaseSearchSource _$BaseSearchSourceFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'BaseSearchSource',
      json,
      ($checkedConvert) {
        final val = BaseSearchSource(
          index: $checkedConvert('index', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$BaseSearchSourceToJson(BaseSearchSource instance) =>
    <String, dynamic>{
      'index': instance.index,
    };
