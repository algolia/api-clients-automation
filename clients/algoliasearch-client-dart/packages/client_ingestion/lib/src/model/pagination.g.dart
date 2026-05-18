// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'pagination.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Pagination _$PaginationFromJson(Map<String, dynamic> json) => $checkedCreate(
      'Pagination',
      json,
      ($checkedConvert) {
        final val = Pagination(
          nbPages: $checkedConvert('nbPages', (v) => (v as num).toInt()),
          page: $checkedConvert('page', (v) => (v as num).toInt()),
          nbItems: $checkedConvert('nbItems', (v) => (v as num).toInt()),
          itemsPerPage:
              $checkedConvert('itemsPerPage', (v) => (v as num).toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$PaginationToJson(Pagination instance) =>
    <String, dynamic>{
      'nbPages': instance.nbPages,
      'page': instance.page,
      'nbItems': instance.nbItems,
      'itemsPerPage': instance.itemsPerPage,
    };
