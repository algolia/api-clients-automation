// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_method_params.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchMethodParams _$SearchMethodParamsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchMethodParams',
      json,
      ($checkedConvert) {
        final val = SearchMethodParams(
          requests: $checkedConvert('requests', (v) => v as List<dynamic>),
          strategy: $checkedConvert('strategy',
              (v) => $enumDecodeNullable(_$SearchStrategyEnumMap, v)),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchMethodParamsToJson(SearchMethodParams instance) =>
    <String, dynamic>{
      'requests': instance.requests.toList(),
      if (instance.strategy?.toJson() case final value?) 'strategy': value,
    };

const _$SearchStrategyEnumMap = {
  SearchStrategy.none: 'none',
  SearchStrategy.stopIfEnoughMatches: 'stopIfEnoughMatches',
};
