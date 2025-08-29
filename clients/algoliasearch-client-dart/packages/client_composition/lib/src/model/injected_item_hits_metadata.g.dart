// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'injected_item_hits_metadata.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

InjectedItemHitsMetadata _$InjectedItemHitsMetadataFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'InjectedItemHitsMetadata',
      json,
      ($checkedConvert) {
        final val = InjectedItemHitsMetadata(
          addItemKey: $checkedConvert('addItemKey', (v) => v as bool?),
          extra: $checkedConvert(
              'extra',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$InjectedItemHitsMetadataToJson(
    InjectedItemHitsMetadata instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('addItemKey', instance.addItemKey);
  writeNotNull('extra', instance.extra);
  return val;
}
