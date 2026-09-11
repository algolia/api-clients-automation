// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'agui_resume.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AguiResume _$AguiResumeFromJson(Map<String, dynamic> json) => $checkedCreate(
      'AguiResume',
      json,
      ($checkedConvert) {
        final val = AguiResume(
          interruptId: $checkedConvert('interruptId', (v) => v as String),
          status: $checkedConvert(
              'status', (v) => $enumDecode(_$StatusEnumEnumMap, v)),
          payload: $checkedConvert(
              'payload',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$AguiResumeToJson(AguiResume instance) {
  final val = <String, dynamic>{
    'interruptId': instance.interruptId,
    'status': instance.status.toJson(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('payload', instance.payload);
  return val;
}

const _$StatusEnumEnumMap = {
  StatusEnum.resolved: 'resolved',
  StatusEnum.cancelled: 'cancelled',
};
