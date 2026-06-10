// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'shopify_market.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ShopifyMarket _$ShopifyMarketFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ShopifyMarket',
      json,
      ($checkedConvert) {
        final val = ShopifyMarket(
          countries: $checkedConvert('countries',
              (v) => (v as List<dynamic>).map((e) => e as String).toList()),
          currencies: $checkedConvert('currencies',
              (v) => (v as List<dynamic>).map((e) => e as String).toList()),
          locales: $checkedConvert('locales',
              (v) => (v as List<dynamic>).map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$ShopifyMarketToJson(ShopifyMarket instance) =>
    <String, dynamic>{
      'countries': instance.countries,
      'currencies': instance.currencies,
      'locales': instance.locales,
    };
