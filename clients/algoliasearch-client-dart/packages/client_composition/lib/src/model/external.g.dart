// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'external.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

External _$ExternalFromJson(Map<String, dynamic> json) => $checkedCreate(
      'External',
      json,
      ($checkedConvert) {
        final val = External(
          index: $checkedConvert('index', (v) => v as String),
          params: $checkedConvert(
              'params',
              (v) => v == null
                  ? null
                  : BaseInjectionQueryParameters.fromJson(
                      v as Map<String, dynamic>)),
          ordering: $checkedConvert('ordering',
              (v) => $enumDecodeNullable(_$ExternalOrderingEnumMap, v)),
        );
        return val;
      },
    );

Map<String, dynamic> _$ExternalToJson(External instance) {
  final val = <String, dynamic>{
    'index': instance.index,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('params', instance.params?.toJson());
  writeNotNull('ordering', instance.ordering?.toJson());
  return val;
}

const _$ExternalOrderingEnumMap = {
  ExternalOrdering.default_: 'default',
  ExternalOrdering.userDefined: 'userDefined',
};
