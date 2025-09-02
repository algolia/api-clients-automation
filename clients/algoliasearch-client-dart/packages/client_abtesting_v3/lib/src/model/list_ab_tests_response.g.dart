// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'list_ab_tests_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ListABTestsResponse _$ListABTestsResponseFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ListABTestsResponse',
      json,
      ($checkedConvert) {
        final val = ListABTestsResponse(
          abtests: $checkedConvert(
              'abtests',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => ABTest.fromJson(e as Map<String, dynamic>))
                  .toList()),
          count: $checkedConvert('count', (v) => (v as num).toInt()),
          total: $checkedConvert('total', (v) => (v as num).toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$ListABTestsResponseToJson(ListABTestsResponse instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('abtests', instance.abtests?.map((e) => e.toJson()).toList());
  val['count'] = instance.count;
  val['total'] = instance.total;
  return val;
}
