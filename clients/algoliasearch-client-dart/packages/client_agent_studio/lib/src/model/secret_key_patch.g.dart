// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'secret_key_patch.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SecretKeyPatch _$SecretKeyPatchFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SecretKeyPatch',
      json,
      ($checkedConvert) {
        final val = SecretKeyPatch(
          name: $checkedConvert('name', (v) => v as String?),
          agentIds: $checkedConvert('agentIds',
              (v) => (v as List<dynamic>?)?.map((e) => e as String).toList()),
        );
        return val;
      },
    );

Map<String, dynamic> _$SecretKeyPatchToJson(SecretKeyPatch instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('name', instance.name);
  writeNotNull('agentIds', instance.agentIds);
  return val;
}
