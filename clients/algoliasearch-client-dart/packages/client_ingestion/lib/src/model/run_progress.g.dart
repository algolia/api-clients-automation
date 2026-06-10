// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'run_progress.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RunProgress _$RunProgressFromJson(Map<String, dynamic> json) => $checkedCreate(
      'RunProgress',
      json,
      ($checkedConvert) {
        final val = RunProgress(
          expectedNbOfEvents:
              $checkedConvert('expectedNbOfEvents', (v) => (v as num).toInt()),
          receivedNbOfEvents:
              $checkedConvert('receivedNbOfEvents', (v) => (v as num).toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$RunProgressToJson(RunProgress instance) =>
    <String, dynamic>{
      'expectedNbOfEvents': instance.expectedNbOfEvents,
      'receivedNbOfEvents': instance.receivedNbOfEvents,
    };
