//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Text;
using System.Linq;
using System.Text.Json.Serialization;
using System.Collections.Generic;
using Algolia.Search.Serializer;
using System.Text.Json;

namespace Algolia.Search.Models.Search;

/// <summary>
/// Object with detailed information about the record's ranking.
/// </summary>
public partial class RankingInfo
{
  /// <summary>
  /// Initializes a new instance of the RankingInfo class.
  /// </summary>
  [JsonConstructor]
  public RankingInfo() { }
  /// <summary>
  /// Initializes a new instance of the RankingInfo class.
  /// </summary>
  /// <param name="filters">Whether a filter matched the query. (required).</param>
  /// <param name="firstMatchedWord">Position of the first matched word in the best matching attribute of the record. (required).</param>
  /// <param name="geoDistance">Distance between the geo location in the search query and the best matching geo location in the record, divided by the geo precision (in meters). (required).</param>
  /// <param name="nbExactWords">Number of exactly matched words. (required).</param>
  /// <param name="nbTypos">Number of typos encountered when matching the record. (required).</param>
  /// <param name="promoted">Whether the record was promoted by a rule. (required).</param>
  /// <param name="userScore">Overall ranking of the record, expressed as a single integer. This attribute is internal. (required).</param>
  /// <param name="words">Number of matched words. (required).</param>
  public RankingInfo(int filters, int firstMatchedWord, int geoDistance, int nbExactWords, int nbTypos, bool promoted, int userScore, int words)
  {
    Filters = filters;
    FirstMatchedWord = firstMatchedWord;
    GeoDistance = geoDistance;
    NbExactWords = nbExactWords;
    NbTypos = nbTypos;
    Promoted = promoted;
    UserScore = userScore;
    Words = words;
  }

  /// <summary>
  /// Whether a filter matched the query.
  /// </summary>
  /// <value>Whether a filter matched the query.</value>
  [JsonPropertyName("filters")]
  public int Filters { get; set; }

  /// <summary>
  /// Position of the first matched word in the best matching attribute of the record.
  /// </summary>
  /// <value>Position of the first matched word in the best matching attribute of the record.</value>
  [JsonPropertyName("firstMatchedWord")]
  public int FirstMatchedWord { get; set; }

  /// <summary>
  /// Distance between the geo location in the search query and the best matching geo location in the record, divided by the geo precision (in meters).
  /// </summary>
  /// <value>Distance between the geo location in the search query and the best matching geo location in the record, divided by the geo precision (in meters).</value>
  [JsonPropertyName("geoDistance")]
  public int GeoDistance { get; set; }

  /// <summary>
  /// Precision used when computing the geo distance, in meters.
  /// </summary>
  /// <value>Precision used when computing the geo distance, in meters.</value>
  [JsonPropertyName("geoPrecision")]
  public int? GeoPrecision { get; set; }

  /// <summary>
  /// Gets or Sets MatchedGeoLocation
  /// </summary>
  [JsonPropertyName("matchedGeoLocation")]
  public MatchedGeoLocation MatchedGeoLocation { get; set; }

  /// <summary>
  /// Gets or Sets Personalization
  /// </summary>
  [JsonPropertyName("personalization")]
  public Personalization Personalization { get; set; }

  /// <summary>
  /// Number of exactly matched words.
  /// </summary>
  /// <value>Number of exactly matched words.</value>
  [JsonPropertyName("nbExactWords")]
  public int NbExactWords { get; set; }

  /// <summary>
  /// Number of typos encountered when matching the record.
  /// </summary>
  /// <value>Number of typos encountered when matching the record.</value>
  [JsonPropertyName("nbTypos")]
  public int NbTypos { get; set; }

  /// <summary>
  /// Whether the record was promoted by a rule.
  /// </summary>
  /// <value>Whether the record was promoted by a rule.</value>
  [JsonPropertyName("promoted")]
  public bool Promoted { get; set; }

  /// <summary>
  /// Number of words between multiple matches in the query plus 1. For single word queries, `proximityDistance` is 0.
  /// </summary>
  /// <value>Number of words between multiple matches in the query plus 1. For single word queries, `proximityDistance` is 0.</value>
  [JsonPropertyName("proximityDistance")]
  public int? ProximityDistance { get; set; }

  /// <summary>
  /// Overall ranking of the record, expressed as a single integer. This attribute is internal.
  /// </summary>
  /// <value>Overall ranking of the record, expressed as a single integer. This attribute is internal.</value>
  [JsonPropertyName("userScore")]
  public int UserScore { get; set; }

  /// <summary>
  /// Number of matched words.
  /// </summary>
  /// <value>Number of matched words.</value>
  [JsonPropertyName("words")]
  public int Words { get; set; }

