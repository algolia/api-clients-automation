// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'delete_composition_action.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

DeleteCompositionAction _$DeleteCompositionActionFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'DeleteCompositionAction',
      json,
      ($checkedConvert) {
        final val = DeleteCompositionAction(
          objectID: $checkedConvert('objectID', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$DeleteCompositionActionToJson(
        DeleteCompositionAction instance) =>
    <String, dynamic>{
      'objectID': instance.objectID,
    };
