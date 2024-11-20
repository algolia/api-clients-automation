// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'browse_pagination.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BrowsePagination _$BrowsePaginationFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'BrowsePagination',
      json,
      ($checkedConvert) {
        final val = BrowsePagination(
          page: $checkedConvert('page', (v) => (v as num?)?.toInt()),
          nbHits: $checkedConvert('nbHits', (v) => (v as num?)?.toInt()),
          nbPages: $checkedConvert('nbPages', (v) => (v as num?)?.toInt()),
          hitsPerPage:
              $checkedConvert('hitsPerPage', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$BrowsePaginationToJson(BrowsePagination instance) =>
    <String, dynamic>{
      if (instance.page case final value?) 'page': value,
      if (instance.nbHits case final value?) 'nbHits': value,
      if (instance.nbPages case final value?) 'nbPages': value,
      if (instance.hitsPerPage case final value?) 'hitsPerPage': value,
    };
