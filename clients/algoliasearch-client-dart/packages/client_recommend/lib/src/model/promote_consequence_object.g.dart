// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'promote_consequence_object.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PromoteConsequenceObject _$PromoteConsequenceObjectFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'PromoteConsequenceObject',
      json,
      ($checkedConvert) {
        final val = PromoteConsequenceObject(
          objectID: $checkedConvert('objectID', (v) => v as String?),
          position: $checkedConvert('position', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$PromoteConsequenceObjectToJson(
        PromoteConsequenceObject instance) =>
    <String, dynamic>{
      if (instance.objectID case final value?) 'objectID': value,
      if (instance.position case final value?) 'position': value,
    };
