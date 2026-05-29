// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'injected_item_search.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

InjectedItemSearch _$InjectedItemSearchFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'InjectedItemSearch',
      json,
      ($checkedConvert) {
        final val = InjectedItemSearch(
          index: $checkedConvert('index', (v) => v as String),
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

Map<String, dynamic> _$InjectedItemSearchToJson(InjectedItemSearch instance) {
  final val = <String, dynamic>{
    'index': instance.index,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('params', instance.params?.toJson());
  return val;
}
