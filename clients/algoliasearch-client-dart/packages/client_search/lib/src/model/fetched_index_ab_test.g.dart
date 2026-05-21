// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'fetched_index_ab_test.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

FetchedIndexAbTest _$FetchedIndexAbTestFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'FetchedIndexAbTest',
      json,
      ($checkedConvert) {
        final val = FetchedIndexAbTest(
          id: $checkedConvert('id', (v) => (v as num).toInt()),
          isDark: $checkedConvert('isDark', (v) => v as bool?),
          version: $checkedConvert('version', (v) => (v as num?)?.toInt()),
          type: $checkedConvert('type', (v) => v as String?),
          target: $checkedConvert(
              'target',
              (v) => v == null
                  ? null
                  : FetchedIndexAbTestTarget.fromJson(
                      v as Map<String, dynamic>)),
          variants: $checkedConvert(
              'variants',
              (v) => (v as List<dynamic>)
                  .map((e) => FetchedIndexAbTestVariant.fromJson(
                      e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$FetchedIndexAbTestToJson(FetchedIndexAbTest instance) {
  final val = <String, dynamic>{
    'id': instance.id,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('isDark', instance.isDark);
  writeNotNull('version', instance.version);
  writeNotNull('type', instance.type);
  writeNotNull('target', instance.target?.toJson());
  val['variants'] = instance.variants.map((e) => e.toJson()).toList();
  return val;
}
