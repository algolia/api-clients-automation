// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'conversation_metadata.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ConversationMetadata _$ConversationMetadataFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'ConversationMetadata',
      json,
      ($checkedConvert) {
        final val = ConversationMetadata(
          cachedAt: $checkedConvert('cachedAt', (v) => v as String?),
        );
        return val;
      },
    );

Map<String, dynamic> _$ConversationMetadataToJson(
    ConversationMetadata instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('cachedAt', instance.cachedAt);
  return val;
}
