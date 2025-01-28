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

Map<String, dynamic> _$BannerToJson(Banner instance) => <String, dynamic>{
      if (instance.image?.toJson() case final value?) 'image': value,
      if (instance.link?.toJson() case final value?) 'link': value,
    };
