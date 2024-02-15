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
/// TopSearchWithAnalytics
/// </summary>
[DataContract(Name = "topSearchWithAnalytics")]
public partial class TopSearchWithAnalytics
{
  /// <summary>
  /// Initializes a new instance of the TopSearchWithAnalytics class.
  /// </summary>
  [JsonConstructor]
  public TopSearchWithAnalytics() { }
  /// <summary>
  /// Initializes a new instance of the TopSearchWithAnalytics class.
  /// </summary>
  /// <param name="search">User query. (required).</param>
  /// <param name="count">Number of tracked _and_ untracked searches (where the &#x60;clickAnalytics&#x60; parameter isn&#39;t &#x60;true&#x60;). (required).</param>
  /// <param name="clickThroughRate">[Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate).  (required).</param>
  /// <param name="averageClickPosition">Average [position](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-position) of clicked search result. (required).</param>
  /// <param name="conversionRate">[Conversion rate (CR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#conversion-rate).  (required).</param>
  /// <param name="trackedSearchCount">Number of tracked searches. This is the number of search requests where the &#x60;clickAnalytics&#x60; parameter is &#x60;true&#x60;. (required).</param>
  /// <param name="clickCount">Number of click events. (required).</param>
  /// <param name="conversionCount">Number of converted clicks. (required).</param>
  /// <param name="nbHits">Number of hits the search query matched. (required).</param>
  public TopSearchWithAnalytics(string search, int count, double clickThroughRate, int averageClickPosition, double conversionRate, int? trackedSearchCount, int clickCount, int conversionCount, int nbHits)
  {
    Search = search ?? throw new ArgumentNullException(nameof(search));
    Count = count;
    ClickThroughRate = clickThroughRate;
    AverageClickPosition = averageClickPosition;
    ConversionRate = conversionRate;
    TrackedSearchCount = trackedSearchCount ?? throw new ArgumentNullException(nameof(trackedSearchCount));
    ClickCount = clickCount;
    ConversionCount = conversionCount;
    NbHits = nbHits;
  }

  /// <summary>
  /// User query.
  /// </summary>
  /// <value>User query.</value>
  [DataMember(Name = "search")]
  public string Search { get; set; }

  /// <summary>
  /// Number of tracked _and_ untracked searches (where the `clickAnalytics` parameter isn't `true`).
  /// </summary>
  /// <value>Number of tracked _and_ untracked searches (where the `clickAnalytics` parameter isn't `true`).</value>
  [DataMember(Name = "count")]
  public int Count { get; set; }

  /// <summary>
  /// [Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate). 
  /// </summary>
  /// <value>[Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate). </value>
  [DataMember(Name = "clickThroughRate")]
  public double ClickThroughRate { get; set; }

  /// <summary>
  /// Average [position](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-position) of clicked search result.
  /// </summary>
  /// <value>Average [position](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-position) of clicked search result.</value>
  [DataMember(Name = "averageClickPosition")]
  public int AverageClickPosition { get; set; }

  /// <summary>
  /// [Conversion rate (CR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#conversion-rate). 
  /// </summary>
  /// <value>[Conversion rate (CR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#conversion-rate). </value>
  [DataMember(Name = "conversionRate")]
  public double ConversionRate { get; set; }

  /// <summary>
  /// Number of tracked searches. This is the number of search requests where the `clickAnalytics` parameter is `true`.
  /// </summary>
  /// <value>Number of tracked searches. This is the number of search requests where the `clickAnalytics` parameter is `true`.</value>
  [DataMember(Name = "trackedSearchCount")]
  public int? TrackedSearchCount { get; set; }

  /// <summary>
  /// Number of click events.
  /// </summary>
  /// <value>Number of click events.</value>
  [DataMember(Name = "clickCount")]
  public int ClickCount { get; set; }

  /// <summary>
  /// Number of converted clicks.
  /// </summary>
  /// <value>Number of converted clicks.</value>
  [DataMember(Name = "conversionCount")]
  public int ConversionCount { get; set; }

  /// <summary>
  /// Number of hits the search query matched.
  /// </summary>
  /// <value>Number of hits the search query matched.</value>
  [DataMember(Name = "nbHits")]
  public int NbHits { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class TopSearchWithAnalytics {\n");
    sb.Append("  Search: ").Append(Search).Append("\n");
    sb.Append("  Count: ").Append(Count).Append("\n");
    sb.Append("  ClickThroughRate: ").Append(ClickThroughRate).Append("\n");
    sb.Append("  AverageClickPosition: ").Append(AverageClickPosition).Append("\n");
    sb.Append("  ConversionRate: ").Append(ConversionRate).Append("\n");
    sb.Append("  TrackedSearchCount: ").Append(TrackedSearchCount).Append("\n");
    sb.Append("  ClickCount: ").Append(ClickCount).Append("\n");
    sb.Append("  ConversionCount: ").Append(ConversionCount).Append("\n");
    sb.Append("  NbHits: ").Append(NbHits).Append("\n");
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

