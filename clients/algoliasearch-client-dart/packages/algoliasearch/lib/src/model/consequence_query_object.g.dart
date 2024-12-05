// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'consequence_query_object.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ConsequenceQueryObject _$ConsequenceQueryObjectFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ConsequenceQueryObject',
      json,
      ($checkedConvert) {
        final val = ConsequenceQueryObject(
          remove: $checkedConvert('remove',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
          edits: $checkedConvert(
              'edits',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => Edit.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$ConsequenceQueryObjectToJson(
        ConsequenceQueryObject instance) =>
    <String, dynamic>{
      if (instance.remove case final value?) 'remove': value,
      if (instance.edits?.map((e) => e.toJson()).toList() case final value?)
        'edits': value,
    };
