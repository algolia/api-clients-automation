// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'multiple_batch_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MultipleBatchRequest _$MultipleBatchRequestFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'MultipleBatchRequest',
      json,
      ($checkedConvert) {
        final val = MultipleBatchRequest(
          action:
              $checkedConvert('action', (v) => $enumDecode(_$ActionEnumMap, v)),
          body: $checkedConvert('body', (v) => v),
          indexName: $checkedConvert('indexName', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$MultipleBatchRequestToJson(
    MultipleBatchRequest instance) {
  final val = <String, dynamic>{
    'action': instance.action.toJson(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('body', instance.body);
  val['indexName'] = instance.indexName;
  return val;
}

const _$ActionEnumMap = {
  Action.addObject: 'addObject',
  Action.updateObject: 'updateObject',
  Action.partialUpdateObject: 'partialUpdateObject',
  Action.partialUpdateObjectNoCreate: 'partialUpdateObjectNoCreate',
  Action.deleteObject: 'deleteObject',
  Action.delete: 'delete',
  Action.clear: 'clear',
};
