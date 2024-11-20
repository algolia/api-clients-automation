// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'object_data_after_search.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ObjectDataAfterSearch _$ObjectDataAfterSearchFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ObjectDataAfterSearch',
      json,
      ($checkedConvert) {
        final val = ObjectDataAfterSearch(
          queryID: $checkedConvert('queryID', (v) => v as String?),
          price: $checkedConvert('price', (v) => v),
          quantity: $checkedConvert('quantity', (v) => (v as num?)?.toInt()),
          discount: $checkedConvert('discount', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$ObjectDataAfterSearchToJson(
        ObjectDataAfterSearch instance) =>
    <String, dynamic>{
      if (instance.queryID case final value?) 'queryID': value,
      if (instance.price case final value?) 'price': value,
      if (instance.quantity case final value?) 'quantity': value,
      if (instance.discount case final value?) 'discount': value,
    };
