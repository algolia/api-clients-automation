// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'user_message_metadata_v5.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

UserMessageMetadataV5 _$UserMessageMetadataV5FromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'UserMessageMetadataV5',
      json,
      ($checkedConvert) {
        final val = UserMessageMetadataV5(
          turnContext: $checkedConvert(
              'turnContext',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
        );
        return val;
      },
    );

const _$UserMessageMetadataV5FieldMap = <String, String>{
  'turnContext': 'turnContext',
};

Map<String, dynamic> _$UserMessageMetadataV5ToJson(
    UserMessageMetadataV5 instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('turnContext', instance.turnContext);
  return val;
}
