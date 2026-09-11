// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'user_message_metadata_agui.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

UserMessageMetadataAGUI _$UserMessageMetadataAGUIFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'UserMessageMetadataAGUI',
      json,
      ($checkedConvert) {
        final val = UserMessageMetadataAGUI(
          turnContext: $checkedConvert(
              'turnContext',
              (v) => (v as Map<String, dynamic>?)?.map(
                    (k, e) => MapEntry(k, e as Object),
                  )),
        );
        return val;
      },
    );

Map<String, dynamic> _$UserMessageMetadataAGUIToJson(
    UserMessageMetadataAGUI instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('turnContext', instance.turnContext);
  return val;
}
