// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'source_shopify_base.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SourceShopifyBase _$SourceShopifyBaseFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SourceShopifyBase',
      json,
      ($checkedConvert) {
        final val = SourceShopifyBase(
          shopURL: $checkedConvert('shopURL', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$SourceShopifyBaseToJson(SourceShopifyBase instance) =>
    <String, dynamic>{
      'shopURL': instance.shopURL,
    };
