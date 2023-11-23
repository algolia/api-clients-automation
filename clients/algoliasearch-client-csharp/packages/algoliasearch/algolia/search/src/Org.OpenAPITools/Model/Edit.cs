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
  /// Edit
  /// </summary>
  [DataContract(Name = "edit")]
  public partial class Edit : IEquatable<Edit>, IValidatableObject
  {

    /// <summary>
    /// Gets or Sets Type
    /// </summary>
    [DataMember(Name = "type", EmitDefaultValue = false)]
    public EditType? Type { get; set; }
    /// <summary>
    /// Initializes a new instance of the <see cref="Edit" /> class.
    /// </summary>
    /// <param name="type">type.</param>
    /// <param name="delete">Text or patterns to remove from the query string..</param>
    /// <param name="insert">Text that should be inserted in place of the removed text inside the query string..</param>
    public Edit(EditType? type = default(EditType?), string delete = default(string), string insert = default(string))
    {
      this.Type = type;
      this.Delete = delete;
      this.Insert = insert;
    }

    /// <summary>
    /// Text or patterns to remove from the query string.
    /// </summary>
    /// <value>Text or patterns to remove from the query string.</value>
    [DataMember(Name = "delete", EmitDefaultValue = false)]
    public string Delete { get; set; }

    /// <summary>
    /// Text that should be inserted in place of the removed text inside the query string.
    /// </summary>
    /// <value>Text that should be inserted in place of the removed text inside the query string.</value>
    [DataMember(Name = "insert", EmitDefaultValue = false)]
    public string Insert { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class Edit {\n");
      sb.Append("  Type: ").Append(Type).Append("\n");
      sb.Append("  Delete: ").Append(Delete).Append("\n");
      sb.Append("  Insert: ").Append(Insert).Append("\n");
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
      return this.Equals(input as Edit);
    }

    /// <summary>
    /// Returns true if Edit instances are equal
    /// </summary>
    /// <param name="input">Instance of Edit to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(Edit input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.Type == input.Type ||
              this.Type.Equals(input.Type)
          ) &&
          (
              this.Delete == input.Delete ||
              (this.Delete != null &&
              this.Delete.Equals(input.Delete))
          ) &&
          (
              this.Insert == input.Insert ||
              (this.Insert != null &&
              this.Insert.Equals(input.Insert))
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
        hashCode = (hashCode * 59) + this.Type.GetHashCode();
        if (this.Delete != null)
        {
          hashCode = (hashCode * 59) + this.Delete.GetHashCode();
        }
        if (this.Insert != null)
        {
          hashCode = (hashCode * 59) + this.Insert.GetHashCode();
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
