// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'matched_geo_location.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MatchedGeoLocation _$MatchedGeoLocationFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'MatchedGeoLocation',
      json,
      ($checkedConvert) {
        final val = MatchedGeoLocation(
          lat: $checkedConvert('lat', (v) => (v as num?)?.toDouble()),
          lng: $checkedConvert('lng', (v) => (v as num?)?.toDouble()),
          distance: $checkedConvert('distance', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$MatchedGeoLocationToJson(MatchedGeoLocation instance) =>
    <String, dynamic>{
      if (instance.lat case final value?) 'lat': value,
      if (instance.lng case final value?) 'lng': value,
      if (instance.distance case final value?) 'distance': value,
    };
