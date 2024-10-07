// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'banner_image_url.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BannerImageUrl _$BannerImageUrlFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'BannerImageUrl',
      json,
      ($checkedConvert) {
        final val = BannerImageUrl(
          url: $checkedConvert('url', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$BannerImageUrlToJson(BannerImageUrl instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('url', instance.url);
  return val;
}
