// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'source_update_shopify.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SourceUpdateShopify _$SourceUpdateShopifyFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SourceUpdateShopify',
      json,
      ($checkedConvert) {
        final val = SourceUpdateShopify(
          featureFlags: $checkedConvert(
              'featureFlags',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$SourceUpdateShopifyToJson(SourceUpdateShopify instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('featureFlags', instance.featureFlags);
  return val;
}
