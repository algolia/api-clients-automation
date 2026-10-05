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
          analyticsDegraded:
              $checkedConvert('analyticsDegraded', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$PaginatedConversationsResponseToJson(
    PaginatedConversationsResponse instance) {
  final val = <String, dynamic>{
    'data': instance.data.map((e) => e.toJson()).toList(),
    'pagination': instance.pagination.toJson(),
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('analyticsDegraded', instance.analyticsDegraded);
  return val;
}
