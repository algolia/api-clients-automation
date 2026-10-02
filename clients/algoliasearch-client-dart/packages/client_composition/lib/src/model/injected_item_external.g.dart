// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'injected_item_external.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

InjectedItemExternal _$InjectedItemExternalFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'InjectedItemExternal',
      json,
      ($checkedConvert) {
        final val = InjectedItemExternal(
          index: $checkedConvert('index', (v) => v as String),
          ordering: $checkedConvert('ordering',
              (v) => $enumDecodeNullable(_$ExternalOrderingEnumMap, v)),
          params: $checkedConvert(
              'params',
              (v) => v == null
                  ? null
                  : BaseInjectionQueryParameters.fromJson(
                      v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$InjectedItemExternalToJson(
    InjectedItemExternal instance) {
  final val = <String, dynamic>{
    'index': instance.index,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('ordering', instance.ordering?.toJson());
  writeNotNull('params', instance.params?.toJson());
  return val;
}

const _$ExternalOrderingEnumMap = {
  ExternalOrdering.default_: 'default',
  ExternalOrdering.userDefined: 'userDefined',
};
