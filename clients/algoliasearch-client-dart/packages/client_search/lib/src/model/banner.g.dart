// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'banner.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Banner _$BannerFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Banner',
      json,
      ($checkedConvert) {
        final val = Banner(
          image: $checkedConvert(
              'image',
              (v) => v == null
                  ? null
                  : BannerImage.fromJson(v as Map<String, dynamic>)),
          link: $checkedConvert(
              'link',
              (v) => v == null
                  ? null
                  : BannerLink.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$BannerToJson(Banner instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('image', instance.image?.toJson());
  writeNotNull('link', instance.link?.toJson());
  return val;
}
