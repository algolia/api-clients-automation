// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'multifeed.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Multifeed _$MultifeedFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Multifeed',
      json,
      ($checkedConvert) {
        final val = Multifeed(
          feeds: $checkedConvert(
              'feeds',
              (v) => (v as Map<String, dynamic>).map(
                    (k, e) => MapEntry(
                        k, Injection.fromJson(e as Map<String, dynamic>)),
                  )),
          feedsOrder: $checkedConvert('feedsOrder',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$MultifeedToJson(Multifeed instance) {
  final val = <String, dynamic>{
    'feeds': instance.feeds.map((k, e) => MapEntry(k, e.toJson())),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('feedsOrder', instance.feedsOrder);
  return val;
}
