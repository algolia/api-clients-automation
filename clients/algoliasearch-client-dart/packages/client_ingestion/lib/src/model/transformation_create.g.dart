// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'transformation_create.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TransformationCreate _$TransformationCreateFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'TransformationCreate',
      json,
      ($checkedConvert) {
        final val = TransformationCreate(
          code: $checkedConvert('code', (v) => v as String?),
          name: $checkedConvert('name', (v) => v as String),
          type: $checkedConvert('type',
              (v) => $enumDecodeNullable(_$TransformationTypeEnumMap, v)),
          input: $checkedConvert('input', (v) => v),
          description: $checkedConvert('description', (v) => v as String?),
          authenticationIDs: $checkedConvert('authenticationIDs',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$TransformationCreateToJson(
    TransformationCreate instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('code', instance.code);
  val['name'] = instance.name;
  writeNotNull('type', instance.type?.toJson());
  writeNotNull('input', instance.input);
  writeNotNull('description', instance.description);
  writeNotNull('authenticationIDs', instance.authenticationIDs);
  return val;
}

const _$TransformationTypeEnumMap = {
  TransformationType.code: 'code',
  TransformationType.noCode: 'noCode',
};
