// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'minimum_detectable_effect.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MinimumDetectableEffect _$MinimumDetectableEffectFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'MinimumDetectableEffect',
      json,
      ($checkedConvert) {
        final val = MinimumDetectableEffect(
          size: $checkedConvert('size', (v) => (v as num).toDouble()),
          metric: $checkedConvert(
              'metric', (v) => $enumDecode(_$EffectMetricEnumMap, v)),
        );
        return val;
      },
    );

Map<String, dynamic> _$MinimumDetectableEffectToJson(
        MinimumDetectableEffect instance) =>
    <String, dynamic>{
      'size': instance.size,
      'metric': instance.metric.toJson(),
    };

const _$EffectMetricEnumMap = {
  EffectMetric.addToCartRate: 'addToCartRate',
  EffectMetric.clickThroughRate: 'clickThroughRate',
  EffectMetric.conversionRate: 'conversionRate',
  EffectMetric.purchaseRate: 'purchaseRate',
  EffectMetric.noResultsRate: 'noResultsRate',
};
