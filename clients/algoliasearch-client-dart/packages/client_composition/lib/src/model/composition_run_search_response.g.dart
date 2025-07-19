// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'composition_run_search_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CompositionRunSearchResponse _$CompositionRunSearchResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'CompositionRunSearchResponse',
      json,
      ($checkedConvert) {
        final val = CompositionRunSearchResponse(
          objectID: $checkedConvert('objectID', (v) => v as String),
          appliedRules: $checkedConvert(
              'appliedRules',
              (v) => (v as List<dynamic>?)
                  ?.map((e) => CompositionRunAppliedRules.fromJson(
                      e as Map<String, dynamic>))
                  .toList()),
        );
        return val;
      },
    );

const _$CompositionRunSearchResponseFieldMap = <String, String>{
  'objectID': 'objectID',
  'appliedRules': 'appliedRules',
};

Map<String, dynamic> _$CompositionRunSearchResponseToJson(
    CompositionRunSearchResponse instance) {
  final val = <String, dynamic>{
    'objectID': instance.objectID,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull(
      'appliedRules', instance.appliedRules?.map((e) => e.toJson()).toList());
  return val;
}
