// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'redirect_url.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RedirectURL _$RedirectURLFromJson(Map<String, dynamic> json) => $checkedCreate(
      'RedirectURL',
      json,
      ($checkedConvert) {
        final val = RedirectURL(
          url: $checkedConvert('url', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$RedirectURLToJson(RedirectURL instance) =>
    <String, dynamic>{
      if (instance.url case final value?) 'url': value,
    };
