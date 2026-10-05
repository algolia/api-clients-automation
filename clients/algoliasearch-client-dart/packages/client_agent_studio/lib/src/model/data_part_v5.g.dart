// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'data_part_v5.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

DataPartV5 _$DataPartV5FromJson(Map<String, dynamic> json) => $checkedCreate(
      'DataPartV5',
      json,
      ($checkedConvert) {
        final val = DataPartV5(
          type: $checkedConvert('type', (v) => v as String),
          data: $checkedConvert(
              'data',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$DataPartV5ToJson(DataPartV5 instance) {
  final val = <String, dynamic>{
    'type': instance.type,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('data', instance.data);
  return val;
}
