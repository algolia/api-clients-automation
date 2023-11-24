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
  /// UpdateApiKeyResponse
  /// </summary>
  [DataContract(Name = "updateApiKeyResponse")]
  public partial class UpdateApiKeyResponse : IEquatable<UpdateApiKeyResponse>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="UpdateApiKeyResponse" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected UpdateApiKeyResponse() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="UpdateApiKeyResponse" /> class.
    /// </summary>
    /// <param name="key">API key. (required).</param>
    /// <param name="updatedAt">Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format. (required).</param>
    public UpdateApiKeyResponse(string key = default(string), string updatedAt = default(string))
    {
      // to ensure "key" is required (not null)
      if (key == null)
      {
        throw new ArgumentNullException("key is a required property for UpdateApiKeyResponse and cannot be null");
      }
      this.Key = key;
      // to ensure "updatedAt" is required (not null)
      if (updatedAt == null)
      {
        throw new ArgumentNullException("updatedAt is a required property for UpdateApiKeyResponse and cannot be null");
      }
      this.UpdatedAt = updatedAt;
    }

    /// <summary>
    /// API key.
    /// </summary>
    /// <value>API key.</value>
    [DataMember(Name = "key", IsRequired = true, EmitDefaultValue = true)]
    public string Key { get; set; }

    /// <summary>
    /// Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.
    /// </summary>
    /// <value>Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.</value>
    [DataMember(Name = "updatedAt", IsRequired = true, EmitDefaultValue = true)]
    public string UpdatedAt { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class UpdateApiKeyResponse {\n");
      sb.Append("  Key: ").Append(Key).Append("\n");
      sb.Append("  UpdatedAt: ").Append(UpdatedAt).Append("\n");
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
      return this.Equals(input as UpdateApiKeyResponse);
    }

    /// <summary>
    /// Returns true if UpdateApiKeyResponse instances are equal
    /// </summary>
    /// <param name="input">Instance of UpdateApiKeyResponse to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(UpdateApiKeyResponse input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.Key == input.Key ||
              (this.Key != null &&
              this.Key.Equals(input.Key))
          ) &&
          (
              this.UpdatedAt == input.UpdatedAt ||
              (this.UpdatedAt != null &&
              this.UpdatedAt.Equals(input.UpdatedAt))
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
        if (this.Key != null)
        {
          hashCode = (hashCode * 59) + this.Key.GetHashCode();
        }
        if (this.UpdatedAt != null)
        {
          hashCode = (hashCode * 59) + this.UpdatedAt.GetHashCode();
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
