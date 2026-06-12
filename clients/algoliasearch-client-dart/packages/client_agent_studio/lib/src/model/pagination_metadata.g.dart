// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'pagination_metadata.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PaginationMetadata _$PaginationMetadataFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'PaginationMetadata',
      json,
      ($checkedConvert) {
        final val = PaginationMetadata(
          page: $checkedConvert('page', (v) => (v as num).toInt()),
          limit: $checkedConvert('limit', (v) => (v as num).toInt()),
          totalCount: $checkedConvert('totalCount', (v) => (v as num).toInt()),
          totalPages: $checkedConvert('totalPages', (v) => (v as num).toInt()),
        );
        return val;
      },
    );

Map<String, dynamic> _$PaginationMetadataToJson(PaginationMetadata instance) =>
    <String, dynamic>{
      'page': instance.page,
      'limit': instance.limit,
      'totalCount': instance.totalCount,
      'totalPages': instance.totalPages,
    };
