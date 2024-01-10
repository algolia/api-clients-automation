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

namespace Algolia.Search.Models.Analytics
{
  /// <summary>
  /// TopHitWithAnalytics
  /// </summary>
  [DataContract(Name = "topHitWithAnalytics")]
  public partial class TopHitWithAnalytics
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="TopHitWithAnalytics" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public TopHitWithAnalytics() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="TopHitWithAnalytics" /> class.
    /// </summary>
    /// <param name="hit">Hit. (required).</param>
    /// <param name="count">Number of occurrences. (required).</param>
    /// <param name="clickThroughRate">[Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate).  (required).</param>
    /// <param name="conversionRate">[Conversion rate (CR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#conversion-rate).  (required).</param>
    /// <param name="trackedSearchCount">Number of tracked searches. This is the number of search requests where the &#x60;clickAnalytics&#x60; parameter is &#x60;true&#x60;. (required).</param>
    /// <param name="clickCount">Number of click events. (required).</param>
    /// <param name="conversionCount">Number of converted clicks. (required).</param>
    public TopHitWithAnalytics(string hit, int count, double clickThroughRate, double conversionRate, int trackedSearchCount, int clickCount, int conversionCount)
    {
      this.Hit = hit ?? throw new ArgumentNullException("hit is a required property for TopHitWithAnalytics and cannot be null");
      this.Count = count;
      this.ClickThroughRate = clickThroughRate;
      this.ConversionRate = conversionRate;
      this.TrackedSearchCount = trackedSearchCount;
      this.ClickCount = clickCount;
      this.ConversionCount = conversionCount;
    }

    /// <summary>
    /// Hit.
    /// </summary>
    /// <value>Hit.</value>
    [DataMember(Name = "hit", IsRequired = true, EmitDefaultValue = true)]
    public string Hit { get; set; }

    /// <summary>
    /// Number of occurrences.
    /// </summary>
    /// <value>Number of occurrences.</value>
    [DataMember(Name = "count", IsRequired = true, EmitDefaultValue = true)]
    public int Count { get; set; }

    /// <summary>
    /// [Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate). 
    /// </summary>
    /// <value>[Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate). </value>
    [DataMember(Name = "clickThroughRate", IsRequired = true, EmitDefaultValue = true)]
    public double ClickThroughRate { get; set; }

    /// <summary>
    /// [Conversion rate (CR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#conversion-rate). 
    /// </summary>
    /// <value>[Conversion rate (CR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#conversion-rate). </value>
    [DataMember(Name = "conversionRate", IsRequired = true, EmitDefaultValue = true)]
    public double ConversionRate { get; set; }

    /// <summary>
    /// Number of tracked searches. This is the number of search requests where the &#x60;clickAnalytics&#x60; parameter is &#x60;true&#x60;.
    /// </summary>
    /// <value>Number of tracked searches. This is the number of search requests where the &#x60;clickAnalytics&#x60; parameter is &#x60;true&#x60;.</value>
    [DataMember(Name = "trackedSearchCount", IsRequired = true, EmitDefaultValue = true)]
    public int TrackedSearchCount { get; set; }

    /// <summary>
    /// Number of click events.
    /// </summary>
    /// <value>Number of click events.</value>
    [DataMember(Name = "clickCount", IsRequired = true, EmitDefaultValue = true)]
    public int ClickCount { get; set; }

    /// <summary>
    /// Number of converted clicks.
    /// </summary>
    /// <value>Number of converted clicks.</value>
    [DataMember(Name = "conversionCount", IsRequired = true, EmitDefaultValue = true)]
    public int ConversionCount { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class TopHitWithAnalytics {\n");
      sb.Append("  Hit: ").Append(Hit).Append("\n");
      sb.Append("  Count: ").Append(Count).Append("\n");
      sb.Append("  ClickThroughRate: ").Append(ClickThroughRate).Append("\n");
      sb.Append("  ConversionRate: ").Append(ConversionRate).Append("\n");
      sb.Append("  TrackedSearchCount: ").Append(TrackedSearchCount).Append("\n");
      sb.Append("  ClickCount: ").Append(ClickCount).Append("\n");
      sb.Append("  ConversionCount: ").Append(ConversionCount).Append("\n");
      sb.Append("}\n");
      return sb.ToString();
    }

    /// <summary>
    /// Returns the JSON string presentation of the object
    /// </summary>
    /// <returns>JSON string presentation of the object</returns>
    public virtual string ToJson()
    {
      return Newtonsoft.Json.JsonConvert.SerializeObject(this, Newtonsoft.Json.Formatting.Indented);
    }

  }

}
