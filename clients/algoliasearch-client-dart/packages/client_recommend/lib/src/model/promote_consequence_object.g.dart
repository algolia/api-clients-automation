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
    PromoteConsequenceObject instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('objectID', instance.objectID);
  writeNotNull('position', instance.position);
  return val;
}
