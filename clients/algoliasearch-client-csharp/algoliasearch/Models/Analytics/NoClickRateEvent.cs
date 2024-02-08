//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.IO;
using System.Runtime.Serialization;
using System.Text;
using System.Text.RegularExpressions;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using Newtonsoft.Json.Linq;
using Algolia.Search.Models;
using Algolia.Search.Models.Common;
using Algolia.Search.Serializer;

namespace Algolia.Search.Models.Analytics;

/// <summary>
/// NoClickRateEvent
/// </summary>
[DataContract(Name = "noClickRateEvent")]
public partial class NoClickRateEvent
{
  /// <summary>
  /// Initializes a new instance of the NoClickRateEvent class.
  /// </summary>
  [JsonConstructor]
  public NoClickRateEvent() { }
  /// <summary>
  /// Initializes a new instance of the NoClickRateEvent class.
  /// </summary>
  /// <param name="rate">[Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate).  (required).</param>
  /// <param name="count">Number of tracked _and_ untracked searches (where the &#x60;clickAnalytics&#x60; parameter isn&#39;t &#x60;true&#x60;). (required).</param>
  /// <param name="noClickCount">Number of click events. (required).</param>
  /// <param name="date">Date of the event in the format YYYY-MM-DD. (required).</param>
  public NoClickRateEvent(double rate, int count, int noClickCount, string date)
  {
    Rate = rate;
    Count = count;
    NoClickCount = noClickCount;
    Date = date ?? throw new ArgumentNullException(nameof(date));
  }

  /// <summary>
  /// [Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate). 
  /// </summary>
  /// <value>[Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate). </value>
  [DataMember(Name = "rate")]
  public double Rate { get; set; }

  /// <summary>
  /// Number of tracked _and_ untracked searches (where the `clickAnalytics` parameter isn't `true`).
  /// </summary>
  /// <value>Number of tracked _and_ untracked searches (where the `clickAnalytics` parameter isn't `true`).</value>
  [DataMember(Name = "count")]
  public int Count { get; set; }

  /// <summary>
  /// Number of click events.
  /// </summary>
  /// <value>Number of click events.</value>
  [DataMember(Name = "noClickCount")]
  public int NoClickCount { get; set; }

  /// <summary>
  /// Date of the event in the format YYYY-MM-DD.
  /// </summary>
  /// <value>Date of the event in the format YYYY-MM-DD.</value>
  [DataMember(Name = "date")]
  public string Date { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class NoClickRateEvent {\n");
    sb.Append("  Rate: ").Append(Rate).Append("\n");
    sb.Append("  Count: ").Append(Count).Append("\n");
    sb.Append("  NoClickCount: ").Append(NoClickCount).Append("\n");
    sb.Append("  Date: ").Append(Date).Append("\n");
    sb.Append("}\n");
    return sb.ToString();
  }

  /// <summary>
  /// Returns the JSON string presentation of the object
  /// </summary>
  /// <returns>JSON string presentation of the object</returns>
  public virtual string ToJson()
  {
    return JsonConvert.SerializeObject(this, Formatting.Indented);
  }

}

