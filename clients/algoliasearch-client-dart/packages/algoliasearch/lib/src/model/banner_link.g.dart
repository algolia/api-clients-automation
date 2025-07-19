// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'banner_link.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BannerLink _$BannerLinkFromJson(Map<String, dynamic> json) => $checkedCreate(
      'BannerLink',
      json,
      ($checkedConvert) {
        final val = BannerLink(
          url: $checkedConvert('url', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$BannerLinkToJson(BannerLink instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('url', instance.url);
  return val;
}
