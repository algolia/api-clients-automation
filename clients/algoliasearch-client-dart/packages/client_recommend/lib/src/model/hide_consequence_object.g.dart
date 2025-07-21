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
    HideConsequenceObject instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('objectID', instance.objectID);
  return val;
}
