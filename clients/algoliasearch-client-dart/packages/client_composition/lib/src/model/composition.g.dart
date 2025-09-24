// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'composition.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Composition _$CompositionFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Composition',
      json,
      ($checkedConvert) {
        final val = Composition(
          objectID: $checkedConvert('objectID', (v) => v as String),
          name: $checkedConvert('name', (v) => v as String),
          description: $checkedConvert('description', (v) => v as String?),
          behavior: $checkedConvert('behavior',
              (v) => CompositionBehavior.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$CompositionToJson(Composition instance) {
  final val = <String, dynamic>{
    'objectID': instance.objectID,
    'name': instance.name,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('description', instance.description);
  val['behavior'] = instance.behavior.toJson();
  return val;
}
