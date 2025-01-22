// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.composition;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** HitRankingInfo */
public class HitRankingInfo {

  @JsonProperty("filters")
  private Integer filters;

  @JsonProperty("firstMatchedWord")
  private Integer firstMatchedWord;

  @JsonProperty("geoDistance")
  private Integer geoDistance;

  @JsonProperty("geoPrecision")
  private Integer geoPrecision;

  @JsonProperty("matchedGeoLocation")
  private MatchedGeoLocation matchedGeoLocation;

  @JsonProperty("personalization")
  private Personalization personalization;

  @JsonProperty("nbExactWords")
  private Integer nbExactWords;

  @JsonProperty("nbTypos")
  private Integer nbTypos;

  @JsonProperty("promoted")
  private Boolean promoted;

  @JsonProperty("proximityDistance")
  private Integer proximityDistance;

  @JsonProperty("userScore")
  private Integer userScore;

  @JsonProperty("words")
  private Integer words;

  @JsonProperty("promotedByReRanking")
  private Boolean promotedByReRanking;

  @JsonProperty("composed")
  private Map<String, CompositionIdRankingInfo> composed;

  public HitRankingInfo setFilters(Integer filters) {
    this.filters = filters;
    return this;
  }

  /** Whether a filter matched the query. minimum: 0 */
  @javax.annotation.Nullable
  public Integer getFilters() {
    return filters;
  }

  public HitRankingInfo setFirstMatchedWord(Integer firstMatchedWord) {
    this.firstMatchedWord = firstMatchedWord;
    return this;
  }

  /** Position of the first matched word in the best matching attribute of the record. minimum: 0 */
  @javax.annotation.Nonnull
  public Integer getFirstMatchedWord() {
    return firstMatchedWord;
  }

  public HitRankingInfo setGeoDistance(Integer geoDistance) {
    this.geoDistance = geoDistance;
    return this;
  }

  /**
   * Distance between the geo location in the search query and the best matching geo location in the
   * record, divided by the geo precision (in meters). minimum: 0
   */
  @javax.annotation.Nonnull
  public Integer getGeoDistance() {
    return geoDistance;
  }

  public HitRankingInfo setGeoPrecision(Integer geoPrecision) {
    this.geoPrecision = geoPrecision;
    return this;
  }

  /** Precision used when computing the geo distance, in meters. minimum: 1 */
  @javax.annotation.Nullable
  public Integer getGeoPrecision() {
    return geoPrecision;
  }

  public HitRankingInfo setMatchedGeoLocation(MatchedGeoLocation matchedGeoLocation) {
    this.matchedGeoLocation = matchedGeoLocation;
    return this;
  }

  /** Get matchedGeoLocation */
  @javax.annotation.Nullable
  public MatchedGeoLocation getMatchedGeoLocation() {
    return matchedGeoLocation;
  }

  public HitRankingInfo setPersonalization(Personalization personalization) {
    this.personalization = personalization;
    return this;
  }

  /** Get personalization */
  @javax.annotation.Nullable
  public Personalization getPersonalization() {
    return personalization;
  }

  public HitRankingInfo setNbExactWords(Integer nbExactWords) {
    this.nbExactWords = nbExactWords;
    return this;
  }

  /** Number of exactly matched words. minimum: 0 */
  @javax.annotation.Nonnull
  public Integer getNbExactWords() {
    return nbExactWords;
  }

  public HitRankingInfo setNbTypos(Integer nbTypos) {
    this.nbTypos = nbTypos;
    return this;
  }

  /** Number of typos encountered when matching the record. minimum: 0 */
  @javax.annotation.Nonnull
  public Integer getNbTypos() {
    return nbTypos;
  }

  public HitRankingInfo setPromoted(Boolean promoted) {
    this.promoted = promoted;
    return this;
  }

  /** Whether the record was promoted by a rule. */
  @javax.annotation.Nullable
  public Boolean getPromoted() {
    return promoted;
  }

  public HitRankingInfo setProximityDistance(Integer proximityDistance) {
    this.proximityDistance = proximityDistance;
    return this;
  }

  /**
   * Number of words between multiple matches in the query plus 1. For single word queries,
   * `proximityDistance` is 0. minimum: 0
   */
  @javax.annotation.Nullable
  public Integer getProximityDistance() {
    return proximityDistance;
  }

