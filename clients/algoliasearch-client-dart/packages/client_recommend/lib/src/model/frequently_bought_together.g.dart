// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'frequently_bought_together.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

FrequentlyBoughtTogether _$FrequentlyBoughtTogetherFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'FrequentlyBoughtTogether',
      json,
      ($checkedConvert) {
        final val = FrequentlyBoughtTogether(
          model: $checkedConvert(
              'model', (v) => $enumDecode(_$FbtModelEnumMap, v)),
          objectID: $checkedConvert('objectID', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$FrequentlyBoughtTogetherToJson(
        FrequentlyBoughtTogether instance) =>
    <String, dynamic>{
      'model': instance.model.toJson(),
      'objectID': instance.objectID,
    };

const _$FbtModelEnumMap = {
  FbtModel.boughtTogether: 'bought-together',
};
