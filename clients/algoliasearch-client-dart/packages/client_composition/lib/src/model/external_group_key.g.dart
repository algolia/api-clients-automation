// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'external_group_key.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ExternalGroupKey _$ExternalGroupKeyFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ExternalGroupKey',
      json,
      ($checkedConvert) {
        final val = ExternalGroupKey(
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

Map<String, dynamic> _$ExternalGroupKeyToJson(ExternalGroupKey instance) {
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
