// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'get_objects_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

GetObjectsResponse _$GetObjectsResponseFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'GetObjectsResponse',
      json,
      ($checkedConvert) {
        final val = GetObjectsResponse(
          message: $checkedConvert('message', (v) => v as String?),
          results: $checkedConvert('results',
              (v) => (v as List<dynamic>).map((e) => e as Object).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$GetObjectsResponseToJson(GetObjectsResponse instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('message', instance.message);
  val['results'] = instance.results;
  return val;
}
