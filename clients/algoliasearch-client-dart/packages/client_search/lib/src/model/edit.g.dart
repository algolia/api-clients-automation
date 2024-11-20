// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'edit.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Edit _$EditFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Edit',
      json,
      ($checkedConvert) {
        final val = Edit(
          type: $checkedConvert(
              'type', (v) => $enumDecodeNullable(_$EditTypeEnumMap, v)),
          delete: $checkedConvert('delete', (v) => v as String?),
          insert: $checkedConvert('insert', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$EditToJson(Edit instance) => <String, dynamic>{
      if (instance.type?.toJson() case final value?) 'type': value,
      if (instance.delete case final value?) 'delete': value,
      if (instance.insert case final value?) 'insert': value,
    };

const _$EditTypeEnumMap = {
  EditType.remove: 'remove',
  EditType.replace: 'replace',
};
