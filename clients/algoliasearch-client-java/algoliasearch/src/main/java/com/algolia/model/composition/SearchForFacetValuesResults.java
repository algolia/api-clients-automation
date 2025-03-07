// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.composition;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** SearchForFacetValuesResults */
public class SearchForFacetValuesResults {

  @JsonProperty("indexName")
  private String indexName;

  @JsonProperty("facetHits")
  private List<FacetHits> facetHits = new ArrayList<>();

  @JsonProperty("exhaustiveFacetsCount")
  private Boolean exhaustiveFacetsCount;

  @JsonProperty("processingTimeMS")
  private Integer processingTimeMS;

  public SearchForFacetValuesResults setIndexName(String indexName) {
    this.indexName = indexName;
    return this;
  }

  /** Get indexName */
  @javax.annotation.Nonnull
  public String getIndexName() {
    return indexName;
  }

  public SearchForFacetValuesResults setFacetHits(List<FacetHits> facetHits) {
    this.facetHits = facetHits;
    return this;
  }

  public SearchForFacetValuesResults addFacetHits(FacetHits facetHitsItem) {
    this.facetHits.add(facetHitsItem);
    return this;
  }

  /** Matching facet values. */
  @javax.annotation.Nonnull
  public List<FacetHits> getFacetHits() {
    return facetHits;
  }

  public SearchForFacetValuesResults setExhaustiveFacetsCount(Boolean exhaustiveFacetsCount) {
    this.exhaustiveFacetsCount = exhaustiveFacetsCount;
    return this;
  }

  /**
   * Whether the facet count is exhaustive (true) or approximate (false). For more information, see
   * [Why are my facet and hit counts not
   * accurate](https://support.algolia.com/hc/en-us/articles/4406975248145-Why-are-my-facet-and-hit-counts-not-accurate-).
   */
  @javax.annotation.Nonnull
  public Boolean getExhaustiveFacetsCount() {
    return exhaustiveFacetsCount;
  }

  public SearchForFacetValuesResults setProcessingTimeMS(Integer processingTimeMS) {
    this.processingTimeMS = processingTimeMS;
    return this;
  }

  /** Time the server took to process the request, in milliseconds. */
  @javax.annotation.Nullable
  public Integer getProcessingTimeMS() {
    return processingTimeMS;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchForFacetValuesResults searchForFacetValuesResults = (SearchForFacetValuesResults) o;
    return (
      Objects.equals(this.indexName, searchForFacetValuesResults.indexName) &&
      Objects.equals(this.facetHits, searchForFacetValuesResults.facetHits) &&
      Objects.equals(this.exhaustiveFacetsCount, searchForFacetValuesResults.exhaustiveFacetsCount) &&
      Objects.equals(this.processingTimeMS, searchForFacetValuesResults.processingTimeMS)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(indexName, facetHits, exhaustiveFacetsCount, processingTimeMS);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchForFacetValuesResults {\n");
    sb.append("    indexName: ").append(toIndentedString(indexName)).append("\n");
    sb.append("    facetHits: ").append(toIndentedString(facetHits)).append("\n");
    sb.append("    exhaustiveFacetsCount: ").append(toIndentedString(exhaustiveFacetsCount)).append("\n");
    sb.append("    processingTimeMS: ").append(toIndentedString(processingTimeMS)).append("\n");
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
