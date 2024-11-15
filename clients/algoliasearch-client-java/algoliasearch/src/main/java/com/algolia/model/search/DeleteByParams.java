// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.search;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** DeleteByParams */
public class DeleteByParams {

  @JsonProperty("facetFilters")
  private FacetFilters facetFilters;

  @JsonProperty("filters")
  private String filters;

  @JsonProperty("numericFilters")
  private NumericFilters numericFilters;

  @JsonProperty("tagFilters")
  private TagFilters tagFilters;

  @JsonProperty("aroundLatLng")
  private String aroundLatLng;

  @JsonProperty("aroundRadius")
  private AroundRadius aroundRadius;

  @JsonProperty("insideBoundingBox")
  private InsideBoundingBox insideBoundingBox;

  @JsonProperty("insidePolygon")
  private List<List<Double>> insidePolygon;

  public DeleteByParams setFacetFilters(FacetFilters facetFilters) {
    this.facetFilters = facetFilters;
    return this;
  }

  /** Get facetFilters */
  @javax.annotation.Nullable
  public FacetFilters getFacetFilters() {
    return facetFilters;
  }

  public DeleteByParams setFilters(String filters) {
    this.filters = filters;
    return this;
  }

  /**
   * Filter expression to only include items that match the filter criteria in the response. You can
   * use these filter expressions: - **Numeric filters.** `<facet> <op> <number>`, where `<op>` is
   * one of `<`, `<=`, `=`, `!=`, `>`, `>=`. - **Ranges.** `<facet>:<lower> TO <upper>` where
   * `<lower>` and `<upper>` are the lower and upper limits of the range (inclusive). - **Facet
   * filters.** `<facet>:<value>` where `<facet>` is a facet attribute (case-sensitive) and
   * `<value>` a facet value. - **Tag filters.** `_tags:<value>` or just `<value>` (case-sensitive).
   * - **Boolean filters.** `<facet>: true | false`. You can combine filters with `AND`, `OR`, and
   * `NOT` operators with the following restrictions: - You can only combine filters of the same
   * type with `OR`. **Not supported:** `facet:value OR num > 3`. - You can't use `NOT` with
   * combinations of filters. **Not supported:** `NOT(facet:value OR facet:value)` - You can't
   * combine conjunctions (`AND`) with `OR`. **Not supported:** `facet:value OR (facet:value AND
   * facet:value)` Use quotes around your filters, if the facet attribute name or facet value has
   * spaces, keywords (`OR`, `AND`, `NOT`), or quotes. If a facet attribute is an array, the filter
   * matches if it matches at least one element of the array. For more information, see
   * [Filters](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/).
   */
  @javax.annotation.Nullable
  public String getFilters() {
    return filters;
  }

  public DeleteByParams setNumericFilters(NumericFilters numericFilters) {
    this.numericFilters = numericFilters;
    return this;
  }

  /** Get numericFilters */
  @javax.annotation.Nullable
  public NumericFilters getNumericFilters() {
    return numericFilters;
  }

  public DeleteByParams setTagFilters(TagFilters tagFilters) {
    this.tagFilters = tagFilters;
    return this;
  }

  /** Get tagFilters */
  @javax.annotation.Nullable
  public TagFilters getTagFilters() {
    return tagFilters;
  }

  public DeleteByParams setAroundLatLng(String aroundLatLng) {
    this.aroundLatLng = aroundLatLng;
    return this;
  }

  /**
   * Coordinates for the center of a circle, expressed as a comma-separated string of latitude and
   * longitude. Only records included within a circle around this central location are included in
   * the results. The radius of the circle is determined by the `aroundRadius` and
   * `minimumAroundRadius` settings. This parameter is ignored if you also specify `insidePolygon`
   * or `insideBoundingBox`.
   */
  @javax.annotation.Nullable
  public String getAroundLatLng() {
    return aroundLatLng;
  }

  public DeleteByParams setAroundRadius(AroundRadius aroundRadius) {
    this.aroundRadius = aroundRadius;
    return this;
  }

  /** Get aroundRadius */
  @javax.annotation.Nullable
  public AroundRadius getAroundRadius() {
    return aroundRadius;
  }

  public DeleteByParams setInsideBoundingBox(InsideBoundingBox insideBoundingBox) {
    this.insideBoundingBox = insideBoundingBox;
    return this;
  }

  /** Get insideBoundingBox */
  @javax.annotation.Nullable
  public InsideBoundingBox getInsideBoundingBox() {
    return insideBoundingBox;
  }

  public DeleteByParams setInsidePolygon(List<List<Double>> insidePolygon) {
    this.insidePolygon = insidePolygon;
    return this;
  }

  public DeleteByParams addInsidePolygon(List<Double> insidePolygonItem) {
    if (this.insidePolygon == null) {
      this.insidePolygon = new ArrayList<>();
    }
    this.insidePolygon.add(insidePolygonItem);
    return this;
  }

  /**
   * Coordinates of a polygon in which to search. Polygons are defined by 3 to 10,000 points. Each
   * point is represented by its latitude and longitude. Provide multiple polygons as nested arrays.
   * For more information, see [filtering inside
   * polygons](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas).
   * This parameter is ignored if you also specify `insideBoundingBox`.
   */
  @javax.annotation.Nullable
  public List<List<Double>> getInsidePolygon() {
    return insidePolygon;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteByParams deleteByParams = (DeleteByParams) o;
    return (
      Objects.equals(this.facetFilters, deleteByParams.facetFilters) &&
      Objects.equals(this.filters, deleteByParams.filters) &&
      Objects.equals(this.numericFilters, deleteByParams.numericFilters) &&
      Objects.equals(this.tagFilters, deleteByParams.tagFilters) &&
      Objects.equals(this.aroundLatLng, deleteByParams.aroundLatLng) &&
      Objects.equals(this.aroundRadius, deleteByParams.aroundRadius) &&
      Objects.equals(this.insideBoundingBox, deleteByParams.insideBoundingBox) &&
      Objects.equals(this.insidePolygon, deleteByParams.insidePolygon)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(facetFilters, filters, numericFilters, tagFilters, aroundLatLng, aroundRadius, insideBoundingBox, insidePolygon);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteByParams {\n");
    sb.append("    facetFilters: ").append(toIndentedString(facetFilters)).append("\n");
    sb.append("    filters: ").append(toIndentedString(filters)).append("\n");
    sb.append("    numericFilters: ").append(toIndentedString(numericFilters)).append("\n");
    sb.append("    tagFilters: ").append(toIndentedString(tagFilters)).append("\n");
    sb.append("    aroundLatLng: ").append(toIndentedString(aroundLatLng)).append("\n");
    sb.append("    aroundRadius: ").append(toIndentedString(aroundRadius)).append("\n");
    sb.append("    insideBoundingBox: ").append(toIndentedString(insideBoundingBox)).append("\n");
    sb.append("    insidePolygon: ").append(toIndentedString(insidePolygon)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
