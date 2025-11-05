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
          fallbackParameters: $checkedConvert(
              'fallbackParameters',
              (v) => v == null
                  ? null
                  : FallbackParams.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$FrequentlyBoughtTogetherToJson(
    FrequentlyBoughtTogether instance) {
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

const _$FbtModelEnumMap = {
  FbtModel.boughtTogether: 'bought-together',
};
