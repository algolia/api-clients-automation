/*
 * Search API
 * API powering the Search feature of Algolia.
 *
 * The version of the OpenAPI document: 0.1.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.algolia.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.Objects;

/** A single record. */
@ApiModel(description = "A single record.")
@JsonPropertyOrder(
  {
    Record.JSON_PROPERTY_OBJECT_I_D,
    Record.JSON_PROPERTY_HIGHLIGHT_RESULT,
    Record.JSON_PROPERTY_SNIPPET_RESULT,
    Record.JSON_PROPERTY_RANKING_INFO,
    Record.JSON_PROPERTY_DISTINCT_SEQ_I_D,
  }
)
@JsonTypeName("record")
public class Record extends HashMap<String, Object> {

  public static final String JSON_PROPERTY_OBJECT_I_D = "objectID";
  private String objectID;

  public static final String JSON_PROPERTY_HIGHLIGHT_RESULT =
    "_highlightResult";
  private HighlightResult highlightResult;

  public static final String JSON_PROPERTY_SNIPPET_RESULT = "_snippetResult";
  private SnippetResult snippetResult;

  public static final String JSON_PROPERTY_RANKING_INFO = "_rankingInfo";
  private RankingInfo rankingInfo;

  public static final String JSON_PROPERTY_DISTINCT_SEQ_I_D = "_distinctSeqID";
  private Integer distinctSeqID;

  public Record objectID(String objectID) {
    this.objectID = objectID;
    return this;
  }

  /**
   * Unique identifier of the object.
   *
   * @return objectID
   */
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Unique identifier of the object.")
  @JsonProperty(JSON_PROPERTY_OBJECT_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getObjectID() {
    return objectID;
  }

  @JsonProperty(JSON_PROPERTY_OBJECT_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setObjectID(String objectID) {
    this.objectID = objectID;
  }

  public Record highlightResult(HighlightResult highlightResult) {
    this.highlightResult = highlightResult;
    return this;
  }

  /**
   * Get highlightResult
   *
   * @return highlightResult
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_HIGHLIGHT_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public HighlightResult getHighlightResult() {
    return highlightResult;
  }

  @JsonProperty(JSON_PROPERTY_HIGHLIGHT_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHighlightResult(HighlightResult highlightResult) {
    this.highlightResult = highlightResult;
  }

  public Record snippetResult(SnippetResult snippetResult) {
    this.snippetResult = snippetResult;
    return this;
  }

  /**
   * Get snippetResult
   *
   * @return snippetResult
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SNIPPET_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SnippetResult getSnippetResult() {
    return snippetResult;
  }

  @JsonProperty(JSON_PROPERTY_SNIPPET_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSnippetResult(SnippetResult snippetResult) {
    this.snippetResult = snippetResult;
  }

  public Record rankingInfo(RankingInfo rankingInfo) {
    this.rankingInfo = rankingInfo;
    return this;
  }

  /**
   * Get rankingInfo
   *
   * @return rankingInfo
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_RANKING_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public RankingInfo getRankingInfo() {
    return rankingInfo;
  }

  @JsonProperty(JSON_PROPERTY_RANKING_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRankingInfo(RankingInfo rankingInfo) {
    this.rankingInfo = rankingInfo;
  }

  public Record distinctSeqID(Integer distinctSeqID) {
    this.distinctSeqID = distinctSeqID;
    return this;
  }

  /**
   * Get distinctSeqID
   *
   * @return distinctSeqID
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DISTINCT_SEQ_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getDistinctSeqID() {
    return distinctSeqID;
  }

  @JsonProperty(JSON_PROPERTY_DISTINCT_SEQ_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDistinctSeqID(Integer distinctSeqID) {
    this.distinctSeqID = distinctSeqID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Record record = (Record) o;
    return (
      Objects.equals(this.objectID, record.objectID) &&
      Objects.equals(this.highlightResult, record.highlightResult) &&
      Objects.equals(this.snippetResult, record.snippetResult) &&
      Objects.equals(this.rankingInfo, record.rankingInfo) &&
      Objects.equals(this.distinctSeqID, record.distinctSeqID) &&
      super.equals(o)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      objectID,
      highlightResult,
      snippetResult,
      rankingInfo,
      distinctSeqID,
      super.hashCode()
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Record {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    objectID: ").append(toIndentedString(objectID)).append("\n");
    sb
      .append("    highlightResult: ")
      .append(toIndentedString(highlightResult))
      .append("\n");
    sb
      .append("    snippetResult: ")
      .append(toIndentedString(snippetResult))
      .append("\n");
    sb
      .append("    rankingInfo: ")
      .append(toIndentedString(rankingInfo))
      .append("\n");
    sb
      .append("    distinctSeqID: ")
      .append(toIndentedString(distinctSeqID))
      .append("\n");
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
