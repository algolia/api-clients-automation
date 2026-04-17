// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'response_extensions.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ResponseExtensions _$ResponseExtensionsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ResponseExtensions',
      json,
      ($checkedConvert) {
        final val = ResponseExtensions(
          queryCategorization: $checkedConvert(
              'queryCategorization',
              (v) => v == null
                  ? null
                  : QueryCategorization.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$ResponseExtensionsToJson(ResponseExtensions instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('queryCategorization', instance.queryCategorization?.toJson());
  return val;
}
