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
  /// Rules search parameters.
  /// </summary>
  [DataContract(Name = "searchRulesParams")]
  public partial class SearchRulesParams : IEquatable<SearchRulesParams>, IValidatableObject
  {

    /// <summary>
    /// Gets or Sets Anchoring
    /// </summary>
    [DataMember(Name = "anchoring", EmitDefaultValue = false)]
    public Anchoring? Anchoring { get; set; }
    /// <summary>
    /// Initializes a new instance of the <see cref="SearchRulesParams" /> class.
    /// </summary>
    /// <param name="query">Rule object query. (default to &quot;&quot;).</param>
    /// <param name="anchoring">anchoring.</param>
    /// <param name="context">Restricts responses to the specified [contextual rule](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#creating-contextual-rules)..</param>
    /// <param name="page">Requested page (the first page is page 0)..</param>
    /// <param name="hitsPerPage">Maximum number of hits per page. (default to 20).</param>
    /// <param name="enabled">Restricts responses to enabled rules. When not specified (default), _all_ rules are retrieved..</param>
    /// <param name="requestOptions">Request options to send with the API call..</param>
    public SearchRulesParams(string query = @"", Anchoring? anchoring = default(Anchoring?), string context = default(string), int page = default(int), int hitsPerPage = 20, bool? enabled = default(bool?), List<Object> requestOptions = default(List<Object>))
    {
      // use default value if no "query" provided
      this.Query = query ?? @"";
      this.Anchoring = anchoring;
      this.Context = context;
      this.Page = page;
      this.HitsPerPage = hitsPerPage;
      this.Enabled = enabled;
      this.RequestOptions = requestOptions;
    }

    /// <summary>
    /// Rule object query.
    /// </summary>
    /// <value>Rule object query.</value>
    [DataMember(Name = "query", EmitDefaultValue = false)]
    public string Query { get; set; }

    /// <summary>
    /// Restricts responses to the specified [contextual rule](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#creating-contextual-rules).
    /// </summary>
    /// <value>Restricts responses to the specified [contextual rule](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#creating-contextual-rules).</value>
    /// <example>mobile</example>
    [DataMember(Name = "context", EmitDefaultValue = false)]
    public string Context { get; set; }

    /// <summary>
    /// Requested page (the first page is page 0).
    /// </summary>
    /// <value>Requested page (the first page is page 0).</value>
    [DataMember(Name = "page", EmitDefaultValue = false)]
    public int Page { get; set; }

    /// <summary>
    /// Maximum number of hits per page.
    /// </summary>
    /// <value>Maximum number of hits per page.</value>
    [DataMember(Name = "hitsPerPage", EmitDefaultValue = false)]
    public int HitsPerPage { get; set; }

    /// <summary>
    /// Restricts responses to enabled rules. When not specified (default), _all_ rules are retrieved.
    /// </summary>
    /// <value>Restricts responses to enabled rules. When not specified (default), _all_ rules are retrieved.</value>
    [DataMember(Name = "enabled", EmitDefaultValue = true)]
    public bool? Enabled { get; set; }

        /// <summary>
        /// Request options to send with the API call.
        /// </summary>
        /// <value>Request options to send with the API call.</value>
        /// <example>{timeouts:{read:20}}
</example>
        [DataMember(Name = "requestOptions", EmitDefaultValue = false)]
    public List<Object> RequestOptions { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class SearchRulesParams {\n");
      sb.Append("  Query: ").Append(Query).Append("\n");
      sb.Append("  Anchoring: ").Append(Anchoring).Append("\n");
      sb.Append("  Context: ").Append(Context).Append("\n");
      sb.Append("  Page: ").Append(Page).Append("\n");
      sb.Append("  HitsPerPage: ").Append(HitsPerPage).Append("\n");
      sb.Append("  Enabled: ").Append(Enabled).Append("\n");
      sb.Append("  RequestOptions: ").Append(RequestOptions).Append("\n");
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
      return this.Equals(input as SearchRulesParams);
    }

    /// <summary>
    /// Returns true if SearchRulesParams instances are equal
    /// </summary>
    /// <param name="input">Instance of SearchRulesParams to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(SearchRulesParams input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.Query == input.Query ||
              (this.Query != null &&
              this.Query.Equals(input.Query))
          ) &&
          (
              this.Anchoring == input.Anchoring ||
              this.Anchoring.Equals(input.Anchoring)
          ) &&
          (
              this.Context == input.Context ||
              (this.Context != null &&
              this.Context.Equals(input.Context))
          ) &&
          (
              this.Page == input.Page ||
              this.Page.Equals(input.Page)
          ) &&
          (
              this.HitsPerPage == input.HitsPerPage ||
              this.HitsPerPage.Equals(input.HitsPerPage)
          ) &&
          (
              this.Enabled == input.Enabled ||
              (this.Enabled != null &&
              this.Enabled.Equals(input.Enabled))
          ) &&
          (
              this.RequestOptions == input.RequestOptions ||
              this.RequestOptions != null &&
              input.RequestOptions != null &&
              this.RequestOptions.SequenceEqual(input.RequestOptions)
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
        if (this.Query != null)
        {
          hashCode = (hashCode * 59) + this.Query.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.Anchoring.GetHashCode();
        if (this.Context != null)
        {
          hashCode = (hashCode * 59) + this.Context.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.Page.GetHashCode();
        hashCode = (hashCode * 59) + this.HitsPerPage.GetHashCode();
        if (this.Enabled != null)
        {
          hashCode = (hashCode * 59) + this.Enabled.GetHashCode();
        }
        if (this.RequestOptions != null)
        {
          hashCode = (hashCode * 59) + this.RequestOptions.GetHashCode();
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
      // Page (int) minimum
      if (this.Page < (int)0)
      {
        yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for Page, must be a value greater than or equal to 0.", new[] { "Page" });
      }

      // HitsPerPage (int) maximum
      if (this.HitsPerPage > (int)1000)
      {
        yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for HitsPerPage, must be a value less than or equal to 1000.", new[] { "HitsPerPage" });
      }

      // HitsPerPage (int) minimum
      if (this.HitsPerPage < (int)1)
      {
        yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for HitsPerPage, must be a value greater than or equal to 1.", new[] { "HitsPerPage" });
      }

      yield break;
    }
  }

}
