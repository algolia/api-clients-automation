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
using System.ComponentModel.DataAnnotations;
using FileParameter = Algolia.Search.Search.Client.FileParameter;
using OpenAPIDateConverter = Algolia.Search.Search.Client.OpenAPIDateConverter;

namespace Algolia.Search.Search.Models
{
  /// <summary>
  /// SearchHits
  /// </summary>
  [DataContract(Name = "searchHits")]
  public partial class SearchHits : Dictionary<String, Object>, IEquatable<SearchHits>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="SearchHits" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected SearchHits()
    {
      this.AdditionalProperties = new Dictionary<string, object>();
    }
    /// <summary>
    /// Initializes a new instance of the <see cref="SearchHits" /> class.
    /// </summary>
    /// <param name="hits">hits (required).</param>
    /// <param name="query">Text to search for in an index. (required) (default to &quot;&quot;).</param>
    /// <param name="varParams">URL-encoded string of all search parameters. (required).</param>
    public SearchHits(List<Hit> hits = default(List<Hit>), string query = @"", string varParams = default(string)) : base()
    {
      // to ensure "hits" is required (not null)
      if (hits == null)
      {
        throw new ArgumentNullException("hits is a required property for SearchHits and cannot be null");
      }
      this.Hits = hits;
      // to ensure "query" is required (not null)
      if (query == null)
      {
        throw new ArgumentNullException("query is a required property for SearchHits and cannot be null");
      }
      this.Query = query;
      // to ensure "varParams" is required (not null)
      if (varParams == null)
      {
        throw new ArgumentNullException("varParams is a required property for SearchHits and cannot be null");
      }
      this.VarParams = varParams;
      this.AdditionalProperties = new Dictionary<string, object>();
    }

    /// <summary>
    /// Gets or Sets Hits
    /// </summary>
    [DataMember(Name = "hits", IsRequired = true, EmitDefaultValue = true)]
    public List<Hit> Hits { get; set; }

    /// <summary>
    /// Text to search for in an index.
    /// </summary>
    /// <value>Text to search for in an index.</value>
    [DataMember(Name = "query", IsRequired = true, EmitDefaultValue = true)]
    public string Query { get; set; }

    /// <summary>
    /// URL-encoded string of all search parameters.
    /// </summary>
    /// <value>URL-encoded string of all search parameters.</value>
    [DataMember(Name = "params", IsRequired = true, EmitDefaultValue = true)]
    public string VarParams { get; set; }

    /// <summary>
    /// Gets or Sets additional properties
    /// </summary>
    [JsonExtensionData]
    public IDictionary<string, object> AdditionalProperties { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class SearchHits {\n");
      sb.Append("  ").Append(base.ToString().Replace("\n", "\n  ")).Append("\n");
      sb.Append("  Hits: ").Append(Hits).Append("\n");
      sb.Append("  Query: ").Append(Query).Append("\n");
      sb.Append("  VarParams: ").Append(VarParams).Append("\n");
      sb.Append("  AdditionalProperties: ").Append(AdditionalProperties).Append("\n");
      sb.Append("}\n");
      return sb.ToString();
    }

    /// <summary>
    /// Returns the JSON string presentation of the object
    /// </summary>
    /// <returns>JSON string presentation of the object</returns>
    public string ToJson()
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
      return this.Equals(input as SearchHits);
    }

    /// <summary>
    /// Returns true if SearchHits instances are equal
    /// </summary>
    /// <param name="input">Instance of SearchHits to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(SearchHits input)
    {
      if (input == null)
      {
        return false;
      }
      return base.Equals(input) &&
          (
              this.Hits == input.Hits ||
              this.Hits != null &&
              input.Hits != null &&
              this.Hits.SequenceEqual(input.Hits)
          ) && base.Equals(input) &&
          (
              this.Query == input.Query ||
              (this.Query != null &&
              this.Query.Equals(input.Query))
          ) && base.Equals(input) &&
          (
              this.VarParams == input.VarParams ||
              (this.VarParams != null &&
              this.VarParams.Equals(input.VarParams))
          )
          && (this.AdditionalProperties.Count == input.AdditionalProperties.Count && !this.AdditionalProperties.Except(input.AdditionalProperties).Any());
    }

    /// <summary>
    /// Gets the hash code
    /// </summary>
    /// <returns>Hash code</returns>
    public override int GetHashCode()
    {
      unchecked // Overflow is fine, just wrap
      {
        int hashCode = base.GetHashCode();
        if (this.Hits != null)
        {
          hashCode = (hashCode * 59) + this.Hits.GetHashCode();
        }
        if (this.Query != null)
        {
          hashCode = (hashCode * 59) + this.Query.GetHashCode();
        }
        if (this.VarParams != null)
        {
          hashCode = (hashCode * 59) + this.VarParams.GetHashCode();
        }
        if (this.AdditionalProperties != null)
        {
          hashCode = (hashCode * 59) + this.AdditionalProperties.GetHashCode();
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
      return this.BaseValidate(validationContext);
    }

    /// <summary>
    /// To validate all properties of the instance
    /// </summary>
    /// <param name="validationContext">Validation context</param>
    /// <returns>Validation Result</returns>
    protected IEnumerable<System.ComponentModel.DataAnnotations.ValidationResult> BaseValidate(ValidationContext validationContext)
    {
      yield break;
    }
  }

}
