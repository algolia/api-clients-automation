// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'notifications.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Notifications _$NotificationsFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'Notifications',
      json,
      ($checkedConvert) {
        final val = Notifications(
          email: $checkedConvert('email',
              (v) => EmailNotifications.fromJson(v as Map<String, dynamic>)),
        );
        return val;
      },
    );

Map<String, dynamic> _$NotificationsToJson(Notifications instance) =>
    <String, dynamic>{
      'email': instance.email.toJson(),
    };
