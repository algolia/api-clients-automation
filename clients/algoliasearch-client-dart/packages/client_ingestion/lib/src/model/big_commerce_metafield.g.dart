// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'big_commerce_metafield.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BigCommerceMetafield _$BigCommerceMetafieldFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'BigCommerceMetafield',
      json,
      ($checkedConvert) {
        final val = BigCommerceMetafield(
          namespace: $checkedConvert('namespace', (v) => v as String),
          key: $checkedConvert('key', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$BigCommerceMetafieldToJson(
        BigCommerceMetafield instance) =>
    <String, dynamic>{
      'namespace': instance.namespace,
      'key': instance.key,
    };
