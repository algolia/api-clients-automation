// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'transformation_try.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TransformationTry _$TransformationTryFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'TransformationTry',
      json,
      ($checkedConvert) {
        final val = TransformationTry(
          code: $checkedConvert('code', (v) => v as String?),
          type: $checkedConvert('type',
              (v) => $enumDecodeNullable(_$TransformationTypeEnumMap, v)),
          input: $checkedConvert('input', (v) => v),
          sampleRecord: $checkedConvert('sampleRecord', (v) => v as Object),
          authentications: $checkedConvert(
              'authentications',
              (v) => (v as List<dynamic>?)
                  ?.map((e) =>
                      AuthenticationCreate.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$TransformationTryToJson(TransformationTry instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('code', instance.code);
  writeNotNull('type', instance.type?.toJson());
  writeNotNull('input', instance.input);
  val['sampleRecord'] = instance.sampleRecord;
  writeNotNull('authentications',
      instance.authentications?.map((e) => e.toJson()).toList());
  return val;
}

const _$TransformationTypeEnumMap = {
  TransformationType.code: 'code',
  TransformationType.noCode: 'noCode',
};
