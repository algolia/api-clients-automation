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

namespace Algolia.Search.Models.Abtesting
{
  /// <summary>
  /// AbTestsVariant
  /// </summary>
  [DataContract(Name = "abTestsVariant")]
  public partial class AbTestsVariant
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="AbTestsVariant" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public AbTestsVariant() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="AbTestsVariant" /> class.
    /// </summary>
    /// <param name="index">A/B test index. (required).</param>
    /// <param name="trafficPercentage">A/B test traffic percentage. (required).</param>
    public AbTestsVariant(string index, int? trafficPercentage)
    {
      this.Index = index ?? throw new ArgumentNullException("index is a required property for AbTestsVariant and cannot be null");
      this.TrafficPercentage = trafficPercentage;
    }

    /// <summary>
    /// A/B test index.
    /// </summary>
    /// <value>A/B test index.</value>
    [DataMember(Name = "index", IsRequired = true, EmitDefaultValue = false)]
    public string Index { get; set; }

    /// <summary>
    /// A/B test traffic percentage.
    /// </summary>
    /// <value>A/B test traffic percentage.</value>
    [DataMember(Name = "trafficPercentage", IsRequired = true, EmitDefaultValue = false)]
    public int? TrafficPercentage { get; set; }

    /// <summary>
    /// A/B test description.
    /// </summary>
    /// <value>A/B test description.</value>
    [DataMember(Name = "description", EmitDefaultValue = false)]
    public string Description { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class AbTestsVariant {\n");
      sb.Append("  Index: ").Append(Index).Append("\n");
      sb.Append("  TrafficPercentage: ").Append(TrafficPercentage).Append("\n");
      sb.Append("  Description: ").Append(Description).Append("\n");
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
