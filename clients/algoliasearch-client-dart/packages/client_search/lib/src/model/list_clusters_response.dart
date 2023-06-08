// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element

import 'package:json_annotation/json_annotation.dart';

part 'list_clusters_response.g.dart';

@JsonSerializable()
final class ListClustersResponse {
  /// Returns a new [ListClustersResponse] instance.
  const ListClustersResponse({
    required this.topUsers,
  });

  /// Mapping of cluster names to top users.
  @JsonKey(name: r'topUsers')
  final List<String> topUsers;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is ListClustersResponse && other.topUsers == topUsers;

  @override
  int get hashCode => topUsers.hashCode;

  factory ListClustersResponse.fromJson(Map<String, dynamic> json) =>
      _$ListClustersResponseFromJson(json);

  Map<String, dynamic> toJson() => _$ListClustersResponseToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
