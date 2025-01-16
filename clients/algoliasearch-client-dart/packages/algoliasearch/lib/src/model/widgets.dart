// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algoliasearch/src/model/banner.dart';

import 'package:json_annotation/json_annotation.dart';

part 'widgets.g.dart';

@JsonSerializable()
final class Widgets {
  /// Returns a new [Widgets] instance.
  const Widgets({
    this.banners,
  });

  /// Banners defined in the Merchandising Studio for a given search.
  @JsonKey(name: r'banners')
  final List<Banner>? banners;

  @override
  bool operator ==(Object other) =>
      identical(this, other) || other is Widgets && other.banners == banners;

  @override
  int get hashCode => banners.hashCode;

  factory Widgets.fromJson(Map<String, dynamic> json) =>
      _$WidgetsFromJson(json);

  Map<String, dynamic> toJson() => _$WidgetsToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
