// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'vertex_ai_provider_input.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

VertexAIProviderInput _$VertexAIProviderInputFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'VertexAIProviderInput',
      json,
      ($checkedConvert) {
        final val = VertexAIProviderInput(
          apiKey: $checkedConvert('apiKey', (v) => v as String?),
          project: $checkedConvert('project', (v) => v as String?),
          location: $checkedConvert('location', (v) => v as String?),
          serviceAccountKey: $checkedConvert(
              'serviceAccountKey',
              (v) => v == null
                  ? null
                  : GoogleServiceAccountKey.fromJson(
                      v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$VertexAIProviderInputToJson(
    VertexAIProviderInput instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('apiKey', instance.apiKey);
  writeNotNull('project', instance.project);
  writeNotNull('location', instance.location);
  writeNotNull('serviceAccountKey', instance.serviceAccountKey?.toJson());
  return val;
}
