// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'object_data.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ObjectData _$ObjectDataFromJson(Map<String, dynamic> json) => $checkedCreate(
      'ObjectData',
      json,
      ($checkedConvert) {
        final val = ObjectData(
          price: $checkedConvert('price', (v) => v),
          quantity: $checkedConvert('quantity', (v) => (v as num?)?.toInt()),
          discount: $checkedConvert('discount', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$ObjectDataToJson(ObjectData instance) =>
    <String, dynamic>{
      if (instance.price case final value?) 'price': value,
      if (instance.quantity case final value?) 'quantity': value,
      if (instance.discount case final value?) 'discount': value,
    };
