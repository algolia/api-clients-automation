// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'looking_similar.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

LookingSimilar _$LookingSimilarFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'LookingSimilar',
      json,
      ($checkedConvert) {
        final val = LookingSimilar(
          model: $checkedConvert(
              'model', (v) => $enumDecode(_$LookingSimilarModelEnumMap, v)),
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

Map<String, dynamic> _$LookingSimilarToJson(LookingSimilar instance) {
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

const _$LookingSimilarModelEnumMap = {
  LookingSimilarModel.lookingSimilar: 'looking-similar',
};
