// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'transformation_error.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TransformationError _$TransformationErrorFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'TransformationError',
      json,
      ($checkedConvert) {
        final val = TransformationError(
          code: $checkedConvert('code', (v) => (v as num?)?.toInt()),
          message: $checkedConvert('message', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$TransformationErrorToJson(TransformationError instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('code', instance.code);
  writeNotNull('message', instance.message);
  return val;
}
