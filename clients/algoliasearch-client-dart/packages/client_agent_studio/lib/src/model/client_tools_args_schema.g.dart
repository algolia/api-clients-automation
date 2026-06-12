// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'client_tools_args_schema.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ClientToolsArgsSchema _$ClientToolsArgsSchemaFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ClientToolsArgsSchema',
      json,
      ($checkedConvert) {
        final val = ClientToolsArgsSchema(
          type: $checkedConvert('type', (v) => v as String?),
          properties: $checkedConvert(
              'properties',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
          required_: $checkedConvert('required',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
      fieldKeyMap: const {'required_': 'required'},
    );

Map<String, dynamic> _$ClientToolsArgsSchemaToJson(
    ClientToolsArgsSchema instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('type', instance.type);
  writeNotNull('properties', instance.properties);
  writeNotNull('required', instance.required_);
  return val;
}
