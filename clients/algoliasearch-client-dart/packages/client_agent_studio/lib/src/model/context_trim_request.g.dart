// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'context_trim_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ContextTrimRequest _$ContextTrimRequestFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'ContextTrimRequest',
      json,
      ($checkedConvert) {
        final val = ContextTrimRequest(
          messages: $checkedConvert('messages', (v) => v),
          keepLastMessages:
              $checkedConvert('keepLastMessages', (v) => (v as num?)?.toInt()),
          maxTokensEstimate:
              $checkedConvert('maxTokensEstimate', (v) => (v as num?)?.toInt()),
          dropToolParts: $checkedConvert('dropToolParts', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$ContextTrimRequestToJson(ContextTrimRequest instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('messages', instance.messages);
  writeNotNull('keepLastMessages', instance.keepLastMessages);
  writeNotNull('maxTokensEstimate', instance.maxTokensEstimate);
  writeNotNull('dropToolParts', instance.dropToolParts);
  return val;
}
