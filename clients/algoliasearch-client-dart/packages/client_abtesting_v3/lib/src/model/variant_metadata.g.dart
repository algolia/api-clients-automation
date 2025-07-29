// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'variant_metadata.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

VariantMetadata _$VariantMetadataFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'VariantMetadata',
      json,
      ($checkedConvert) {
        final val = VariantMetadata(
          filterEffects: $checkedConvert(
              'filterEffects',
              (v) => v == null
                  ? null
                  : FilterEffects.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$VariantMetadataToJson(VariantMetadata instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('filterEffects', instance.filterEffects?.toJson());
  return val;
}
