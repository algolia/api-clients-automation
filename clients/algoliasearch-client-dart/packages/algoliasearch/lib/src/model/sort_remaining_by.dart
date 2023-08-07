// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:json_annotation/json_annotation.dart';

/// How to display the remaining items:    - `count`: facet count (descending).   - `alpha`: alphabetical (ascending).   - `hidden`: show only pinned values.
@JsonEnum(valueField: 'raw')
enum SortRemainingBy {
  /// How to display the remaining items:    - `count`: facet count (descending).   - `alpha`: alphabetical (ascending).   - `hidden`: show only pinned values.
  count(r'count'),

  /// How to display the remaining items:    - `count`: facet count (descending).   - `alpha`: alphabetical (ascending).   - `hidden`: show only pinned values.
  alpha(r'alpha'),

  /// How to display the remaining items:    - `count`: facet count (descending).   - `alpha`: alphabetical (ascending).   - `hidden`: show only pinned values.
  hidden(r'hidden');

  const SortRemainingBy(this.raw);
  final dynamic raw;

  dynamic toJson() => raw;

  static SortRemainingBy fromJson(dynamic json) {
    for (final value in values) {
      if (value.raw == json) return value;
    }
    throw ArgumentError.value(json, "raw", "No enum value with that value");
  }

  @override
  String toString() => raw.toString();
}
