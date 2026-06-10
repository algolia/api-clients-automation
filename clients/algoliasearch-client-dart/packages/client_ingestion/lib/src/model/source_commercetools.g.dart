// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'source_commercetools.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SourceCommercetools _$SourceCommercetoolsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SourceCommercetools',
      json,
      ($checkedConvert) {
        final val = SourceCommercetools(
          storeKeys: $checkedConvert('storeKeys',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          locales: $checkedConvert('locales',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          url: $checkedConvert('url', (v) => v as String),
          projectKey: $checkedConvert('projectKey', (v) => v as String),
          fallbackIsInStockValue:
              $checkedConvert('fallbackIsInStockValue', (v) => v as bool?),
          productQueryPredicate:
              $checkedConvert('productQueryPredicate', (v) => v as String?),
          useImagesObjects:
              $checkedConvert('useImagesObjects', (v) => v as bool?),
          customFields: $checkedConvert(
              'customFields',
              (v) => v == null
                  ? null
                  : CommercetoolsCustomFields.fromJson(
                      v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$SourceCommercetoolsToJson(SourceCommercetools instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('storeKeys', instance.storeKeys);
  writeNotNull('locales', instance.locales);
  val['url'] = instance.url;
  val['projectKey'] = instance.projectKey;
  writeNotNull('fallbackIsInStockValue', instance.fallbackIsInStockValue);
  writeNotNull('productQueryPredicate', instance.productQueryPredicate);
  writeNotNull('useImagesObjects', instance.useImagesObjects);
  writeNotNull('customFields', instance.customFields?.toJson());
  return val;
}
