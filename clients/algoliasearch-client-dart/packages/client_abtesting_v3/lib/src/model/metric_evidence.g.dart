// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'metric_evidence.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MetricEvidence _$MetricEvidenceFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'MetricEvidence',
      json,
      ($checkedConvert) {
        final val = MetricEvidence(
          status: $checkedConvert(
              'status', (v) => $enumDecode(_$EvidenceStatusEnumMap, v)),
        );
        return val;
      },
    );

Map<String, dynamic> _$MetricEvidenceToJson(MetricEvidence instance) =>
    <String, dynamic>{
      'status': instance.status.toJson(),
    };

const _$EvidenceStatusEnumMap = {
  EvidenceStatus.enough: 'enough',
  EvidenceStatus.notEnough: 'not_enough',
  EvidenceStatus.collecting: 'collecting',
  EvidenceStatus.noData: 'no_data',
  EvidenceStatus.unavailable: 'unavailable',
};
