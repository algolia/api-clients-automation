// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'transformation.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Transformation _$TransformationFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'Transformation',
      json,
      ($checkedConvert) {
        final val = Transformation(
          transformationID:
              $checkedConvert('transformationID', (v) => v as String),
          authenticationIDs: $checkedConvert('authenticationIDs',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          code: $checkedConvert('code', (v) => v as String),
          type: $checkedConvert('type',
              (v) => $enumDecodeNullable(_$TransformationTypeEnumMap, v)),
          input: $checkedConvert('input', (v) => v),
          name: $checkedConvert('name', (v) => v as String),
          description: $checkedConvert('description', (v) => v as String?),
          owner: $checkedConvert('owner', (v) => v as String?),
          createdAt: $checkedConvert('createdAt', (v) => v as String),
          updatedAt: $checkedConvert('updatedAt', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$TransformationToJson(Transformation instance) {
  final val = <String, dynamic>{
    'transformationID': instance.transformationID,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('authenticationIDs', instance.authenticationIDs);
  val['code'] = instance.code;
  writeNotNull('type', instance.type?.toJson());
  writeNotNull('input', instance.input);
  val['name'] = instance.name;
  writeNotNull('description', instance.description);
  writeNotNull('owner', instance.owner);
  val['createdAt'] = instance.createdAt;
  val['updatedAt'] = instance.updatedAt;
  return val;
}

const _$TransformationTypeEnumMap = {
  TransformationType.code: 'code',
  TransformationType.noCode: 'noCode',
};
