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

namespace Algolia.Search.Recommend.Models
{
  /// <summary>
  /// Automatic facet Filter.
  /// </summary>
  [DataContract(Name = "automaticFacetFilter")]
  public partial class AutomaticFacetFilter
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="AutomaticFacetFilter" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected AutomaticFacetFilter() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="AutomaticFacetFilter" /> class.
    /// </summary>
    /// <param name="facet">Attribute to filter on. This must match a facet placeholder in the Rule&#39;s pattern. (required).</param>
    /// <param name="score">Score for the filter. Typically used for optional or disjunctive filters. (default to 1).</param>
    /// <param name="disjunctive">Whether the filter is disjunctive (true) or conjunctive (false). (default to false).</param>
    public AutomaticFacetFilter(string facet = default(string), int score = 1, bool disjunctive = false)
    {
      // to ensure "facet" is required (not null)
      if (facet == null)
      {
        throw new ArgumentNullException("facet is a required property for AutomaticFacetFilter and cannot be null");
      }
      this.Facet = facet;
      this.Score = score;
      this.Disjunctive = disjunctive;
    }

    /// <summary>
    /// Attribute to filter on. This must match a facet placeholder in the Rule&#39;s pattern.
    /// </summary>
    /// <value>Attribute to filter on. This must match a facet placeholder in the Rule&#39;s pattern.</value>
    [DataMember(Name = "facet", IsRequired = true, EmitDefaultValue = true)]
    public string Facet { get; set; }

    /// <summary>
    /// Score for the filter. Typically used for optional or disjunctive filters.
    /// </summary>
    /// <value>Score for the filter. Typically used for optional or disjunctive filters.</value>
    [DataMember(Name = "score", EmitDefaultValue = false)]
    public int Score { get; set; }

    /// <summary>
    /// Whether the filter is disjunctive (true) or conjunctive (false).
    /// </summary>
    /// <value>Whether the filter is disjunctive (true) or conjunctive (false).</value>
    [DataMember(Name = "disjunctive", EmitDefaultValue = true)]
    public bool Disjunctive { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class AutomaticFacetFilter {\n");
      sb.Append("  Facet: ").Append(Facet).Append("\n");
      sb.Append("  Score: ").Append(Score).Append("\n");
      sb.Append("  Disjunctive: ").Append(Disjunctive).Append("\n");
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
