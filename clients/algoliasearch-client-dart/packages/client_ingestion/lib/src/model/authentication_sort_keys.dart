// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:json_annotation/json_annotation.dart';

/// Used to sort the Authentication list endpoint.
@JsonEnum(valueField: 'raw')
enum AuthenticationSortKeys {
  /// Used to sort the Authentication list endpoint.
  name(r'name'),

  /// Used to sort the Authentication list endpoint.
  authType(r'auth_type'),

  /// Used to sort the Authentication list endpoint.
  platform(r'platform'),

  /// Used to sort the Authentication list endpoint.
  updatedAt(r'updatedAt'),

  /// Used to sort the Authentication list endpoint.
  createdAt(r'createdAt');

  const AuthenticationSortKeys(this.raw);
  final dynamic raw;

  dynamic toJson() => raw;

  static AuthenticationSortKeys fromJson(dynamic json) {
    for (final value in values) {
      if (value.raw == json) return value;
    }
    throw ArgumentError.value(json, "raw", "No enum value with that value");
  }

  @override
  String toString() => raw.toString();
}
