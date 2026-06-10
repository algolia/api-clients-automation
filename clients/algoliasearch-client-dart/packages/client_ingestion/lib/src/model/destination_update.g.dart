// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'destination_update.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

DestinationUpdate _$DestinationUpdateFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'DestinationUpdate',
      json,
      ($checkedConvert) {
        final val = DestinationUpdate(
          name: $checkedConvert('name', (v) => v as String?),
          input: $checkedConvert(
              'input',
              (v) => v == null
                  ? null
                  : DestinationUpdateInput.fromJson(v as Map<String, dynamic>)),
          authenticationID:
              $checkedConvert('authenticationID', (v) => v as String?),
          transformationIDs: $checkedConvert('transformationIDs',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$DestinationUpdateToJson(DestinationUpdate instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('name', instance.name);
  writeNotNull('input', instance.input?.toJson());
  writeNotNull('authenticationID', instance.authenticationID);
  writeNotNull('transformationIDs', instance.transformationIDs);
  return val;
}
