// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'paginated_conversations_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PaginatedConversationsResponse _$PaginatedConversationsResponseFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'PaginatedConversationsResponse',
      json,
      ($checkedConvert) {
        final val = PaginatedConversationsResponse(
          data: $checkedConvert(
              'data',
              (v) => (v as List<dynamic>)
                  .map((e) => ConversationBaseResponse.fromJson(
                      e as Map<String, dynamic>))
                  .toList()),
          pagination: $checkedConvert('pagination',
              (v) => PaginationMetadata.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$PaginatedConversationsResponseToJson(
        PaginatedConversationsResponse instance) =>
    <String, dynamic>{
      'data': instance.data.map((e) => e.toJson()).toList(),
      'pagination': instance.pagination.toJson(),
    };
