// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'composition_id_ranking_info.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CompositionIdRankingInfo _$CompositionIdRankingInfoFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'CompositionIdRankingInfo',
      json,
      ($checkedConvert) {
        final val = CompositionIdRankingInfo(
          index: $checkedConvert('index', (v) => v as String),
          injectedItemKey:
              $checkedConvert('injectedItemKey', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$CompositionIdRankingInfoToJson(
        CompositionIdRankingInfo instance) =>
    <String, dynamic>{
      'index': instance.index,
      'injectedItemKey': instance.injectedItemKey,
    };
