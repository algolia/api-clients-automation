// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'request_body.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RequestBody _$RequestBodyFromJson(Map<String, dynamic> json) => $checkedCreate(
      'RequestBody',
      json,
      ($checkedConvert) {
        final val = RequestBody(
          params: $checkedConvert(
              'params',
              (v) => v == null
                  ? null
                  : Params.fromJson(v as Map<String, dynamic>)),
          feedsOrder: $checkedConvert('feedsOrder',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          externalProvider: $checkedConvert(
              'externalProvider',
              (v) => v == null
                  ? null
                  : ExternalProvider.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$RequestBodyToJson(RequestBody instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('params', instance.params?.toJson());
  writeNotNull('feedsOrder', instance.feedsOrder);
  writeNotNull('externalProvider', instance.externalProvider?.toJson());
  return val;
}
