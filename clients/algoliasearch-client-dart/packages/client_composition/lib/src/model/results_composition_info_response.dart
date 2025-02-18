// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algolia_client_composition/src/model/results_injected_item_info_response.dart';

import 'package:json_annotation/json_annotation.dart';

part 'results_composition_info_response.g.dart';

@JsonSerializable()
final class ResultsCompositionInfoResponse {
  /// Returns a new [ResultsCompositionInfoResponse] instance.
  const ResultsCompositionInfoResponse({
    required this.injectedItems,
  });

  @JsonKey(name: r'injectedItems')
  final List<ResultsInjectedItemInfoResponse> injectedItems;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is ResultsCompositionInfoResponse &&
          other.injectedItems == injectedItems;

  @override
  int get hashCode => injectedItems.hashCode;

  factory ResultsCompositionInfoResponse.fromJson(Map<String, dynamic> json) =>
      _$ResultsCompositionInfoResponseFromJson(json);

  Map<String, dynamic> toJson() => _$ResultsCompositionInfoResponseToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
