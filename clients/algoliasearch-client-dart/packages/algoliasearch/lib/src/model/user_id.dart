// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element

import 'package:json_annotation/json_annotation.dart';

part 'user_id.g.dart';

@JsonSerializable()
final class UserId {
  /// Returns a new [UserId] instance.
  const UserId({
    required this.userID,
    required this.clusterName,
    required this.nbRecords,
    required this.dataSize,
  });

  /// User ID.
  @JsonKey(name: r'userID')
  final String userID;

  /// Cluster to which the user is assigned.
  @JsonKey(name: r'clusterName')
  final String clusterName;

  /// Number of records belonging to the user.
  @JsonKey(name: r'nbRecords')
  final int nbRecords;

  /// Data size used by the user.
  @JsonKey(name: r'dataSize')
  final int dataSize;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is UserId &&
          other.userID == userID &&
          other.clusterName == clusterName &&
          other.nbRecords == nbRecords &&
          other.dataSize == dataSize;

  @override
  int get hashCode =>
      userID.hashCode +
      clusterName.hashCode +
      nbRecords.hashCode +
      dataSize.hashCode;

  factory UserId.fromJson(Map<String, dynamic> json) => _$UserIdFromJson(json);

  Map<String, dynamic> toJson() => _$UserIdToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