  /// <summary>
  /// Whether the record is re-ranked.
  /// </summary>
  /// <value>Whether the record is re-ranked.</value>
  [JsonPropertyName("promotedByReRanking")]
  public bool? PromotedByReRanking { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class RankingInfo {\n");
    sb.Append("  Filters: ").Append(Filters).Append("\n");
    sb.Append("  FirstMatchedWord: ").Append(FirstMatchedWord).Append("\n");
    sb.Append("  GeoDistance: ").Append(GeoDistance).Append("\n");
    sb.Append("  GeoPrecision: ").Append(GeoPrecision).Append("\n");
    sb.Append("  MatchedGeoLocation: ").Append(MatchedGeoLocation).Append("\n");
    sb.Append("  Personalization: ").Append(Personalization).Append("\n");
    sb.Append("  NbExactWords: ").Append(NbExactWords).Append("\n");
    sb.Append("  NbTypos: ").Append(NbTypos).Append("\n");
    sb.Append("  Promoted: ").Append(Promoted).Append("\n");
    sb.Append("  ProximityDistance: ").Append(ProximityDistance).Append("\n");
    sb.Append("  UserScore: ").Append(UserScore).Append("\n");
    sb.Append("  Words: ").Append(Words).Append("\n");
    sb.Append("  PromotedByReRanking: ").Append(PromotedByReRanking).Append("\n");
    sb.Append("}\n");
    return sb.ToString();
  }

  /// <summary>
  /// Returns the JSON string presentation of the object
  /// </summary>
  /// <returns>JSON string presentation of the object</returns>
  public virtual string ToJson()
  {
    return JsonSerializer.Serialize(this, JsonConfig.Options);
  }

  /// <summary>
  /// Returns true if objects are equal
  /// </summary>
  /// <param name="obj">Object to be compared</param>
  /// <returns>Boolean</returns>
  public override bool Equals(object obj)
  {
    if (obj is not RankingInfo input)
    {
      return false;
    }

    return
        (Filters == input.Filters || Filters.Equals(input.Filters)) &&
        (FirstMatchedWord == input.FirstMatchedWord || FirstMatchedWord.Equals(input.FirstMatchedWord)) &&
        (GeoDistance == input.GeoDistance || GeoDistance.Equals(input.GeoDistance)) &&
        (GeoPrecision == input.GeoPrecision || GeoPrecision.Equals(input.GeoPrecision)) &&
        (MatchedGeoLocation == input.MatchedGeoLocation || (MatchedGeoLocation != null && MatchedGeoLocation.Equals(input.MatchedGeoLocation))) &&
        (Personalization == input.Personalization || (Personalization != null && Personalization.Equals(input.Personalization))) &&
        (NbExactWords == input.NbExactWords || NbExactWords.Equals(input.NbExactWords)) &&
        (NbTypos == input.NbTypos || NbTypos.Equals(input.NbTypos)) &&
        (Promoted == input.Promoted || Promoted.Equals(input.Promoted)) &&
        (ProximityDistance == input.ProximityDistance || ProximityDistance.Equals(input.ProximityDistance)) &&
        (UserScore == input.UserScore || UserScore.Equals(input.UserScore)) &&
        (Words == input.Words || Words.Equals(input.Words)) &&
        (PromotedByReRanking == input.PromotedByReRanking || PromotedByReRanking.Equals(input.PromotedByReRanking));
  }

  /// <summary>
  /// Gets the hash code
  /// </summary>
  /// <returns>Hash code</returns>
  public override int GetHashCode()
  {
    unchecked // Overflow is fine, just wrap
    {
      int hashCode = 41;
      hashCode = (hashCode * 59) + Filters.GetHashCode();
      hashCode = (hashCode * 59) + FirstMatchedWord.GetHashCode();
      hashCode = (hashCode * 59) + GeoDistance.GetHashCode();
      hashCode = (hashCode * 59) + GeoPrecision.GetHashCode();
      if (MatchedGeoLocation != null)
      {
        hashCode = (hashCode * 59) + MatchedGeoLocation.GetHashCode();
      }
      if (Personalization != null)
      {
        hashCode = (hashCode * 59) + Personalization.GetHashCode();
      }
      hashCode = (hashCode * 59) + NbExactWords.GetHashCode();
      hashCode = (hashCode * 59) + NbTypos.GetHashCode();
      hashCode = (hashCode * 59) + Promoted.GetHashCode();
      hashCode = (hashCode * 59) + ProximityDistance.GetHashCode();
      hashCode = (hashCode * 59) + UserScore.GetHashCode();
      hashCode = (hashCode * 59) + Words.GetHashCode();
      hashCode = (hashCode * 59) + PromotedByReRanking.GetHashCode();
      return hashCode;
    }
  }

}

