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

Map<String, dynamic> _$BannerImageToJson(BannerImage instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('urls', instance.urls?.map((e) => e.toJson()).toList());
  writeNotNull('title', instance.title);
  return val;
}
