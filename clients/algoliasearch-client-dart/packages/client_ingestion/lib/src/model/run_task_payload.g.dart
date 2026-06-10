// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'run_task_payload.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RunTaskPayload _$RunTaskPayloadFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'RunTaskPayload',
      json,
      ($checkedConvert) {
        final val = RunTaskPayload(
          runMetadata: $checkedConvert(
              'runMetadata',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$RunTaskPayloadToJson(RunTaskPayload instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('runMetadata', instance.runMetadata);
  return val;
}
