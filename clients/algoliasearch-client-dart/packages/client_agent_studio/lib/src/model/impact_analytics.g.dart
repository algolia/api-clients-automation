// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'impact_analytics.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ImpactAnalytics _$ImpactAnalyticsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ImpactAnalytics',
      json,
      ($checkedConvert) {
        final val = ImpactAnalytics(
          hasView: $checkedConvert('hasView', (v) => v as bool),
          hasClick: $checkedConvert('hasClick', (v) => v as bool),
          hasConversion: $checkedConvert('hasConversion', (v) => v as bool),
          hasAlgoliaSearch:
              $checkedConvert('hasAlgoliaSearch', (v) => v as bool),
        );
        return val;
      },
    );

Map<String, dynamic> _$ImpactAnalyticsToJson(ImpactAnalytics instance) =>
    <String, dynamic>{
      'hasView': instance.hasView,
      'hasClick': instance.hasClick,
      'hasConversion': instance.hasConversion,
      'hasAlgoliaSearch': instance.hasAlgoliaSearch,
    };
