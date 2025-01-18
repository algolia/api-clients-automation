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

namespace Algolia.Search.Models.Analytics;

/// <summary>
/// GetNoClickRateResponse
/// </summary>
public partial class GetNoClickRateResponse
{
  /// <summary>
  /// Initializes a new instance of the GetNoClickRateResponse class.
  /// </summary>
  [JsonConstructor]
  public GetNoClickRateResponse() { }
  /// <summary>
  /// Initializes a new instance of the GetNoClickRateResponse class.
  /// </summary>
  /// <param name="rate">No click rate: calculated as the number of tracked searches without clicks divided by the number of tracked searches.  (required).</param>
  /// <param name="count">Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true. (required) (default to 0).</param>
  /// <param name="noClickCount">Number of times this search was returned as a result without any click. (required).</param>
  /// <param name="dates">Daily no click rates. (required).</param>
  public GetNoClickRateResponse(double rate, int count, int noClickCount, List<DailyNoClickRates> dates)
  {
    Rate = rate;
    Count = count;
    NoClickCount = noClickCount;
    Dates = dates ?? throw new ArgumentNullException(nameof(dates));
  }

  /// <summary>
  /// No click rate: calculated as the number of tracked searches without clicks divided by the number of tracked searches. 
  /// </summary>
  /// <value>No click rate: calculated as the number of tracked searches without clicks divided by the number of tracked searches. </value>
  [JsonPropertyName("rate")]
  public double Rate { get; set; }

  /// <summary>
  /// Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true.
  /// </summary>
  /// <value>Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true.</value>
  [JsonPropertyName("count")]
  public int Count { get; set; }

  /// <summary>
  /// Number of times this search was returned as a result without any click.
  /// </summary>
  /// <value>Number of times this search was returned as a result without any click.</value>
  [JsonPropertyName("noClickCount")]
  public int NoClickCount { get; set; }

  /// <summary>
  /// Daily no click rates.
  /// </summary>
  /// <value>Daily no click rates.</value>
  [JsonPropertyName("dates")]
  public List<DailyNoClickRates> Dates { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class GetNoClickRateResponse {\n");
    sb.Append("  Rate: ").Append(Rate).Append("\n");
    sb.Append("  Count: ").Append(Count).Append("\n");
    sb.Append("  NoClickCount: ").Append(NoClickCount).Append("\n");
    sb.Append("  Dates: ").Append(Dates).Append("\n");
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
    if (obj is not GetNoClickRateResponse input)
    {
      return false;
    }

    return
        (Rate == input.Rate || Rate.Equals(input.Rate)) &&
        (Count == input.Count || Count.Equals(input.Count)) &&
        (NoClickCount == input.NoClickCount || NoClickCount.Equals(input.NoClickCount)) &&
        (Dates == input.Dates || Dates != null && input.Dates != null && Dates.SequenceEqual(input.Dates));
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
      hashCode = (hashCode * 59) + Rate.GetHashCode();
      hashCode = (hashCode * 59) + Count.GetHashCode();
      hashCode = (hashCode * 59) + NoClickCount.GetHashCode();
      if (Dates != null)
      {
        hashCode = (hashCode * 59) + Dates.GetHashCode();
      }
      return hashCode;
    }
  }

}

