// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'auth_algolia_insights.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AuthAlgoliaInsights _$AuthAlgoliaInsightsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'AuthAlgoliaInsights',
      json,
      ($checkedConvert) {
        final val = AuthAlgoliaInsights(
          appID: $checkedConvert('appID', (v) => v as String),
          apiKey: $checkedConvert('apiKey', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$AuthAlgoliaInsightsToJson(
        AuthAlgoliaInsights instance) =>
    <String, dynamic>{
      'appID': instance.appID,
      'apiKey': instance.apiKey,
    };
