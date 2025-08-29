// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'metadata.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Metadata _$MetadataFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Metadata',
      json,
      ($checkedConvert) {
        final val = Metadata(
          hits: $checkedConvert(
              'hits',
              (v) => v == null
                  ? null
                  : InjectedItemHitsMetadata.fromJson(
                      v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$MetadataToJson(Metadata instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('hits', instance.hits?.toJson());
  return val;
}
