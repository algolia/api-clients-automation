// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algolia_client_ingestion/src/model/authentication_type.dart';
import 'package:algolia_client_ingestion/src/model/platform.dart';

import 'package:json_annotation/json_annotation.dart';

part 'authentication_update.g.dart';

@JsonSerializable()
final class AuthenticationUpdate {
  /// Returns a new [AuthenticationUpdate] instance.
  const AuthenticationUpdate({
    this.type,
    this.name,
    this.platform,
    this.input,
  });

  @JsonKey(name: r'type')
  final AuthenticationType? type;

  /// An human readable name describing the object.
  @JsonKey(name: r'name')
  final String? name;

  @JsonKey(name: r'platform')
  final Platform? platform;

  /// One of types:
  /// - [AuthOAuthPartial]
  /// - [AuthBasicPartial]
  /// - [AuthGoogleServiceAccountPartial]
  /// - [AuthAPIKeyPartial]
  /// - [AuthAlgoliaPartial]
  @JsonKey(name: r'input')
  final dynamic input;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is AuthenticationUpdate &&
          other.type == type &&
          other.name == name &&
          other.platform == platform &&
          other.input == input;

  @override
  int get hashCode =>
      type.hashCode + name.hashCode + platform.hashCode + input.hashCode;

  factory AuthenticationUpdate.fromJson(Map<String, dynamic> json) =>
      _$AuthenticationUpdateFromJson(json);

  Map<String, dynamic> toJson() => _$AuthenticationUpdateToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
