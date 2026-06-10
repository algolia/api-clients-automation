// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'shopify_input.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ShopifyInput _$ShopifyInputFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ShopifyInput',
      json,
      ($checkedConvert) {
        final val = ShopifyInput(
          metafields: $checkedConvert(
              'metafields',
              (v) => (v as List<dynamic>)
                  .map((e) =>
                      ShopifyMetafield.fromJson(e as Map<String, dynamic>))
                  .toList()),
          market: $checkedConvert('market',
              (v) => ShopifyMarket.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$ShopifyInputToJson(ShopifyInput instance) =>
    <String, dynamic>{
      'metafields': instance.metafields.map((e) => e.toJson()).toList(),
      'market': instance.market.toJson(),
    };
