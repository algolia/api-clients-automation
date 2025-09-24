// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'main.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Main _$MainFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Main',
      json,
      ($checkedConvert) {
        final val = Main(
          source: $checkedConvert('source',
              (v) => CompositionSource.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$MainToJson(Main instance) => <String, dynamic>{
      'source': instance.source.toJson(),
    };
