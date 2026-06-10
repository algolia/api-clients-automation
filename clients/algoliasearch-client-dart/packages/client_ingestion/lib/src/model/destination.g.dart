// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'destination.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Destination _$DestinationFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Destination',
      json,
      ($checkedConvert) {
        final val = Destination(
          destinationID: $checkedConvert('destinationID', (v) => v as String),
          type: $checkedConvert(
              'type', (v) => $enumDecode(_$DestinationTypeEnumMap, v)),
          name: $checkedConvert('name', (v) => v as String),
          owner: $checkedConvert('owner', (v) => v as String?),
          input: $checkedConvert('input',
              (v) => DestinationInput.fromJson(v as Map<String, dynamic>)),
          createdAt: $checkedConvert('createdAt', (v) => v as String),
          updatedAt: $checkedConvert('updatedAt', (v) => v as String),
          authenticationID:
              $checkedConvert('authenticationID', (v) => v as String?),
          transformationIDs: $checkedConvert('transformationIDs',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$DestinationToJson(Destination instance) {
  final val = <String, dynamic>{
    'destinationID': instance.destinationID,
    'type': instance.type.toJson(),
    'name': instance.name,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('owner', instance.owner);
  val['input'] = instance.input.toJson();
  val['createdAt'] = instance.createdAt;
  val['updatedAt'] = instance.updatedAt;
  writeNotNull('authenticationID', instance.authenticationID);
  writeNotNull('transformationIDs', instance.transformationIDs);
  return val;
}

const _$DestinationTypeEnumMap = {
  DestinationType.search: 'search',
  DestinationType.insights: 'insights',
};
