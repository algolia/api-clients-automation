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
  /// Source.
  /// </summary>
  [DataContract(Name = "source")]
  public partial class Source : IEquatable<Source>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="Source" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected Source() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="Source" /> class.
    /// </summary>
    /// <param name="varSource">IP address range of the source. (required).</param>
    /// <param name="description">Source description..</param>
    public Source(string varSource = default(string), string description = default(string))
    {
      // to ensure "varSource" is required (not null)
      if (varSource == null)
      {
        throw new ArgumentNullException("varSource is a required property for Source and cannot be null");
      }
      this.VarSource = varSource;
      this.Description = description;
    }

    /// <summary>
    /// IP address range of the source.
    /// </summary>
    /// <value>IP address range of the source.</value>
    /// <example>10.0.0.1/32</example>
    [DataMember(Name = "source", IsRequired = true, EmitDefaultValue = true)]
    public string VarSource { get; set; }

    /// <summary>
    /// Source description.
    /// </summary>
    /// <value>Source description.</value>
    /// <example>Server subnet</example>
    [DataMember(Name = "description", EmitDefaultValue = false)]
    public string Description { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class Source {\n");
      sb.Append("  VarSource: ").Append(VarSource).Append("\n");
      sb.Append("  Description: ").Append(Description).Append("\n");
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
      return this.Equals(input as Source);
    }

    /// <summary>
    /// Returns true if Source instances are equal
    /// </summary>
    /// <param name="input">Instance of Source to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(Source input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.VarSource == input.VarSource ||
              (this.VarSource != null &&
              this.VarSource.Equals(input.VarSource))
          ) &&
          (
              this.Description == input.Description ||
              (this.Description != null &&
              this.Description.Equals(input.Description))
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
        if (this.VarSource != null)
        {
          hashCode = (hashCode * 59) + this.VarSource.GetHashCode();
        }
        if (this.Description != null)
        {
          hashCode = (hashCode * 59) + this.Description.GetHashCode();
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
