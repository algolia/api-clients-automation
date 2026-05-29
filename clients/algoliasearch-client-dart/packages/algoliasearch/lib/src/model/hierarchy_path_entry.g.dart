// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'hierarchy_path_entry.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

HierarchyPathEntry _$HierarchyPathEntryFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'HierarchyPathEntry',
      json,
      ($checkedConvert) {
        final val = HierarchyPathEntry(
          facetName: $checkedConvert('facetName', (v) => v as String?),
          facetValue: $checkedConvert('facetValue', (v) => v as String?),
          depth: $checkedConvert('depth', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$HierarchyPathEntryToJson(HierarchyPathEntry instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('facetName', instance.facetName);
  writeNotNull('facetValue', instance.facetValue);
  writeNotNull('depth', instance.depth);
  return val;
}
