// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'context_compact_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ContextCompactRequest _$ContextCompactRequestFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ContextCompactRequest',
      json,
      ($checkedConvert) {
        final val = ContextCompactRequest(
          providerID: $checkedConvert('providerID', (v) => v as String),
          model: $checkedConvert('model', (v) => v as String),
          messages: $checkedConvert('messages', (v) => v),
          keepLastMessages:
              $checkedConvert('keepLastMessages', (v) => (v as num?)?.toInt()),
          instructions: $checkedConvert('instructions', (v) => v as String?),
          targetTokensEstimate: $checkedConvert(
              'targetTokensEstimate', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$ContextCompactRequestToJson(
    ContextCompactRequest instance) {
  final val = <String, dynamic>{
    'providerID': instance.providerID,
    'model': instance.model,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('messages', instance.messages);
  writeNotNull('keepLastMessages', instance.keepLastMessages);
  writeNotNull('instructions', instance.instructions);
  writeNotNull('targetTokensEstimate', instance.targetTokensEstimate);
  return val;
}
