// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'mapping_input.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MappingInput _$MappingInputFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'MappingInput',
      json,
      ($checkedConvert) {
        final val = MappingInput(
          format: $checkedConvert(
              'format', (v) => $enumDecode(_$MappingFormatSchemaEnumMap, v)),
          actions: $checkedConvert(
              'actions',
              (v) => (v as List<dynamic>)
                  .map((e) =>
                      MappingKitAction.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$MappingInputToJson(MappingInput instance) =>
    <String, dynamic>{
      'format': instance.format.toJson(),
      'actions': instance.actions.map((e) => e.toJson()).toList(),
    };

const _$MappingFormatSchemaEnumMap = {
  MappingFormatSchema.mappingkitSlashV1: 'mappingkit/v1',
};
