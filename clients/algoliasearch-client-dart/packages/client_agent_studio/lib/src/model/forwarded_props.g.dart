// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'forwarded_props.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ForwardedProps _$ForwardedPropsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ForwardedProps',
      json,
      ($checkedConvert) {
        final val = ForwardedProps(
          algolia: $checkedConvert(
              'algolia',
              (v) => v == null
                  ? null
                  : AgentCompletionAlgoliaParams.fromJson(
                      v as Map<String, dynamic>)),
          toolApprovals: $checkedConvert(
              'toolApprovals',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(
                        k,
                        (e as Map<String, dynamic>).map(
                          (k, e) => MapEntry(k, e as Object),
                        )),
                  )),
          configuration: $checkedConvert(
              'configuration',
              (v) => v == null
                  ? null
                  : AgentTestConfiguration.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$ForwardedPropsToJson(ForwardedProps instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('algolia', instance.algolia?.toJson());
  writeNotNull('toolApprovals', instance.toolApprovals);
  writeNotNull('configuration', instance.configuration?.toJson());
  return val;
}
