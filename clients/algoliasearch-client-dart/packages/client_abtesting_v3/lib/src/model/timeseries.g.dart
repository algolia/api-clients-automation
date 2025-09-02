// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'timeseries.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Timeseries _$TimeseriesFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Timeseries',
      json,
      ($checkedConvert) {
        final val = Timeseries(
          abTestID: $checkedConvert('abTestID', (v) => (v as num).toInt()),
          variants: $checkedConvert(
              'variants',
              (v) => (v as List<dynamic>)
                  .map((e) =>
                      TimeseriesVariant.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$TimeseriesToJson(Timeseries instance) =>
    <String, dynamic>{
      'abTestID': instance.abTestID,
      'variants': instance.variants.map((e) => e.toJson()).toList(),
    };
