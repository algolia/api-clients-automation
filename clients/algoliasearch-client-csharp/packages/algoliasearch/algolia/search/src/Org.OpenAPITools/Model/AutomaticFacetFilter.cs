/*
 * Search API
 *
 * Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */


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
using System.ComponentModel.DataAnnotations;
using OpenAPIDateConverter = Org.OpenAPITools.Client.OpenAPIDateConverter;

namespace Org.OpenAPITools.Model
{
  /// <summary>
  /// Automatic facet Filter.
  /// </summary>
  [DataContract(Name = "automaticFacetFilter")]
  public partial class AutomaticFacetFilter : IEquatable<AutomaticFacetFilter>, IValidatableObject
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

    /// <summary>
    /// Returns true if objects are equal
    /// </summary>
    /// <param name="input">Object to be compared</param>
    /// <returns>Boolean</returns>
    public override bool Equals(object input)
    {
      return this.Equals(input as AutomaticFacetFilter);
    }

    /// <summary>
    /// Returns true if AutomaticFacetFilter instances are equal
    /// </summary>
    /// <param name="input">Instance of AutomaticFacetFilter to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(AutomaticFacetFilter input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.Facet == input.Facet ||
              (this.Facet != null &&
              this.Facet.Equals(input.Facet))
          ) &&
          (
              this.Score == input.Score ||
              this.Score.Equals(input.Score)
          ) &&
          (
              this.Disjunctive == input.Disjunctive ||
              this.Disjunctive.Equals(input.Disjunctive)
          );
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
        if (this.Facet != null)
        {
          hashCode = (hashCode * 59) + this.Facet.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.Score.GetHashCode();
        hashCode = (hashCode * 59) + this.Disjunctive.GetHashCode();
        return hashCode;
      }
    }

    /// <summary>
    /// To validate all properties of the instance
    /// </summary>
    /// <param name="validationContext">Validation context</param>
    /// <returns>Validation Result</returns>
    IEnumerable<System.ComponentModel.DataAnnotations.ValidationResult> IValidatableObject.Validate(ValidationContext validationContext)
    {
      yield break;
    }
  }

}
