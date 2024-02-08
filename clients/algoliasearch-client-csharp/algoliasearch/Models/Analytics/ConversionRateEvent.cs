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
/// ConversionRateEvent
/// </summary>
[DataContract(Name = "conversionRateEvent")]
public partial class ConversionRateEvent
{
  /// <summary>
  /// Initializes a new instance of the ConversionRateEvent class.
  /// </summary>
  [JsonConstructor]
  public ConversionRateEvent() { }
  /// <summary>
  /// Initializes a new instance of the ConversionRateEvent class.
  /// </summary>
  /// <param name="rate">[Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate).  (required).</param>
  /// <param name="trackedSearchCount">Number of tracked searches. This is the number of search requests where the &#x60;clickAnalytics&#x60; parameter is &#x60;true&#x60;. (required).</param>
  /// <param name="conversionCount">Number of converted clicks. (required).</param>
  /// <param name="date">Date of the event in the format YYYY-MM-DD. (required).</param>
  public ConversionRateEvent(double rate, int trackedSearchCount, int conversionCount, string date)
  {
    Rate = rate;
    TrackedSearchCount = trackedSearchCount;
    ConversionCount = conversionCount;
    Date = date ?? throw new ArgumentNullException(nameof(date));
  }

  /// <summary>
  /// [Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate). 
  /// </summary>
  /// <value>[Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate). </value>
  [DataMember(Name = "rate")]
  public double Rate { get; set; }

  /// <summary>
  /// Number of tracked searches. This is the number of search requests where the `clickAnalytics` parameter is `true`.
  /// </summary>
  /// <value>Number of tracked searches. This is the number of search requests where the `clickAnalytics` parameter is `true`.</value>
  [DataMember(Name = "trackedSearchCount")]
  public int TrackedSearchCount { get; set; }

  /// <summary>
  /// Number of converted clicks.
  /// </summary>
  /// <value>Number of converted clicks.</value>
  [DataMember(Name = "conversionCount")]
  public int ConversionCount { get; set; }

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
    sb.Append("class ConversionRateEvent {\n");
    sb.Append("  Rate: ").Append(Rate).Append("\n");
    sb.Append("  TrackedSearchCount: ").Append(TrackedSearchCount).Append("\n");
    sb.Append("  ConversionCount: ").Append(ConversionCount).Append("\n");
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

