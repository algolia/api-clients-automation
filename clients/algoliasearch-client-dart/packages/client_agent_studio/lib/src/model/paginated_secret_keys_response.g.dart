// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'paginated_secret_keys_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PaginatedSecretKeysResponse _$PaginatedSecretKeysResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'PaginatedSecretKeysResponse',
      json,
      ($checkedConvert) {
        final val = PaginatedSecretKeysResponse(
          data: $checkedConvert(
              'data',
              (v) => (v as List<dynamic>)
                  .map((e) =>
                      SecretKeyResponse.fromJson(e as Map<String, dynamic>))
                  .toList()),
          pagination: $checkedConvert('pagination',
              (v) => PaginationMetadata.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$PaginatedSecretKeysResponseToJson(
        PaginatedSecretKeysResponse instance) =>
    <String, dynamic>{
      'data': instance.data.map((e) => e.toJson()).toList(),
      'pagination': instance.pagination.toJson(),
    };
