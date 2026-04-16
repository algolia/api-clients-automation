// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'main_recommend.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MainRecommend _$MainRecommendFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'MainRecommend',
      json,
      ($checkedConvert) {
        final val = MainRecommend(
          index: $checkedConvert('index', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$MainRecommendToJson(MainRecommend instance) =>
    <String, dynamic>{
      'index': instance.index,
    };
