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

namespace Algolia.Search.Analytics.Models
{
  /// <summary>
  /// GetClickThroughRateResponse
  /// </summary>
  [DataContract(Name = "getClickThroughRateResponse")]
  public partial class GetClickThroughRateResponse
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="GetClickThroughRateResponse" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected GetClickThroughRateResponse() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="GetClickThroughRateResponse" /> class.
    /// </summary>
    /// <param name="rate">[Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate).  (required).</param>
    /// <param name="clickCount">Number of click events. (required).</param>
    /// <param name="trackedSearchCount">Number of tracked searches. This is the number of search requests where the &#x60;clickAnalytics&#x60; parameter is &#x60;true&#x60;. (required).</param>
    /// <param name="dates">Click-through rate events. (required).</param>
    public GetClickThroughRateResponse(double rate = default(double), int clickCount = default(int), int trackedSearchCount = default(int), List<ClickThroughRateEvent> dates = default(List<ClickThroughRateEvent>))
    {
      this.Rate = rate;
      this.ClickCount = clickCount;
      this.TrackedSearchCount = trackedSearchCount;
      // to ensure "dates" is required (not null)
      if (dates == null)
      {
        throw new ArgumentNullException("dates is a required property for GetClickThroughRateResponse and cannot be null");
      }
      this.Dates = dates;
    }

    /// <summary>
    /// [Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate). 
    /// </summary>
    /// <value>[Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate). </value>
    [DataMember(Name = "rate", IsRequired = true, EmitDefaultValue = true)]
    public double Rate { get; set; }

    /// <summary>
    /// Number of click events.
    /// </summary>
    /// <value>Number of click events.</value>
    [DataMember(Name = "clickCount", IsRequired = true, EmitDefaultValue = true)]
    public int ClickCount { get; set; }

    /// <summary>
    /// Number of tracked searches. This is the number of search requests where the &#x60;clickAnalytics&#x60; parameter is &#x60;true&#x60;.
    /// </summary>
    /// <value>Number of tracked searches. This is the number of search requests where the &#x60;clickAnalytics&#x60; parameter is &#x60;true&#x60;.</value>
    [DataMember(Name = "trackedSearchCount", IsRequired = true, EmitDefaultValue = true)]
    public int TrackedSearchCount { get; set; }

    /// <summary>
    /// Click-through rate events.
    /// </summary>
    /// <value>Click-through rate events.</value>
    [DataMember(Name = "dates", IsRequired = true, EmitDefaultValue = true)]
    public List<ClickThroughRateEvent> Dates { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class GetClickThroughRateResponse {\n");
      sb.Append("  Rate: ").Append(Rate).Append("\n");
      sb.Append("  ClickCount: ").Append(ClickCount).Append("\n");
      sb.Append("  TrackedSearchCount: ").Append(TrackedSearchCount).Append("\n");
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
      return Newtonsoft.Json.JsonConvert.SerializeObject(this, Newtonsoft.Json.Formatting.Indented);
    }

  }

}
