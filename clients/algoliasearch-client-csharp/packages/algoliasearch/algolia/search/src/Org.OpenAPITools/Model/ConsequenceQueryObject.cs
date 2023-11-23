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
  /// ConsequenceQueryObject
  /// </summary>
  [DataContract(Name = "consequenceQueryObject")]
  public partial class ConsequenceQueryObject : IEquatable<ConsequenceQueryObject>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="ConsequenceQueryObject" /> class.
    /// </summary>
    /// <param name="remove">Words to remove..</param>
    /// <param name="edits">Edits to apply..</param>
    public ConsequenceQueryObject(List<string> remove = default(List<string>), List<Edit> edits = default(List<Edit>))
    {
      this.Remove = remove;
      this.Edits = edits;
    }

    /// <summary>
    /// Words to remove.
    /// </summary>
    /// <value>Words to remove.</value>
    [DataMember(Name = "remove", EmitDefaultValue = false)]
    public List<string> Remove { get; set; }

    /// <summary>
    /// Edits to apply.
    /// </summary>
    /// <value>Edits to apply.</value>
    [DataMember(Name = "edits", EmitDefaultValue = false)]
    public List<Edit> Edits { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class ConsequenceQueryObject {\n");
      sb.Append("  Remove: ").Append(Remove).Append("\n");
      sb.Append("  Edits: ").Append(Edits).Append("\n");
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
      return this.Equals(input as ConsequenceQueryObject);
    }

    /// <summary>
    /// Returns true if ConsequenceQueryObject instances are equal
    /// </summary>
    /// <param name="input">Instance of ConsequenceQueryObject to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(ConsequenceQueryObject input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.Remove == input.Remove ||
              this.Remove != null &&
              input.Remove != null &&
              this.Remove.SequenceEqual(input.Remove)
          ) &&
          (
              this.Edits == input.Edits ||
              this.Edits != null &&
              input.Edits != null &&
              this.Edits.SequenceEqual(input.Edits)
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
        if (this.Remove != null)
        {
          hashCode = (hashCode * 59) + this.Remove.GetHashCode();
        }
        if (this.Edits != null)
        {
          hashCode = (hashCode * 59) + this.Edits.GetHashCode();
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
