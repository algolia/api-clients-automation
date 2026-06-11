// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'commercetools_custom_fields.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CommercetoolsCustomFields _$CommercetoolsCustomFieldsFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'CommercetoolsCustomFields',
      json,
      ($checkedConvert) {
        final val = CommercetoolsCustomFields(
          inventory: $checkedConvert('inventory',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          price: $checkedConvert('price',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          category: $checkedConvert('category',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$CommercetoolsCustomFieldsToJson(
    CommercetoolsCustomFields instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('inventory', instance.inventory);
  writeNotNull('price', instance.price);
  writeNotNull('category', instance.category);
  return val;
}
