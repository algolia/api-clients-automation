// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'policies.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Policies _$PoliciesFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Policies',
      json,
      ($checkedConvert) {
        final val = Policies(
          criticalThreshold:
              $checkedConvert('criticalThreshold', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$PoliciesToJson(Policies instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('criticalThreshold', instance.criticalThreshold);
  return val;
}
