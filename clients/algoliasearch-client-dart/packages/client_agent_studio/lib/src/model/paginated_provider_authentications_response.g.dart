// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'paginated_provider_authentications_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PaginatedProviderAuthenticationsResponse
    _$PaginatedProviderAuthenticationsResponseFromJson(
            Map<String, dynamic> json) =>
        $checkedCreate(
          'PaginatedProviderAuthenticationsResponse',
          json,
          ($checkedConvert) {
            final val = PaginatedProviderAuthenticationsResponse(
              data: $checkedConvert(
                  'data',
                  (v) => (v as List<dynamic>)
                      .map((e) => ProviderAuthenticationResponse.fromJson(
                          e as Map<String, dynamic>))
                      .toList()),
              pagination: $checkedConvert(
                  'pagination',
                  (v) =>
                      PaginationMetadata.fromJson(v as Map<String, dynamic>)),
            );
            return val;
          },
        );

Map<String, dynamic> _$PaginatedProviderAuthenticationsResponseToJson(
        PaginatedProviderAuthenticationsResponse instance) =>
    <String, dynamic>{
      'data': instance.data.map((e) => e.toJson()).toList(),
      'pagination': instance.pagination.toJson(),
    };
