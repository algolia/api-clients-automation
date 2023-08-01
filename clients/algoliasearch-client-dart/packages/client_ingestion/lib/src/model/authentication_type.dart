// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:json_annotation/json_annotation.dart';

/// Type of the Authentication, defines what kind of object is stored in the input.
@JsonEnum(valueField: 'raw')
enum AuthenticationType {
  /// Type of the Authentication, defines what kind of object is stored in the input.
  googleServiceAccount(r'googleServiceAccount'),

  /// Type of the Authentication, defines what kind of object is stored in the input.
  basic(r'basic'),

  /// Type of the Authentication, defines what kind of object is stored in the input.
  apiKey(r'apiKey'),

  /// Type of the Authentication, defines what kind of object is stored in the input.
  oauth(r'oauth'),

  /// Type of the Authentication, defines what kind of object is stored in the input.
  algolia(r'algolia');

  const AuthenticationType(this.raw);
  final dynamic raw;

  dynamic toJson() => raw;

  static AuthenticationType fromJson(dynamic json) {
    for (final value in values) {
      if (value.raw == json) return value;
    }
    throw ArgumentError.value(json, "raw", "No enum value with that value");
  }

  @override
  String toString() => raw.toString();
}
