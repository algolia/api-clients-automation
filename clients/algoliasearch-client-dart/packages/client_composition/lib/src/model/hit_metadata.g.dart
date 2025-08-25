// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'hit_metadata.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

HitMetadata _$HitMetadataFromJson(Map<String, dynamic> json) => $checkedCreate(
      'HitMetadata',
      json,
      ($checkedConvert) {
        final val = HitMetadata(
          injectedItemKey:
              $checkedConvert('_injectedItemKey', (v) => v as String?),
        );
        return val;
      },
      fieldKeyMap: const {'injectedItemKey': '_injectedItemKey'},
    );

const _$HitMetadataFieldMap = <String, String>{
  'injectedItemKey': '_injectedItemKey',
};

Map<String, dynamic> _$HitMetadataToJson(HitMetadata instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('_injectedItemKey', instance.injectedItemKey);
  return val;
}
