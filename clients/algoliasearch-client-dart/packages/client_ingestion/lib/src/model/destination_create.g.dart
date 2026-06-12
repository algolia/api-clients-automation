// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'destination_create.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

DestinationCreate _$DestinationCreateFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'DestinationCreate',
      json,
      ($checkedConvert) {
        final val = DestinationCreate(
          type: $checkedConvert(
              'type', (v) => $enumDecode(_$DestinationTypeEnumMap, v)),
          name: $checkedConvert('name', (v) => v as String),
          input: $checkedConvert('input',
              (v) => DestinationInput.fromJson(v as Map<String, dynamic>)),
          authenticationID:
              $checkedConvert('authenticationID', (v) => v as String?),
          transformationIDs: $checkedConvert('transformationIDs',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$DestinationCreateToJson(DestinationCreate instance) {
  final val = <String, dynamic>{
    'type': instance.type.toJson(),
    'name': instance.name,
    'input': instance.input.toJson(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('authenticationID', instance.authenticationID);
  writeNotNull('transformationIDs', instance.transformationIDs);
  return val;
}

const _$DestinationTypeEnumMap = {
  DestinationType.search: 'search',
  DestinationType.insights: 'insights',
};
