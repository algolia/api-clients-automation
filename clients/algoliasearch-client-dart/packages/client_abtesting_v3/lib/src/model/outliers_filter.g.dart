// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'outliers_filter.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

OutliersFilter _$OutliersFilterFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'OutliersFilter',
      json,
      ($checkedConvert) {
        final val = OutliersFilter(
          usersCount:
              $checkedConvert('usersCount', (v) => (v as num?)?.toInt()),
          trackedSearchesCount: $checkedConvert(
              'trackedSearchesCount', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$OutliersFilterToJson(OutliersFilter instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('usersCount', instance.usersCount);
  writeNotNull('trackedSearchesCount', instance.trackedSearchesCount);
  return val;
}
