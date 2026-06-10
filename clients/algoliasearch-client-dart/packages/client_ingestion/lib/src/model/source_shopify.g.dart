// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'source_shopify.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SourceShopify _$SourceShopifyFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SourceShopify',
      json,
      ($checkedConvert) {
        final val = SourceShopify(
          featureFlags: $checkedConvert(
              'featureFlags',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
          shopURL: $checkedConvert('shopURL', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$SourceShopifyToJson(SourceShopify instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('featureFlags', instance.featureFlags);
  val['shopURL'] = instance.shopURL;
  return val;
}
