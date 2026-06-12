// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'facets_param.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

FacetsParam _$FacetsParamFromJson(Map<String, dynamic> json) => $checkedCreate(
      'FacetsParam',
      json,
      ($checkedConvert) {
        final val = FacetsParam(
          exposed: $checkedConvert('exposed', (v) => v as bool?),
          default_: $checkedConvert('default',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
      fieldKeyMap: const {'default_': 'default'},
    );

Map<String, dynamic> _$FacetsParamToJson(FacetsParam instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('exposed', instance.exposed);
  writeNotNull('default', instance.default_);
  return val;
}
