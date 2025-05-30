//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Text.Json.Serialization;
using Algolia.Search.Serializer;

namespace Algolia.Search.Models.Analytics;

/// <summary>
/// DailyNoResultsRates
/// </summary>
public partial class DailyNoResultsRates
{
  /// <summary>
  /// Initializes a new instance of the DailyNoResultsRates class.
  /// </summary>
  [JsonConstructor]
  public DailyNoResultsRates() { }

  /// <summary>
  /// Initializes a new instance of the DailyNoResultsRates class.
  /// </summary>
  /// <param name="date">Date in the format YYYY-MM-DD. (required).</param>
  /// <param name="noResultCount">Number of searches without any results. (required).</param>
  /// <param name="count">Number of searches. (required).</param>
  /// <param name="rate">No results rate: calculated as the number of searches with zero results divided by the total number of searches.  (required).</param>
  public DailyNoResultsRates(string date, int noResultCount, int count, double rate)
  {
    Date = date ?? throw new ArgumentNullException(nameof(date));
    NoResultCount = noResultCount;
    Count = count;
    Rate = rate;
  }

  /// <summary>
  /// Date in the format YYYY-MM-DD.
  /// </summary>
  /// <value>Date in the format YYYY-MM-DD.</value>
  [JsonPropertyName("date")]
  public string Date { get; set; }

  /// <summary>
  /// Number of searches without any results.
  /// </summary>
  /// <value>Number of searches without any results.</value>
  [JsonPropertyName("noResultCount")]
  public int NoResultCount { get; set; }

  /// <summary>
  /// Number of searches.
  /// </summary>
  /// <value>Number of searches.</value>
  [JsonPropertyName("count")]
  public int Count { get; set; }

  /// <summary>
  /// No results rate: calculated as the number of searches with zero results divided by the total number of searches.
  /// </summary>
  /// <value>No results rate: calculated as the number of searches with zero results divided by the total number of searches. </value>
  [JsonPropertyName("rate")]
  public double Rate { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class DailyNoResultsRates {\n");
    sb.Append("  Date: ").Append(Date).Append("\n");
    sb.Append("  NoResultCount: ").Append(NoResultCount).Append("\n");
    sb.Append("  Count: ").Append(Count).Append("\n");
    sb.Append("  Rate: ").Append(Rate).Append("\n");
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
    if (obj is not DailyNoResultsRates input)
    {
      return false;
    }

    return (Date == input.Date || (Date != null && Date.Equals(input.Date)))
      && (NoResultCount == input.NoResultCount || NoResultCount.Equals(input.NoResultCount))
      && (Count == input.Count || Count.Equals(input.Count))
      && (Rate == input.Rate || Rate.Equals(input.Rate));
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
      if (Date != null)
      {
        hashCode = (hashCode * 59) + Date.GetHashCode();
      }
      hashCode = (hashCode * 59) + NoResultCount.GetHashCode();
      hashCode = (hashCode * 59) + Count.GetHashCode();
      hashCode = (hashCode * 59) + Rate.GetHashCode();
      return hashCode;
    }
  }
}
