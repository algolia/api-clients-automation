// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'base_external_source.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BaseExternalSource _$BaseExternalSourceFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'BaseExternalSource',
      json,
      ($checkedConvert) {
        final val = BaseExternalSource(
          index: $checkedConvert('index', (v) => v as String),
          ordering: $checkedConvert('ordering',
              (v) => $enumDecodeNullable(_$ExternalOrderingEnumMap, v)),
        );
        return val;
      },
    );

Map<String, dynamic> _$BaseExternalSourceToJson(BaseExternalSource instance) {
  final val = <String, dynamic>{
    'index': instance.index,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('ordering', instance.ordering?.toJson());
  return val;
}

const _$ExternalOrderingEnumMap = {
  ExternalOrdering.default_: 'default',
  ExternalOrdering.userDefined: 'userDefined',
};
