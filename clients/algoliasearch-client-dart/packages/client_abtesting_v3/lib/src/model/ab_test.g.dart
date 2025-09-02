// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'ab_test.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ABTest _$ABTestFromJson(Map<String, dynamic> json) => $checkedCreate(
      'ABTest',
      json,
      ($checkedConvert) {
        final val = ABTest(
          abTestID: $checkedConvert('abTestID', (v) => (v as num).toInt()),
          updatedAt: $checkedConvert('updatedAt', (v) => v as String),
          createdAt: $checkedConvert('createdAt', (v) => v as String),
          endAt: $checkedConvert('endAt', (v) => v as String),
          stoppedAt: $checkedConvert('stoppedAt', (v) => v as String?),
          name: $checkedConvert('name', (v) => v as String),
          status:
              $checkedConvert('status', (v) => $enumDecode(_$StatusEnumMap, v)),
          variants: $checkedConvert(
              'variants',
              (v) => (v as List<dynamic>)
                  .map((e) => Variant.fromJson(e as Map<String, dynamic>))
                  .toList()),
          configuration: $checkedConvert(
              'configuration',
              (v) => v == null
                  ? null
                  : ABTestConfiguration.fromJson(v as Map<String, dynamic>)),
          migratedAbTestID:
              $checkedConvert('migratedAbTestID', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$ABTestToJson(ABTest instance) {
  final val = <String, dynamic>{
    'abTestID': instance.abTestID,
    'updatedAt': instance.updatedAt,
    'createdAt': instance.createdAt,
    'endAt': instance.endAt,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('stoppedAt', instance.stoppedAt);
  val['name'] = instance.name;
  val['status'] = instance.status.toJson();
  val['variants'] = instance.variants.map((e) => e.toJson()).toList();
  writeNotNull('configuration', instance.configuration?.toJson());
  writeNotNull('migratedAbTestID', instance.migratedAbTestID);
  return val;
}

const _$StatusEnumMap = {
  Status.active: 'active',
  Status.stopped: 'stopped',
  Status.expired: 'expired',
  Status.failed: 'failed',
};
