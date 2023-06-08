// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element

import 'package:json_annotation/json_annotation.dart';

part 'personalization.g.dart';

@JsonSerializable()
final class Personalization {
  /// Returns a new [Personalization] instance.
  const Personalization({
    this.filtersScore,
    this.rankingScore,
    this.score,
  });

  /// The score of the filters.
  @JsonKey(name: r'filtersScore')
  final int? filtersScore;

  /// The score of the ranking.
  @JsonKey(name: r'rankingScore')
  final int? rankingScore;

  /// The score of the event.
  @JsonKey(name: r'score')
  final int? score;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is Personalization &&
          other.filtersScore == filtersScore &&
          other.rankingScore == rankingScore &&
          other.score == score;

  @override
  int get hashCode =>
      filtersScore.hashCode + rankingScore.hashCode + score.hashCode;

  factory Personalization.fromJson(Map<String, dynamic> json) =>
      _$PersonalizationFromJson(json);

  Map<String, dynamic> toJson() => _$PersonalizationToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
