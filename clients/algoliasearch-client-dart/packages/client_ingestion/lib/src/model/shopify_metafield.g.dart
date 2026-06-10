// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'shopify_metafield.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ShopifyMetafield _$ShopifyMetafieldFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ShopifyMetafield',
      json,
      ($checkedConvert) {
        final val = ShopifyMetafield(
          namespace: $checkedConvert('namespace', (v) => v as String),
          key: $checkedConvert('key', (v) => v as String),
          value: $checkedConvert('value', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$ShopifyMetafieldToJson(ShopifyMetafield instance) =>
    <String, dynamic>{
      'namespace': instance.namespace,
      'key': instance.key,
      'value': instance.value,
    };
