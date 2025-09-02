// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'empty_search_filter.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

EmptySearchFilter _$EmptySearchFilterFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'EmptySearchFilter',
      json,
      ($checkedConvert) {
        final val = EmptySearchFilter(
          usersCount:
              $checkedConvert('usersCount', (v) => (v as num?)?.toInt()),
          trackedSearchesCount: $checkedConvert(
              'trackedSearchesCount', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$EmptySearchFilterToJson(EmptySearchFilter instance) {
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
