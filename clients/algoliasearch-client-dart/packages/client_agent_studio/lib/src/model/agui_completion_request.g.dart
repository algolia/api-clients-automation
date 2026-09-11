// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'agui_completion_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AguiCompletionRequest _$AguiCompletionRequestFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'AguiCompletionRequest',
      json,
      ($checkedConvert) {
        final val = AguiCompletionRequest(
          threadId: $checkedConvert('threadId', (v) => v as String),
          runId: $checkedConvert('runId', (v) => v as String),
          parentRunId: $checkedConvert('parentRunId', (v) => v as String?),
          messages: $checkedConvert('messages', (v) => v as List<dynamic>),
          forwardedProps: $checkedConvert(
              'forwardedProps',
              (v) => v == null
                  ? null
                  : ForwardedProps.fromJson(v as Map<String, dynamic>)),
          resume: $checkedConvert(
              'resume',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => AguiResume.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$AguiCompletionRequestToJson(
    AguiCompletionRequest instance) {
  final val = <String, dynamic>{
    'threadId': instance.threadId,
    'runId': instance.runId,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('parentRunId', instance.parentRunId);
  val['messages'] = instance.messages.toList();
  writeNotNull('forwardedProps', instance.forwardedProps?.toJson());
  writeNotNull('resume', instance.resume?.map((e) => e.toJson()).toList());
  return val;
}
