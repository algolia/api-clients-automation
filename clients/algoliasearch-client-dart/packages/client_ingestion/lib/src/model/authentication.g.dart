// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'authentication.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Authentication _$AuthenticationFromJson(Map<String, dynamic> json) =>
    $checkedCreate(
      'Authentication',
      json,
      ($checkedConvert) {
        final val = Authentication(
          authenticationID:
              $checkedConvert('authenticationID', (v) => v as String),
          type: $checkedConvert(
              'type', (v) => $enumDecode(_$AuthenticationTypeEnumMap, v)),
          name: $checkedConvert('name', (v) => v as String),
          platform: $checkedConvert(
              'platform', (v) => $enumDecodeNullable(_$PlatformEnumMap, v)),
          owner: $checkedConvert('owner', (v) => v as String?),
          input: $checkedConvert('input', (v) => v),
          createdAt: $checkedConvert('createdAt', (v) => v as String),
          updatedAt: $checkedConvert('updatedAt', (v) => v as String),
        );
        return val;
      },
    );

Map<String, dynamic> _$AuthenticationToJson(Authentication instance) {
  final val = <String, dynamic>{
    'authenticationID': instance.authenticationID,
    'type': instance.type.toJson(),
    'name': instance.name,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('platform', instance.platform?.toJson());
  writeNotNull('owner', instance.owner);
  writeNotNull('input', instance.input);
  val['createdAt'] = instance.createdAt;
  val['updatedAt'] = instance.updatedAt;
  return val;
}

const _$AuthenticationTypeEnumMap = {
  AuthenticationType.googleServiceAccount: 'googleServiceAccount',
  AuthenticationType.basic: 'basic',
  AuthenticationType.apiKey: 'apiKey',
  AuthenticationType.oauth: 'oauth',
  AuthenticationType.algolia: 'algolia',
  AuthenticationType.algoliaInsights: 'algoliaInsights',
  AuthenticationType.secrets: 'secrets',
};

const _$PlatformEnumMap = {
  Platform.bigcommerce: 'bigcommerce',
  Platform.commercetools: 'commercetools',
  Platform.shopify: 'shopify',
};
