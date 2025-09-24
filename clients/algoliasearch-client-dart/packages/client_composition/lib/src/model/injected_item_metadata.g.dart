// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'injected_item_metadata.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

InjectedItemMetadata _$InjectedItemMetadataFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'InjectedItemMetadata',
      json,
      ($checkedConvert) {
        final val = InjectedItemMetadata(
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

Map<String, dynamic> _$InjectedItemMetadataToJson(
    InjectedItemMetadata instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('hits', instance.hits?.toJson());
  return val;
}
