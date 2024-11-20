// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'cursor.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Cursor _$CursorFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Cursor',
      json,
      ($checkedConvert) {
        final val = Cursor(
          cursor: $checkedConvert('cursor', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$CursorToJson(Cursor instance) => <String, dynamic>{
      if (instance.cursor case final value?) 'cursor': value,
    };
