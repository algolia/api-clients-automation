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
using FileParameter = Algolia.Search.Client.FileParameter;
using OpenAPIDateConverter = Algolia.Search.Client.OpenAPIDateConverter;

namespace Algolia.Search.Model
{
  /// <summary>
  /// SearchForFacetValuesRequest
  /// </summary>
  [DataContract(Name = "searchForFacetValuesRequest")]
  public partial class SearchForFacetValuesRequest : IEquatable<SearchForFacetValuesRequest>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="SearchForFacetValuesRequest" /> class.
    /// </summary>
    /// <param name="varParams">Search parameters as a URL-encoded query string. (default to &quot;&quot;).</param>
    /// <param name="facetQuery">Text to search inside the facet&#39;s values. (default to &quot;&quot;).</param>
    /// <param name="maxFacetHits">Maximum number of facet hits to return when [searching for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values). (default to 10).</param>
    public SearchForFacetValuesRequest(string varParams = @"", string facetQuery = @"", int maxFacetHits = 10)
    {
      // use default value if no "varParams" provided
      this.VarParams = varParams ?? @"";
      // use default value if no "facetQuery" provided
      this.FacetQuery = facetQuery ?? @"";
      this.MaxFacetHits = maxFacetHits;
    }

    /// <summary>
    /// Search parameters as a URL-encoded query string.
    /// </summary>
    /// <value>Search parameters as a URL-encoded query string.</value>
    [DataMember(Name = "params", EmitDefaultValue = false)]
    public string VarParams { get; set; }

    /// <summary>
    /// Text to search inside the facet&#39;s values.
    /// </summary>
    /// <value>Text to search inside the facet&#39;s values.</value>
    [DataMember(Name = "facetQuery", EmitDefaultValue = false)]
    public string FacetQuery { get; set; }

    /// <summary>
    /// Maximum number of facet hits to return when [searching for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).
    /// </summary>
    /// <value>Maximum number of facet hits to return when [searching for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).</value>
    [DataMember(Name = "maxFacetHits", EmitDefaultValue = false)]
    public int MaxFacetHits { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class SearchForFacetValuesRequest {\n");
      sb.Append("  VarParams: ").Append(VarParams).Append("\n");
      sb.Append("  FacetQuery: ").Append(FacetQuery).Append("\n");
      sb.Append("  MaxFacetHits: ").Append(MaxFacetHits).Append("\n");
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
      return this.Equals(input as SearchForFacetValuesRequest);
    }

    /// <summary>
    /// Returns true if SearchForFacetValuesRequest instances are equal
    /// </summary>
    /// <param name="input">Instance of SearchForFacetValuesRequest to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(SearchForFacetValuesRequest input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.VarParams == input.VarParams ||
              (this.VarParams != null &&
              this.VarParams.Equals(input.VarParams))
          ) &&
          (
              this.FacetQuery == input.FacetQuery ||
              (this.FacetQuery != null &&
              this.FacetQuery.Equals(input.FacetQuery))
          ) &&
          (
              this.MaxFacetHits == input.MaxFacetHits ||
              this.MaxFacetHits.Equals(input.MaxFacetHits)
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
        if (this.VarParams != null)
        {
          hashCode = (hashCode * 59) + this.VarParams.GetHashCode();
        }
        if (this.FacetQuery != null)
        {
          hashCode = (hashCode * 59) + this.FacetQuery.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.MaxFacetHits.GetHashCode();
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
      // MaxFacetHits (int) maximum
      if (this.MaxFacetHits > (int)100)
      {
        yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for MaxFacetHits, must be a value less than or equal to 100.", new[] { "MaxFacetHits" });
      }

      yield break;
    }
  }

}
