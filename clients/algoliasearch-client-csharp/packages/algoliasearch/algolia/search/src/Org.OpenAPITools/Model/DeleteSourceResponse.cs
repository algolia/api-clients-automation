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
  /// DeleteSourceResponse
  /// </summary>
  [DataContract(Name = "deleteSourceResponse")]
  public partial class DeleteSourceResponse : IEquatable<DeleteSourceResponse>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="DeleteSourceResponse" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected DeleteSourceResponse() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="DeleteSourceResponse" /> class.
    /// </summary>
    /// <param name="deletedAt">Timestamp of deletion in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format. (required).</param>
    public DeleteSourceResponse(string deletedAt = default(string))
    {
      // to ensure "deletedAt" is required (not null)
      if (deletedAt == null)
      {
        throw new ArgumentNullException("deletedAt is a required property for DeleteSourceResponse and cannot be null");
      }
      this.DeletedAt = deletedAt;
    }

    /// <summary>
    /// Timestamp of deletion in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.
    /// </summary>
    /// <value>Timestamp of deletion in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.</value>
    /// <example>2023-06-27T14:42:38.831Z</example>
    [DataMember(Name = "deletedAt", IsRequired = true, EmitDefaultValue = true)]
    public string DeletedAt { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class DeleteSourceResponse {\n");
      sb.Append("  DeletedAt: ").Append(DeletedAt).Append("\n");
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
      return this.Equals(input as DeleteSourceResponse);
    }

    /// <summary>
    /// Returns true if DeleteSourceResponse instances are equal
    /// </summary>
    /// <param name="input">Instance of DeleteSourceResponse to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(DeleteSourceResponse input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.DeletedAt == input.DeletedAt ||
              (this.DeletedAt != null &&
              this.DeletedAt.Equals(input.DeletedAt))
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
        if (this.DeletedAt != null)
        {
          hashCode = (hashCode * 59) + this.DeletedAt.GetHashCode();
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
