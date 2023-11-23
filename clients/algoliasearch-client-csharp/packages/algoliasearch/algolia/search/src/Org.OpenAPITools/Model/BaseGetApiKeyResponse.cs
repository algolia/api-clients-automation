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
  /// BaseGetApiKeyResponse
  /// </summary>
  [DataContract(Name = "baseGetApiKeyResponse")]
  public partial class BaseGetApiKeyResponse : IEquatable<BaseGetApiKeyResponse>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="BaseGetApiKeyResponse" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected BaseGetApiKeyResponse() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="BaseGetApiKeyResponse" /> class.
    /// </summary>
    /// <param name="value">API key..</param>
    /// <param name="createdAt">Timestamp of creation in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). (required).</param>
    public BaseGetApiKeyResponse(string value = default(string), long createdAt = default(long))
    {
      this.CreatedAt = createdAt;
      this.Value = value;
    }

    /// <summary>
    /// API key.
    /// </summary>
    /// <value>API key.</value>
    /// <example>13ad45b4d0a2f6ea65ecbddf6aa260f2</example>
    [DataMember(Name = "value", EmitDefaultValue = false)]
    public string Value { get; set; }

    /// <summary>
    /// Timestamp of creation in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time).
    /// </summary>
    /// <value>Timestamp of creation in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time).</value>
    /// <example>1656345570000</example>
    [DataMember(Name = "createdAt", IsRequired = true, EmitDefaultValue = true)]
    public long CreatedAt { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class BaseGetApiKeyResponse {\n");
      sb.Append("  Value: ").Append(Value).Append("\n");
      sb.Append("  CreatedAt: ").Append(CreatedAt).Append("\n");
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
      return this.Equals(input as BaseGetApiKeyResponse);
    }

    /// <summary>
    /// Returns true if BaseGetApiKeyResponse instances are equal
    /// </summary>
    /// <param name="input">Instance of BaseGetApiKeyResponse to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(BaseGetApiKeyResponse input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.Value == input.Value ||
              (this.Value != null &&
              this.Value.Equals(input.Value))
          ) &&
          (
              this.CreatedAt == input.CreatedAt ||
              this.CreatedAt.Equals(input.CreatedAt)
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
        if (this.Value != null)
        {
          hashCode = (hashCode * 59) + this.Value.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.CreatedAt.GetHashCode();
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
