// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'external_injection.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ExternalInjection _$ExternalInjectionFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ExternalInjection',
      json,
      ($checkedConvert) {
        final val = ExternalInjection(
          objectID: $checkedConvert('objectID', (v) => v as String),
          metadata: $checkedConvert(
              'metadata',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$ExternalInjectionToJson(ExternalInjection instance) {
  final val = <String, dynamic>{
    'objectID': instance.objectID,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('metadata', instance.metadata);
  return val;
}
