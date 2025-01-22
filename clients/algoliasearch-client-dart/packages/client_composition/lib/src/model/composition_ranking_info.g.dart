// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'composition_ranking_info.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CompositionRankingInfo _$CompositionRankingInfoFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'CompositionRankingInfo',
      json,
      ($checkedConvert) {
        final val = CompositionRankingInfo(
          composed: $checkedConvert(
              'composed',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(
                        k,
                        CompositionIdRankingInfo.fromJson(
                            e as Map<String, dynamic>)),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$CompositionRankingInfoToJson(
        CompositionRankingInfo instance) =>
    <String, dynamic>{
      if (instance.composed?.map((k, e) => MapEntry(k, e.toJson()))
          case final value?)
        'composed': value,
    };
