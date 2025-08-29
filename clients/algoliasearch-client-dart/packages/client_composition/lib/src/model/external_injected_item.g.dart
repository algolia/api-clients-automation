// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'external_injected_item.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ExternalInjectedItem _$ExternalInjectedItemFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ExternalInjectedItem',
      json,
      ($checkedConvert) {
        final val = ExternalInjectedItem(
          objectID: $checkedConvert('objectID', (v) => v as String),
          metadata: $checkedConvert(
              'metadata',
              (v) => v == null
                  ? null
                  : Metadata.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$ExternalInjectedItemToJson(
    ExternalInjectedItem instance) {
  final val = <String, dynamic>{
    'objectID': instance.objectID,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('metadata', instance.metadata?.toJson());
  return val;
}
