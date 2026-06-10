// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'mapping_field_directive.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MappingFieldDirective _$MappingFieldDirectiveFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'MappingFieldDirective',
      json,
      ($checkedConvert) {
        final val = MappingFieldDirective(
          fieldKey: $checkedConvert('fieldKey', (v) => v as String),
          value: $checkedConvert(
              'value',
              (v) => (v as Map<String, dynamic>).map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$MappingFieldDirectiveToJson(
        MappingFieldDirective instance) =>
    <String, dynamic>{
      'fieldKey': instance.fieldKey,
      'value': instance.value,
    };
