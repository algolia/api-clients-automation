// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'email_notifications.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

EmailNotifications _$EmailNotificationsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'EmailNotifications',
      json,
      ($checkedConvert) {
        final val = EmailNotifications(
          enabled: $checkedConvert('enabled', (v) => v as bool?),
        );
        return val;
      },
    );

Map<String, dynamic> _$EmailNotificationsToJson(EmailNotifications instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('enabled', instance.enabled);
  return val;
}
