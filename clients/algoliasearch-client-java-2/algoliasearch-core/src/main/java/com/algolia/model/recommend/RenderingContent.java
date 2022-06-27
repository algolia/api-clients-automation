package com.algolia.model.recommend;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/**
 * Content defining how the search interface should be rendered. Can be set via the settings for a
 * default value and can be overridden via rules.
 */
public class RenderingContent {

  @SerializedName("facetOrdering")
  private FacetOrdering facetOrdering;

  public RenderingContent setFacetOrdering(FacetOrdering facetOrdering) {
    this.facetOrdering = facetOrdering;
    return this;
  }

  /**
   * Get facetOrdering
   *
   * @return facetOrdering
   */
  @javax.annotation.Nullable
  public FacetOrdering getFacetOrdering() {
    return facetOrdering;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RenderingContent renderingContent = (RenderingContent) o;
    return Objects.equals(this.facetOrdering, renderingContent.facetOrdering);
  }

  @Override
  public int hashCode() {
    return Objects.hash(facetOrdering);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RenderingContent {\n");
    sb.append("    facetOrdering: ").append(toIndentedString(facetOrdering)).append("\n");
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
