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
using FileParameter = Org.OpenAPITools.Client.FileParameter;
using OpenAPIDateConverter = Org.OpenAPITools.Client.OpenAPIDateConverter;

namespace Org.OpenAPITools.Model
{
  /// <summary>
  /// SearchResponses
  /// </summary>
  [DataContract(Name = "searchResponses")]
  public partial class SearchResponses : IEquatable<SearchResponses>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="SearchResponses" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected SearchResponses() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="SearchResponses" /> class.
    /// </summary>
    /// <param name="results">results (required).</param>
    public SearchResponses(List<SearchResult> results = default(List<SearchResult>))
    {
      // to ensure "results" is required (not null)
      if (results == null)
      {
        throw new ArgumentNullException("results is a required property for SearchResponses and cannot be null");
      }
      this.Results = results;
    }

    /// <summary>
    /// Gets or Sets Results
    /// </summary>
    [DataMember(Name = "results", IsRequired = true, EmitDefaultValue = true)]
    public List<SearchResult> Results { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class SearchResponses {\n");
      sb.Append("  Results: ").Append(Results).Append("\n");
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
      return this.Equals(input as SearchResponses);
    }

    /// <summary>
    /// Returns true if SearchResponses instances are equal
    /// </summary>
    /// <param name="input">Instance of SearchResponses to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(SearchResponses input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.Results == input.Results ||
              this.Results != null &&
              input.Results != null &&
              this.Results.SequenceEqual(input.Results)
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
        if (this.Results != null)
        {
          hashCode = (hashCode * 59) + this.Results.GetHashCode();
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
