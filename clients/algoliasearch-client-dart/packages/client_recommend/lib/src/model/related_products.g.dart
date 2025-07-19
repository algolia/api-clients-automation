// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'related_products.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RelatedProducts _$RelatedProductsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'RelatedProducts',
      json,
      ($checkedConvert) {
        final val = RelatedProducts(
          model: $checkedConvert(
              'model', (v) => $enumDecode(_$RelatedModelEnumMap, v)),
          objectID: $checkedConvert('objectID', (v) => v as String),
          fallbackParameters: $checkedConvert(
              'fallbackParameters',
              (v) => v == null
                  ? null
                  : FallbackParams.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$RelatedProductsToJson(RelatedProducts instance) {
  final val = <String, dynamic>{
    'model': instance.model.toJson(),
    'objectID': instance.objectID,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('fallbackParameters', instance.fallbackParameters?.toJson());
  return val;
}

const _$RelatedModelEnumMap = {
  RelatedModel.relatedProducts: 'related-products',
};
