// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'feed_injection.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

FeedInjection _$FeedInjectionFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'FeedInjection',
      json,
      ($checkedConvert) {
        final val = FeedInjection(
          injection: $checkedConvert('injection',
              (v) => Injection.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$FeedInjectionToJson(FeedInjection instance) =>
    <String, dynamic>{
      'injection': instance.injection.toJson(),
    };
