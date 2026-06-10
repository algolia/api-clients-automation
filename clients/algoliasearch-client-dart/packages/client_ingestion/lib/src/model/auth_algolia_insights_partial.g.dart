// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'auth_algolia_insights_partial.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AuthAlgoliaInsightsPartial _$AuthAlgoliaInsightsPartialFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AuthAlgoliaInsightsPartial',
      json,
      ($checkedConvert) {
        final val = AuthAlgoliaInsightsPartial(
          appID: $checkedConvert('appID', (v) => v as String?),
          apiKey: $checkedConvert('apiKey', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$AuthAlgoliaInsightsPartialToJson(
    AuthAlgoliaInsightsPartial instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('appID', instance.appID);
  writeNotNull('apiKey', instance.apiKey);
  return val;
}
