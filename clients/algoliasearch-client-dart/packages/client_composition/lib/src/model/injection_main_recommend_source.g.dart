// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'injection_main_recommend_source.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

InjectionMainRecommendSource _$InjectionMainRecommendSourceFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'InjectionMainRecommendSource',
      json,
      ($checkedConvert) {
        final val = InjectionMainRecommendSource(
          recommend: $checkedConvert('recommend',
              (v) => MainRecommend.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$InjectionMainRecommendSourceToJson(
        InjectionMainRecommendSource instance) =>
    <String, dynamic>{
      'recommend': instance.recommend.toJson(),
    };
