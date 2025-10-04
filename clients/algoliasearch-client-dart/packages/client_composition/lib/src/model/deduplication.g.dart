// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'deduplication.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Deduplication _$DeduplicationFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'Deduplication',
      json,
      ($checkedConvert) {
        final val = Deduplication(
          positioning: $checkedConvert(
              'positioning', (v) => $enumDecode(_$DedupPositioningEnumMap, v)),
        );
        return val;
      },
    );

Map<String, dynamic> _$DeduplicationToJson(Deduplication instance) =>
    <String, dynamic>{
      'positioning': instance.positioning.toJson(),
    };

const _$DedupPositioningEnumMap = {
  DedupPositioning.highest: 'highest',
  DedupPositioning.highestInjected: 'highestInjected',
};
