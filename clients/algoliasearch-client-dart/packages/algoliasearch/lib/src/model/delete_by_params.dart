// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element

import 'package:json_annotation/json_annotation.dart';

part 'delete_by_params.g.dart';

@JsonSerializable()
final class DeleteByParams {
  /// Returns a new [DeleteByParams] instance.
  const DeleteByParams({
    this.facetFilters,
    this.filters,
    this.numericFilters,
    this.tagFilters,
    this.aroundLatLng,
    this.aroundRadius,
    this.insideBoundingBox,
    this.insidePolygon,
  });

  /// One of types:
  /// - [List<List<String>>]
  /// - [String]
  /// - [List<String>]
  @JsonKey(name: r'facetFilters')
  final dynamic facetFilters;

  /// Filter expression to only include items that match the filter criteria in the response.  You can use these filter expressions:  - **Numeric filters.** `<facet> <op> <number>`, where `<op>` is one of `<`, `<=`, `=`, `!=`, `>`, `>=`. - **Ranges.** `<facet>:<lower> TO <upper>` where `<lower>` and `<upper>` are the lower and upper limits of the range (inclusive). - **Facet filters.** `<facet>:<value>` where `<facet>` is a facet attribute (case-sensitive) and `<value>` a facet value. - **Tag filters.** `_tags:<value>` or just `<value>` (case-sensitive). - **Boolean filters.** `<facet>: true | false`.  You can combine filters with `AND`, `OR`, and `NOT` operators with the following restrictions:  - You can only combine filters of the same type with `OR`.   **Not supported:** `facet:value OR num > 3`. - You can't use `NOT` with combinations of filters.   **Not supported:** `NOT(facet:value OR facet:value)` - You can't combine conjunctions (`AND`) with `OR`.   **Not supported:** `facet:value OR (facet:value AND facet:value)`  Use quotes around your filters, if the facet attribute name or facet value has spaces, keywords (`OR`, `AND`, `NOT`), or quotes. If a facet attribute is an array, the filter matches if it matches at least one element of the array.  For more information, see [Filters](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/).
  @JsonKey(name: r'filters')
  final String? filters;

  /// One of types:
  /// - [List<List<String>>]
  /// - [String]
  /// - [List<String>]
  @JsonKey(name: r'numericFilters')
  final dynamic numericFilters;

  /// One of types:
  /// - [List<List<String>>]
  /// - [String]
  /// - [List<String>]
  @JsonKey(name: r'tagFilters')
  final dynamic tagFilters;

  /// Coordinates for the center of a circle, expressed as a comma-separated string of latitude and longitude.  Only records included within circle around this central location are included in the results. The radius of the circle is determined by the `aroundRadius` and `minimumAroundRadius` settings. This parameter is ignored if you also specify `insidePolygon` or `insideBoundingBox`.
  @JsonKey(name: r'aroundLatLng')
  final String? aroundLatLng;

  /// One of types:
  /// - [AroundRadiusAll]
  /// - [int]
  @JsonKey(name: r'aroundRadius')
  final dynamic aroundRadius;

  /// Coordinates for a rectangular area in which to search.  Each bounding box is defined by the two opposite points of its diagonal, and expressed as latitude and longitude pair: `[p1 lat, p1 long, p2 lat, p2 long]`. Provide multiple bounding boxes as nested arrays. For more information, see [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas).
  @JsonKey(name: r'insideBoundingBox')
  final List<List<double>>? insideBoundingBox;

  /// Coordinates of a polygon in which to search.  Polygons are defined by 3 to 10,000 points. Each point is represented by its latitude and longitude. Provide multiple polygons as nested arrays. For more information, see [filtering inside polygons](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas). This parameter is ignored, if you also specify `insideBoundingBox`.
  @JsonKey(name: r'insidePolygon')
  final List<List<double>>? insidePolygon;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is DeleteByParams &&
          other.facetFilters == facetFilters &&
          other.filters == filters &&
          other.numericFilters == numericFilters &&
          other.tagFilters == tagFilters &&
          other.aroundLatLng == aroundLatLng &&
          other.aroundRadius == aroundRadius &&
          other.insideBoundingBox == insideBoundingBox &&
          other.insidePolygon == insidePolygon;

  @override
  int get hashCode =>
      facetFilters.hashCode +
      filters.hashCode +
      numericFilters.hashCode +
      tagFilters.hashCode +
      aroundLatLng.hashCode +
      aroundRadius.hashCode +
      insideBoundingBox.hashCode +
      insidePolygon.hashCode;

  factory DeleteByParams.fromJson(Map<String, dynamic> json) =>
      _$DeleteByParamsFromJson(json);

  Map<String, dynamic> toJson() => _$DeleteByParamsToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
