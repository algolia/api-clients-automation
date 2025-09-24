// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'injected_item.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

InjectedItem _$InjectedItemFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'InjectedItem',
      json,
      ($checkedConvert) {
        final val = InjectedItem(
          key: $checkedConvert('key', (v) => v as String),
          source: $checkedConvert('source', (v) => v),
          position: $checkedConvert('position', (v) => (v as num).toInt()),
          length: $checkedConvert('length', (v) => (v as num).toInt()),
          metadata: $checkedConvert(
              'metadata',
              (v) => v == null
                  ? null
                  : InjectedItemMetadata.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$InjectedItemToJson(InjectedItem instance) {
  final val = <String, dynamic>{
    'key': instance.key,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('source', instance.source);
  val['position'] = instance.position;
  val['length'] = instance.length;
  writeNotNull('metadata', instance.metadata?.toJson());
  return val;
}
