// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algolia_client_search/src/model/user_highlight_result.dart';

import 'package:json_annotation/json_annotation.dart';

part 'user_hit.g.dart';

@JsonSerializable()
final class UserHit {
  /// Returns a new [UserHit] instance.
  const UserHit({
    required this.userID,
    required this.clusterName,
    required this.nbRecords,
    required this.dataSize,
    required this.objectID,
    required this.highlightResult,
  });

  /// userID of the user.
  @JsonKey(name: r'userID')
  final String userID;

  /// Name of the cluster.
  @JsonKey(name: r'clusterName')
  final String clusterName;

  /// Number of records in the cluster.
  @JsonKey(name: r'nbRecords')
  final int nbRecords;

  /// Data size taken by all the users assigned to the cluster.
  @JsonKey(name: r'dataSize')
  final int dataSize;

  /// userID of the requested user. Same as userID.
  @JsonKey(name: r'objectID')
  final String objectID;

  @JsonKey(name: r'_highlightResult')
  final UserHighlightResult highlightResult;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is UserHit &&
          other.userID == userID &&
          other.clusterName == clusterName &&
          other.nbRecords == nbRecords &&
          other.dataSize == dataSize &&
          other.objectID == objectID &&
          other.highlightResult == highlightResult;

  @override
  int get hashCode =>
      userID.hashCode +
      clusterName.hashCode +
      nbRecords.hashCode +
      dataSize.hashCode +
      objectID.hashCode +
      highlightResult.hashCode;

  factory UserHit.fromJson(Map<String, dynamic> json) =>
      _$UserHitFromJson(json);

  Map<String, dynamic> toJson() => _$UserHitToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
