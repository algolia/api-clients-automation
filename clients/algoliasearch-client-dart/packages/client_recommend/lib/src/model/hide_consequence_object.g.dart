// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'hide_consequence_object.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

HideConsequenceObject _$HideConsequenceObjectFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'HideConsequenceObject',
      json,
      ($checkedConvert) {
        final val = HideConsequenceObject(
          objectID: $checkedConvert('objectID', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$HideConsequenceObjectToJson(
        HideConsequenceObject instance) =>
    <String, dynamic>{
      if (instance.objectID case final value?) 'objectID': value,
    };
