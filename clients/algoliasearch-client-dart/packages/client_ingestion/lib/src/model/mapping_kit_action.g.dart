// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'mapping_kit_action.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

MappingKitAction _$MappingKitActionFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'MappingKitAction',
      json,
      ($checkedConvert) {
        final val = MappingKitAction(
          id: $checkedConvert('id', (v) => v as String?),
          enabled: $checkedConvert('enabled', (v) => v as bool),
          trigger: $checkedConvert('trigger', (v) => v as String),
          fieldDirectives: $checkedConvert(
              'fieldDirectives',
              (v) => (v as List<dynamic>)
                  .map((e) =>
                      MappingFieldDirective.fromJson(e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$MappingKitActionToJson(MappingKitAction instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('id', instance.id);
  val['enabled'] = instance.enabled;
  val['trigger'] = instance.trigger;
  val['fieldDirectives'] =
      instance.fieldDirectives.map((e) => e.toJson()).toList();
  return val;
}
