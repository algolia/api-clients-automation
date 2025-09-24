// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'rules_multiple_batch_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

RulesMultipleBatchRequest _$RulesMultipleBatchRequestFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'RulesMultipleBatchRequest',
      json,
      ($checkedConvert) {
        final val = RulesMultipleBatchRequest(
          action:
              $checkedConvert('action', (v) => $enumDecode(_$ActionEnumMap, v)),
          body: $checkedConvert('body', (v) => v),
        );
        return val;
      },
    );

Map<String, dynamic> _$RulesMultipleBatchRequestToJson(
    RulesMultipleBatchRequest instance) {
  final val = <String, dynamic>{
    'action': instance.action.toJson(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('body', instance.body);
  return val;
}

const _$ActionEnumMap = {
  Action.upsert: 'upsert',
  Action.delete: 'delete',
};
