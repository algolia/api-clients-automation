// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'source_big_commerce.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SourceBigCommerce _$SourceBigCommerceFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SourceBigCommerce',
      json,
      ($checkedConvert) {
        final val = SourceBigCommerce(
          storeHash: $checkedConvert('storeHash', (v) => v as String),
          channel: $checkedConvert(
              'channel',
              (v) => v == null
                  ? null
                  : BigCommerceChannel.fromJson(v as Map<String, dynamic>)),
          customFields: $checkedConvert('customFields',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          productMetafields: $checkedConvert(
              'productMetafields',
              (v) => (v as List<dynamic>?)
                  ?.map((e) =>
                      BigCommerceMetafield.fromJson(e as Map<String, dynamic>))
                  .toList()),
          variantMetafields: $checkedConvert(
              'variantMetafields',
              (v) => (v as List<dynamic>?)
                  ?.map((e) =>
                      BigCommerceMetafield.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$SourceBigCommerceToJson(SourceBigCommerce instance) {
  final val = <String, dynamic>{
    'storeHash': instance.storeHash,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('channel', instance.channel?.toJson());
  writeNotNull('customFields', instance.customFields);
  writeNotNull('productMetafields',
      instance.productMetafields?.map((e) => e.toJson()).toList());
  writeNotNull('variantMetafields',
      instance.variantMetafields?.map((e) => e.toJson()).toList());
  return val;
}
