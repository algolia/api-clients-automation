// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'banner_image.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BannerImage _$BannerImageFromJson(Map<String, dynamic> json) => $checkedCreate(
      'BannerImage',
      json,
      ($checkedConvert) {
        final val = BannerImage(
          urls: $checkedConvert(
              'urls',
              (v) => (v as List<dynamic>?)
                  ?.map(
                      (e) => BannerImageUrl.fromJson(e as Map<String, dynamic>))
                  .toList()),
          title: $checkedConvert('title', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$BannerImageToJson(BannerImage instance) =>
    <String, dynamic>{
      if (instance.urls?.map((e) => e.toJson()).toList() case final value?)
        'urls': value,
      if (instance.title case final value?) 'title': value,
    };
