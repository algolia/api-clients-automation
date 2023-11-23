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
  /// SearchRulesResponse
  /// </summary>
  [DataContract(Name = "searchRulesResponse")]
  public partial class SearchRulesResponse : IEquatable<SearchRulesResponse>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="SearchRulesResponse" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected SearchRulesResponse() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="SearchRulesResponse" /> class.
    /// </summary>
    /// <param name="hits">Fetched rules. (required).</param>
    /// <param name="nbHits">Number of fetched rules. (required).</param>
    /// <param name="page">Current page. (required).</param>
    /// <param name="nbPages">Number of pages. (required).</param>
    public SearchRulesResponse(List<Rule> hits = default(List<Rule>), int nbHits = default(int), int page = default(int), int nbPages = default(int))
    {
      // to ensure "hits" is required (not null)
      if (hits == null)
      {
        throw new ArgumentNullException("hits is a required property for SearchRulesResponse and cannot be null");
      }
      this.Hits = hits;
      this.NbHits = nbHits;
      this.Page = page;
      this.NbPages = nbPages;
    }

    /// <summary>
    /// Fetched rules.
    /// </summary>
    /// <value>Fetched rules.</value>
    [DataMember(Name = "hits", IsRequired = true, EmitDefaultValue = true)]
    public List<Rule> Hits { get; set; }

    /// <summary>
    /// Number of fetched rules.
    /// </summary>
    /// <value>Number of fetched rules.</value>
    [DataMember(Name = "nbHits", IsRequired = true, EmitDefaultValue = true)]
    public int NbHits { get; set; }

    /// <summary>
    /// Current page.
    /// </summary>
    /// <value>Current page.</value>
    [DataMember(Name = "page", IsRequired = true, EmitDefaultValue = true)]
    public int Page { get; set; }

    /// <summary>
    /// Number of pages.
    /// </summary>
    /// <value>Number of pages.</value>
    [DataMember(Name = "nbPages", IsRequired = true, EmitDefaultValue = true)]
    public int NbPages { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class SearchRulesResponse {\n");
      sb.Append("  Hits: ").Append(Hits).Append("\n");
      sb.Append("  NbHits: ").Append(NbHits).Append("\n");
      sb.Append("  Page: ").Append(Page).Append("\n");
      sb.Append("  NbPages: ").Append(NbPages).Append("\n");
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
      return this.Equals(input as SearchRulesResponse);
    }

    /// <summary>
    /// Returns true if SearchRulesResponse instances are equal
    /// </summary>
    /// <param name="input">Instance of SearchRulesResponse to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(SearchRulesResponse input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.Hits == input.Hits ||
              this.Hits != null &&
              input.Hits != null &&
              this.Hits.SequenceEqual(input.Hits)
          ) &&
          (
              this.NbHits == input.NbHits ||
              this.NbHits.Equals(input.NbHits)
          ) &&
          (
              this.Page == input.Page ||
              this.Page.Equals(input.Page)
          ) &&
          (
              this.NbPages == input.NbPages ||
              this.NbPages.Equals(input.NbPages)
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
        if (this.Hits != null)
        {
          hashCode = (hashCode * 59) + this.Hits.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.NbHits.GetHashCode();
        hashCode = (hashCode * 59) + this.Page.GetHashCode();
        hashCode = (hashCode * 59) + this.NbPages.GetHashCode();
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
