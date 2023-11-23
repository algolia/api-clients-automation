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
  /// Defines the ordering of facets (widgets).
  /// </summary>
  [DataContract(Name = "facetOrdering")]
  public partial class FacetOrdering : IEquatable<FacetOrdering>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="FacetOrdering" /> class.
    /// </summary>
    /// <param name="facets">facets.</param>
    /// <param name="values">Ordering of facet values within an individual facet..</param>
    public FacetOrdering(Facets facets = default(Facets), Dictionary<string, Value> values = default(Dictionary<string, Value>))
    {
      this.Facets = facets;
      this.Values = values;
    }

    /// <summary>
    /// Gets or Sets Facets
    /// </summary>
    [DataMember(Name = "facets", EmitDefaultValue = false)]
    public Facets Facets { get; set; }

    /// <summary>
    /// Ordering of facet values within an individual facet.
    /// </summary>
    /// <value>Ordering of facet values within an individual facet.</value>
    [DataMember(Name = "values", EmitDefaultValue = false)]
    public Dictionary<string, Value> Values { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class FacetOrdering {\n");
      sb.Append("  Facets: ").Append(Facets).Append("\n");
      sb.Append("  Values: ").Append(Values).Append("\n");
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
      return this.Equals(input as FacetOrdering);
    }

    /// <summary>
    /// Returns true if FacetOrdering instances are equal
    /// </summary>
    /// <param name="input">Instance of FacetOrdering to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(FacetOrdering input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.Facets == input.Facets ||
              (this.Facets != null &&
              this.Facets.Equals(input.Facets))
          ) &&
          (
              this.Values == input.Values ||
              this.Values != null &&
              input.Values != null &&
              this.Values.SequenceEqual(input.Values)
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
        if (this.Facets != null)
        {
          hashCode = (hashCode * 59) + this.Facets.GetHashCode();
        }
        if (this.Values != null)
        {
          hashCode = (hashCode * 59) + this.Values.GetHashCode();
        }
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
