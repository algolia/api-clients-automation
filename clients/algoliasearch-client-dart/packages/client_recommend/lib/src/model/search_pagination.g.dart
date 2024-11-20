// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'search_pagination.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SearchPagination _$SearchPaginationFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'SearchPagination',
      json,
      ($checkedConvert) {
        final val = SearchPagination(
          page: $checkedConvert('page', (v) => (v as num?)?.toInt()),
          nbHits: $checkedConvert('nbHits', (v) => (v as num?)?.toInt()),
          nbPages: $checkedConvert('nbPages', (v) => (v as num?)?.toInt()),
          hitsPerPage:
              $checkedConvert('hitsPerPage', (v) => (v as num?)?.toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchPaginationToJson(SearchPagination instance) =>
    <String, dynamic>{
      if (instance.page case final value?) 'page': value,
      if (instance.nbHits case final value?) 'nbHits': value,
      if (instance.nbPages case final value?) 'nbPages': value,
      if (instance.hitsPerPage case final value?) 'hitsPerPage': value,
    };
