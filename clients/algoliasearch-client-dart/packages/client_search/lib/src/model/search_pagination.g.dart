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
          page: $checkedConvert('page', (v) => (v as num).toInt()),
          nbHits: $checkedConvert('nbHits', (v) => (v as num).toInt()),
          nbPages: $checkedConvert('nbPages', (v) => (v as num).toInt()),
          hitsPerPage:
              $checkedConvert('hitsPerPage', (v) => (v as num).toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$SearchPaginationToJson(SearchPagination instance) =>
    <String, dynamic>{
      'page': instance.page,
      'nbHits': instance.nbHits,
      'nbPages': instance.nbPages,
      'hitsPerPage': instance.hitsPerPage,
    };
