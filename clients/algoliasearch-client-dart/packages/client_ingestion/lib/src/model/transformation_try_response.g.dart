// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'transformation_try_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TransformationTryResponse _$TransformationTryResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'TransformationTryResponse',
      json,
      ($checkedConvert) {
        final val = TransformationTryResponse(
          payloads: $checkedConvert('payloads',
              (v) => (v as List<dynamic>).map((e) => e as String).toList()),
          error: $checkedConvert(
              'error',
              (v) => v == null
                  ? null
                  : TransformationError.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$TransformationTryResponseToJson(
    TransformationTryResponse instance) {
  final val = <String, dynamic>{
    'payloads': instance.payloads,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('error', instance.error?.toJson());
  return val;
}
