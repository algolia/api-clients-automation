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

Map<String, dynamic> _$BannerImageUrlToJson(BannerImageUrl instance) =>
    <String, dynamic>{
      if (instance.url case final value?) 'url': value,
    };
