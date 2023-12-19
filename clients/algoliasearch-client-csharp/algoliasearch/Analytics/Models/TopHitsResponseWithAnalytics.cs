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
  /// TopHitsResponseWithAnalytics
  /// </summary>
  [DataContract(Name = "topHitsResponseWithAnalytics")]
  public partial class TopHitsResponseWithAnalytics
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="TopHitsResponseWithAnalytics" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected TopHitsResponseWithAnalytics() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="TopHitsResponseWithAnalytics" /> class.
    /// </summary>
    /// <param name="hits">Top hits. (required).</param>
    public TopHitsResponseWithAnalytics(List<TopHitWithAnalytics> hits = default(List<TopHitWithAnalytics>))
    {
      // to ensure "hits" is required (not null)
      if (hits == null)
      {
        throw new ArgumentNullException("hits is a required property for TopHitsResponseWithAnalytics and cannot be null");
      }
      this.Hits = hits;
    }

    /// <summary>
    /// Top hits.
    /// </summary>
    /// <value>Top hits.</value>
    [DataMember(Name = "hits", IsRequired = true, EmitDefaultValue = true)]
    public List<TopHitWithAnalytics> Hits { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class TopHitsResponseWithAnalytics {\n");
      sb.Append("  Hits: ").Append(Hits).Append("\n");
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