  public HitRankingInfo setUserScore(Integer userScore) {
    this.userScore = userScore;
    return this;
  }

  /** Overall ranking of the record, expressed as a single integer. This attribute is internal. */
  @javax.annotation.Nonnull
  public Integer getUserScore() {
    return userScore;
  }

  public HitRankingInfo setWords(Integer words) {
    this.words = words;
    return this;
  }

  /** Number of matched words. minimum: 1 */
  @javax.annotation.Nullable
  public Integer getWords() {
    return words;
  }

  public HitRankingInfo setPromotedByReRanking(Boolean promotedByReRanking) {
    this.promotedByReRanking = promotedByReRanking;
    return this;
  }

  /** Whether the record is re-ranked. */
  @javax.annotation.Nullable
  public Boolean getPromotedByReRanking() {
    return promotedByReRanking;
  }

  public HitRankingInfo setComposed(Map<String, CompositionIdRankingInfo> composed) {
    this.composed = composed;
    return this;
  }

  public HitRankingInfo putComposed(String key, CompositionIdRankingInfo composedItem) {
    if (this.composed == null) {
      this.composed = new HashMap<>();
    }
    this.composed.put(key, composedItem);
    return this;
  }

  /** Get composed */
  @javax.annotation.Nullable
  public Map<String, CompositionIdRankingInfo> getComposed() {
    return composed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HitRankingInfo hitRankingInfo = (HitRankingInfo) o;
    return (
      Objects.equals(this.filters, hitRankingInfo.filters) &&
      Objects.equals(this.firstMatchedWord, hitRankingInfo.firstMatchedWord) &&
      Objects.equals(this.geoDistance, hitRankingInfo.geoDistance) &&
      Objects.equals(this.geoPrecision, hitRankingInfo.geoPrecision) &&
      Objects.equals(this.matchedGeoLocation, hitRankingInfo.matchedGeoLocation) &&
      Objects.equals(this.personalization, hitRankingInfo.personalization) &&
      Objects.equals(this.nbExactWords, hitRankingInfo.nbExactWords) &&
      Objects.equals(this.nbTypos, hitRankingInfo.nbTypos) &&
      Objects.equals(this.promoted, hitRankingInfo.promoted) &&
      Objects.equals(this.proximityDistance, hitRankingInfo.proximityDistance) &&
      Objects.equals(this.userScore, hitRankingInfo.userScore) &&
      Objects.equals(this.words, hitRankingInfo.words) &&
      Objects.equals(this.promotedByReRanking, hitRankingInfo.promotedByReRanking) &&
      Objects.equals(this.composed, hitRankingInfo.composed)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      filters,
      firstMatchedWord,
      geoDistance,
      geoPrecision,
      matchedGeoLocation,
      personalization,
      nbExactWords,
      nbTypos,
      promoted,
      proximityDistance,
      userScore,
      words,
      promotedByReRanking,
      composed
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HitRankingInfo {\n");
    sb.append("    filters: ").append(toIndentedString(filters)).append("\n");
    sb.append("    firstMatchedWord: ").append(toIndentedString(firstMatchedWord)).append("\n");
    sb.append("    geoDistance: ").append(toIndentedString(geoDistance)).append("\n");
    sb.append("    geoPrecision: ").append(toIndentedString(geoPrecision)).append("\n");
    sb.append("    matchedGeoLocation: ").append(toIndentedString(matchedGeoLocation)).append("\n");
    sb.append("    personalization: ").append(toIndentedString(personalization)).append("\n");
    sb.append("    nbExactWords: ").append(toIndentedString(nbExactWords)).append("\n");
    sb.append("    nbTypos: ").append(toIndentedString(nbTypos)).append("\n");
    sb.append("    promoted: ").append(toIndentedString(promoted)).append("\n");
    sb.append("    proximityDistance: ").append(toIndentedString(proximityDistance)).append("\n");
    sb.append("    userScore: ").append(toIndentedString(userScore)).append("\n");
    sb.append("    words: ").append(toIndentedString(words)).append("\n");
    sb.append("    promotedByReRanking: ").append(toIndentedString(promotedByReRanking)).append("\n");
    sb.append("    composed: ").append(toIndentedString(composed)).append("\n");
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
