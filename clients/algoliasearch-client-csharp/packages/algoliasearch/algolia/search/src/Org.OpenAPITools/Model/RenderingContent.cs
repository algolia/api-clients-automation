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
  /// Extra content for the search UI, for example, to control the [ordering and display of facets](https://www.algolia.com/doc/guides/managing-results/rules/merchandising-and-promoting/how-to/merchandising-facets/#merchandise-facets-and-their-values-in-the-manual-editor). You can set a default value and dynamically override it with [Rules](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/).
  /// </summary>
  [DataContract(Name = "renderingContent")]
  public partial class RenderingContent : IEquatable<RenderingContent>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="RenderingContent" /> class.
    /// </summary>
    /// <param name="facetOrdering">facetOrdering.</param>
    public RenderingContent(FacetOrdering facetOrdering = default(FacetOrdering))
    {
      this.FacetOrdering = facetOrdering;
    }

    /// <summary>
    /// Gets or Sets FacetOrdering
    /// </summary>
    [DataMember(Name = "facetOrdering", EmitDefaultValue = false)]
    public FacetOrdering FacetOrdering { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class RenderingContent {\n");
      sb.Append("  FacetOrdering: ").Append(FacetOrdering).Append("\n");
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
      return this.Equals(input as RenderingContent);
    }

    /// <summary>
    /// Returns true if RenderingContent instances are equal
    /// </summary>
    /// <param name="input">Instance of RenderingContent to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(RenderingContent input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.FacetOrdering == input.FacetOrdering ||
              (this.FacetOrdering != null &&
              this.FacetOrdering.Equals(input.FacetOrdering))
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
        if (this.FacetOrdering != null)
        {
          hashCode = (hashCode * 59) + this.FacetOrdering.GetHashCode();
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
