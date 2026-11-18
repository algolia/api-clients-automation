// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'google_service_account_key.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

GoogleServiceAccountKey _$GoogleServiceAccountKeyFromJson(
        Map<String, dynamic> json) =>
    $checkedCreate(
      'GoogleServiceAccountKey',
      json,
      ($checkedConvert) {
        final val = GoogleServiceAccountKey(
          type: $checkedConvert('type', (v) => v as String),
          projectId: $checkedConvert('projectId', (v) => v as String),
          privateKey: $checkedConvert('privateKey', (v) => v as String),
          clientEmail: $checkedConvert('clientEmail', (v) => v as String),
          tokenUri: $checkedConvert('tokenUri', (v) => v as String),
        );
        return val;
      },
    );

const _$GoogleServiceAccountKeyFieldMap = <String, String>{
  'type': 'type',
  'projectId': 'projectId',
  'privateKey': 'privateKey',
  'clientEmail': 'clientEmail',
  'tokenUri': 'tokenUri',
};

Map<String, dynamic> _$GoogleServiceAccountKeyToJson(
        GoogleServiceAccountKey instance) =>
    <String, dynamic>{
      'type': instance.type,
      'projectId': instance.projectId,
      'privateKey': instance.privateKey,
      'clientEmail': instance.clientEmail,
      'tokenUri': instance.tokenUri,
    };
