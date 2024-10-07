// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'banners.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Banners _$BannersFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Banners',
      json,
      ($checkedConvert) {
        final val = Banners(
          banners: $checkedConvert(
              'banners',
              (v) => v == null
                  ? null
                  : Banner.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$BannersToJson(Banners instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('banners', instance.banners?.toJson());
  return val;
}
