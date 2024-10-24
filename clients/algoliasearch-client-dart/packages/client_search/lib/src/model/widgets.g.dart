// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'widgets.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Widgets _$WidgetsFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Widgets',
      json,
      ($checkedConvert) {
        final val = Widgets(
          banners: $checkedConvert(
              'banners',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => Banner.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$WidgetsToJson(Widgets instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('banners', instance.banners?.map((e) => e.toJson()).toList());
  return val;
}
