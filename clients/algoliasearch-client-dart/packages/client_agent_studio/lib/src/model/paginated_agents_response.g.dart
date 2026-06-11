// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'paginated_agents_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PaginatedAgentsResponse _$PaginatedAgentsResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'PaginatedAgentsResponse',
      json,
      ($checkedConvert) {
        final val = PaginatedAgentsResponse(
          data: $checkedConvert(
              'data',
              (v) => (v as List<dynamic>)
                  .map((e) => AgentWithVersionResponse.fromJson(
                      e as Map<String, dynamic>))
                  .toList()),
          pagination: $checkedConvert('pagination',
              (v) => PaginationMetadata.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$PaginatedAgentsResponseToJson(
        PaginatedAgentsResponse instance) =>
    <String, dynamic>{
      'data': instance.data.map((e) => e.toJson()).toList(),
      'pagination': instance.pagination.toJson(),
    };
