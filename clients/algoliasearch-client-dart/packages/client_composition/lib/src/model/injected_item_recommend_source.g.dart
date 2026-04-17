// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'injected_item_recommend_source.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

InjectedItemRecommendSource _$InjectedItemRecommendSourceFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'InjectedItemRecommendSource',
      json,
      ($checkedConvert) {
        final val = InjectedItemRecommendSource(
          recommend: $checkedConvert('recommend',
              (v) => Recommend.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$InjectedItemRecommendSourceToJson(
        InjectedItemRecommendSource instance) =>
    <String, dynamic>{
      'recommend': instance.recommend.toJson(),
    };
