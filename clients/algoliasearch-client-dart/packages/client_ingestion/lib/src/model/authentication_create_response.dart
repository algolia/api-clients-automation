// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element

import 'package:json_annotation/json_annotation.dart';

part 'authentication_create_response.g.dart';

@JsonSerializable()
final class AuthenticationCreateResponse {
  /// Returns a new [AuthenticationCreateResponse] instance.
  const AuthenticationCreateResponse({
    required this.authenticationID,
    required this.name,
    required this.createdAt,
  });

  /// The authentication UUID.
  @JsonKey(name: r'authenticationID')
  final String authenticationID;

  /// An human readable name describing the object.
  @JsonKey(name: r'name')
  final String name;

  /// Date of creation (RFC3339 format).
  @JsonKey(name: r'createdAt')
  final String createdAt;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is AuthenticationCreateResponse &&
          other.authenticationID == authenticationID &&
          other.name == name &&
          other.createdAt == createdAt;

  @override
  int get hashCode =>
      authenticationID.hashCode + name.hashCode + createdAt.hashCode;

  factory AuthenticationCreateResponse.fromJson(Map<String, dynamic> json) =>
      _$AuthenticationCreateResponseFromJson(json);

  Map<String, dynamic> toJson() => _$AuthenticationCreateResponseToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
